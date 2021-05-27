package vn.hoapm.springboot.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vn.hoapm.springboot.account.factory.UserSearch;
import vn.hoapm.springboot.account.presentaion.LoginRequest;
import vn.hoapm.springboot.account.presentaion.LoginResponse;
import vn.hoapm.springboot.account.presentaion.UserResponse;
import vn.hoapm.springboot.account.presentaion.UserRequest;
import vn.hoapm.springboot.account.service.UserService;
import vn.hoapm.springboot.common.APIResponse;
import vn.hoapm.springboot.config.jwt.CustomUserDetails;
import vn.hoapm.springboot.config.jwt.JwtTokenProvider;
import vn.hoapm.springboot.rest.mapper.UserJSONMapper;

import javax.validation.Valid;

@RestController
public class UserController {
    private static final String USERS = "/users";
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(USERS + "/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable("username") String username) {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserSearch(new UserSearch(username));
        UserResponse userResponse = userService.findByUsername(userRequest);
        UserJSONResponse jsonResponse = UserJSONMapper.getInstance().fromResponse(userResponse);
        APIResponse<UserJSONResponse> apiResponse = new APIResponse<>();
        return apiResponse.sendResponse(jsonResponse, HttpStatus.OK.value(), "user.success.find_by_username");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //return jwt cho nguoi dung
        String jwt = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        LoginResponse loginResponse = new LoginResponse(jwt);
        APIResponse<LoginResponse> apiResponse = new APIResponse<>();
        return apiResponse.sendResponse(loginResponse, HttpStatus.OK.value(), "login_success");
    }

    @PostMapping("/register")
    // register for account with role is USER
    public ResponseEntity<?> register(@RequestBody UserJSONRequest jsonRequest ){
        jsonRequest.setRoleCode(USER_ROLE);
        UserRequest request = UserJSONMapper.getInstance().fromJsonRequest(jsonRequest);
        UserResponse userResponse = userService.register(request);
        UserJSONResponse jsonResponse = UserJSONMapper.getInstance().fromResponse(userResponse);
        APIResponse<UserJSONResponse> apiResponse = new APIResponse<>();
        return apiResponse.sendResponse(jsonResponse, HttpStatus.OK.value(), "user.success.register");
    }

    @PostMapping("/admin")
    // register for account with role is ADMIN
    public ResponseEntity<?> createAdminAccount(@RequestBody UserJSONRequest jsonRequest ){
        jsonRequest.setRoleCode(ADMIN_ROLE);
        UserRequest request = UserJSONMapper.getInstance().fromJsonRequest(jsonRequest);
        UserResponse userResponse = userService.register(request);
        UserJSONResponse jsonResponse = UserJSONMapper.getInstance().fromResponse(userResponse);
        APIResponse<UserJSONResponse> apiResponse = new APIResponse<>();
        return apiResponse.sendResponse(jsonResponse, HttpStatus.OK.value(), "user.success.register");
    }


}
