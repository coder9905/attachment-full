package uz.zako.lesson53_jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import uz.zako.lesson53_jwt.entity.User;
import uz.zako.lesson53_jwt.model.Result;
import uz.zako.lesson53_jwt.payload.LoginPayload;
import uz.zako.lesson53_jwt.repository.UserRepository;
import uz.zako.lesson53_jwt.security.JwtTokenProvider;
import uz.zako.lesson53_jwt.security.SecurityUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final SecurityUtils securityUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginPayload loginPayload){
        User user=userRepository.findByUsername(loginPayload.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginPayload.getUsername(),loginPayload.getPassword()));
        String token=jwtTokenProvider.createToken(user.getUsername(),user.getRoles());
        System.out.println(token.toString());
        if (token==null){
            return new ResponseEntity(new Result(false,"error",null), HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> map=new HashMap();
        map.put("token",token);
        map.put("username",true);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/all")
    public String get(){
        return "hello:)";
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMe(){
        String username=securityUtils.getCurrentUser().orElseThrow(()->new RuntimeException("error"));
        System.out.println(username);
//        return ResponseEntity.ok("ok");
        return ResponseEntity.ok(userRepository.findByUsername(username));
    }

}
