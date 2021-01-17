package vn.hoapm.springboot.mapper;

import org.springframework.util.StringUtils;
import vn.hoapm.springboot.rest.test.TestJSONRequest;
import vn.hoapm.springboot.rest.test.TestJSONResponse;
import vn.hoapm.springboot.rest.test.TestListJSONResponse;
import vn.hoapm.springboot.test.core.TestId;
import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.presentation.TestListResponse;
import vn.hoapm.springboot.test.presentation.TestRequest;

import java.util.ArrayList;
import java.util.List;

public class TestJSONMapper {
    private static TestJSONMapper INSTANCE;

    private TestJSONMapper() {
    }

    public static TestJSONMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestJSONMapper();
        }
        return INSTANCE;
    }

    public TestRequest fromJSONRequest(TestJSONRequest jsonRequest)  {
        TestRequest request = new TestRequest();
        if (jsonRequest != null) {
            request.setTestId(new TestId(jsonRequest.getId()));
            request.setName(jsonRequest.getName());
            request.setUTimestamp(jsonRequest.getUTimeStamp());
        }
        return request;
    }
//
//    public StorageSearchRequest fromJSONRequestToSearchRequest(StorageJSONRequest jsonRequest) {
//        StorageSearchRequest storageSearchRequest = new StorageSearchRequest();
//        if (jsonRequest != null) {
//            StorageSearch storageSearch = new StorageSearch();
//            StorageId storageId = new StorageId();
//            storageId.setId(jsonRequest.getId());
//            storageId.setShortId(jsonRequest.getShortId());
//            storageSearch.setStorageId(storageId);
//            storageSearch.setName(jsonRequest.getName());
//            storageSearch.setSearchSuggest(jsonRequest.getSearchSuggest());
//            storageSearch.setGlobalSearch(jsonRequest.getGlobalSearch());
//
//            PagingSortFilter pagingSortFilter = new PagingSortFilter()
//                    .withPageIndex(jsonRequest.getPageIndex())
//                    .withPageSize(jsonRequest.getPageSize())
//                    .withAsc(jsonRequest.getAsc())
//                    .withFieldSort(jsonRequest.getFieldSort());
//            storageSearchRequest.setStorageSearch(storageSearch);
//            storageSearchRequest.setPagingSortFilter(pagingSortFilter);
//        }
//        return storageSearchRequest;
//    }

    public TestListJSONResponse fromListResponse(TestListResponse listResponse) {
        TestListJSONResponse testListJSONResponse = new TestListJSONResponse();
        if (listResponse != null) {
            List<TestJSONResponse> jsonResponses = new ArrayList<>();
            for (Test test : listResponse.getTests()
            ) {
                jsonResponses.add(TestJSONMapper.getInstance().fromObj(test));
            }
            testListJSONResponse.setTests(jsonResponses);
//            storageListJSONResponse.setTotalCount(listResponse.getTotalCount());
        }
        return testListJSONResponse;
    }

    public TestJSONResponse fromObj(Test obj) {
        TestJSONResponse jsonResponse = new TestJSONResponse();
        if (obj != null) {
            jsonResponse.setId(obj.getId());
            jsonResponse.setName(obj.getName());
            jsonResponse.setUTimestamp(obj.getAuditLog().getUTimestamp().toInstant());
        }
        return jsonResponse;
    }
//
//    public StorageRequest fromJSONRequestUpdate(Long id, StorageJSONRequest jsonRequest) {
//        StorageRequest request = new StorageRequest();
//        if (jsonRequest != null) {
//            StorageCUD storageCUD = new StorageCUD();
//            storageCUD.setId(id);
//            storageCUD.setName(jsonRequest.getName());
//            storageCUD.setAddress(jsonRequest.getAddress());
//            storageCUD.setUTimestamp(jsonRequest.getUTimestamp());
//            storageCUD.setManager(jsonRequest.getManager());
//            storageCUD.setInformationManager(jsonRequest.getInformationManager());
//            storageCUD.setDescription(jsonRequest.getDescription());
//            storageCUD.setShortId(jsonRequest.getShortId());
//            storageCUD.setStatus(jsonRequest.getStatus());
//            request.setStorageCUD(storageCUD);
//        }
//        return request;
//    }

    public Boolean validateName(String name) {
        return StringUtils.isEmpty(name);
    }

    public Boolean validateAddress(String address) {
        return StringUtils.isEmpty(address);
    }
}
