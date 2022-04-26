package uz.zako.lesson53_jwt.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.zako.lesson53_jwt.entity.Admin;
import uz.zako.lesson53_jwt.entity.Role;
import uz.zako.lesson53_jwt.entity.User;
import uz.zako.lesson53_jwt.repository.AdminRepository;
import uz.zako.lesson53_jwt.repository.RoleRepository;
import uz.zako.lesson53_jwt.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)--hammasini private qilib oladi qoymasak ham
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;


    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;

    @Override
    public void run(String... args) throws Exception {

        try {
            if (init.equalsIgnoreCase("create")) {
                Role roleUser = new Role();
                roleUser.setName("ROLE_USER");
                roleUser.setId(1L);
                Role roleAdmin = new Role(2L, "ROLE_ADMIN");
                List<Role> roleList = new ArrayList<>(Arrays.asList(roleUser, roleAdmin));
                roleRepository.saveAll(roleList);
                User user = new User();
                Admin admin = new Admin();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setFullName("user");
                user.setRoles(new ArrayList<>(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("root"));
                admin.setSocial("t.me/test");
                admin.setRoles(roleList);
                System.out.println(admin.getPassword()+"=admin=");
                userRepository.save(user);
                adminRepository.save(admin);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
