package uz.zako.lesson53_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.zako.lesson53_jwt.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
