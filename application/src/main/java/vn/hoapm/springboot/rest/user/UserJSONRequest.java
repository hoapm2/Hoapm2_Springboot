package vn.hoapm.springboot.rest.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.hoapm.springboot.shared.CommonPagingAndSort;
import vn.hoapm.springboot.shared.PagingSortFilter;

import java.time.Instant;

@Data
public class UserJSONRequest extends PagingSortFilter {
    private Long id;
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String phone;
    private String email;
    private Integer role;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ",timezone = "UTC")
    private Instant utimestamp;
}
