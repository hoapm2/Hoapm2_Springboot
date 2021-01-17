package vn.hoapm.springboot.rest.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hoapm.springboot.common.APIResponse;
import vn.hoapm.springboot.mapper.TestJSONMapper;
import vn.hoapm.springboot.test.factory.Test;
import vn.hoapm.springboot.test.presentation.TestListResponse;
import vn.hoapm.springboot.test.presentation.TestRequest;
import vn.hoapm.springboot.test.presentation.TestResponse;
import vn.hoapm.springboot.test.service.TestService;

@RestController
public class TestController {
    private static final String TEST = "/test";
    private TestService testService;
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(TEST)
    public ResponseEntity<?> getALl(TestJSONRequest jsonRequest)   {
        TestListResponse listResponse = testService.getAll();
        TestListJSONResponse listJSONResponse= TestJSONMapper.getInstance().fromListResponse(listResponse);
        APIResponse<TestListJSONResponse> apiResponse = new APIResponse<>();
        return apiResponse.sendResponse(listJSONResponse, HttpStatus.OK.value(), "test.success.get_data");
    }
    @PutMapping(TEST + "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TestJSONRequest jsonRequest) throws
            Exception {
        jsonRequest.setId(id);
        TestRequest request = TestJSONMapper.getInstance().fromJSONRequest(jsonRequest);
        Test obj = testService.update(request);
        TestJSONResponse jsonResponse = TestJSONMapper.getInstance().fromObj(obj);
        APIResponse<TestJSONResponse> apiResponse =new APIResponse<>();
        return apiResponse.sendResponse(jsonResponse, HttpStatus.OK.value(), "test.success.update");
    }

}
