package uz.zako.lesson53_jwt.payload;

import lombok.Data;

@Data
public class LoginPayload {

    private String username;
    private String password;
}
