package uz.zako.lesson53_jwt.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.zako.lesson53_jwt.entity.User;
import uz.zako.lesson53_jwt.exception.ResourceNotFoundException;
import uz.zako.lesson53_jwt.payload.UserPayload;
import uz.zako.lesson53_jwt.repository.UserRepository;
import uz.zako.lesson53_jwt.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserserviceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User edit(Long id,UserPayload payload){
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found"));
        user.setFullName(payload.getFullName());
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        user.setUsername(payload.getUsername());
        return user;
    }

}
