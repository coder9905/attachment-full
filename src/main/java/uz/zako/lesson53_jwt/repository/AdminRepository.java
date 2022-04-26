package uz.zako.lesson53_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.zako.lesson53_jwt.entity.Admin;
import uz.zako.lesson53_jwt.entity.User;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
