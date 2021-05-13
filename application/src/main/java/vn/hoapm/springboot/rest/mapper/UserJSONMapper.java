package vn.hoapm.springboot.rest.mapper;

import vn.hoapm.springboot.account.factory.UserCUD;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.UserRequest;
import vn.hoapm.springboot.account.presentaion.UserResponse;
import vn.hoapm.springboot.rest.user.UserJSONRequest;
import vn.hoapm.springboot.rest.user.UserJSONResponse;
import vn.hoapm.springboot.shared.PagingSortFilter;

import java.sql.Timestamp;

public class UserJSONMapper {
    private static UserJSONMapper INSTANCE;

    public UserJSONMapper() {

    }

    public static UserJSONMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserJSONMapper();
        }
        return INSTANCE;
    }

    public UserJSONResponse fromResponse(UserResponse userResponse) {
        UserJSONResponse userJSONResponse = new UserJSONResponse();
        if (userResponse != null) {
            userJSONResponse.setUsername(userResponse.getUsername());
        }
        return userJSONResponse;
    }

    public UserRequest fromJsonRequest(UserJSONRequest jsonRequest){
        UserRequest request = new UserRequest();
        if (jsonRequest!=null){
            // Map to search
            UserSearch search = UserSearch.builder()
                    .username(jsonRequest.getUsername())
                    .name(jsonRequest.getName())
                    .build();
            //Map to paging
            PagingSortFilter filter = new PagingSortFilter()
                    .withAsc(jsonRequest.getAsc())
                    .withPageIndex(jsonRequest.getPageIndex())
                    .withPageIndex(jsonRequest.getPageIndex())
                    .withSearchSuggest(jsonRequest.getSearchSuggest())
                    .withGlobalSearch(jsonRequest.getGlobalSearch());
            // Map to CUD
            UserCUD cud = UserCUD.builder()
                    .id(jsonRequest.getId())
                    .username(jsonRequest.getUsername())
                    .password(jsonRequest.getPassword())
                    .role(jsonRequest.getRole())
                    .email(jsonRequest.getEmail())
                    .phone(jsonRequest.getPhone())
                    .utimestamp(jsonRequest.getUtimestamp()!=null? Timestamp.from(jsonRequest.getUtimestamp()):null)
                    .build();
            request.setCud(cud);
            request.setUserSearch(search);
            request.setPagingSortFilter(filter);
        }
        return request;
    }

}
