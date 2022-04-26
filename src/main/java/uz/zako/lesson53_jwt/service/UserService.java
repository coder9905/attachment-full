package uz.zako.lesson53_jwt.service;

import uz.zako.lesson53_jwt.entity.User;
import uz.zako.lesson53_jwt.payload.UserPayload;

public interface UserService {
    User edit(Long id, UserPayload payload);
}
