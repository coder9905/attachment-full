package uz.zako.lesson53_jwt.payload;

import lombok.Data;

@Data
public class UserPayload {

    private String username;
    private String password;
    private String fullName;
}
