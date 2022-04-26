package uz.zako.lesson53_jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.zako.lesson53_jwt.entity.User;
import uz.zako.lesson53_jwt.payload.UserPayload;
import uz.zako.lesson53_jwt.service.UserService;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/test")
    public String sayHello(){
        return "Hi! Admin";
    }

    @PutMapping("/user/{id}")
    public User editUser(@PathVariable Long id, @RequestBody UserPayload payload){
        return userService.edit(id,payload);
    }
}
