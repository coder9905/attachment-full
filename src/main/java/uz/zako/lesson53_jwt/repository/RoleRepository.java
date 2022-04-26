package uz.zako.lesson53_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.zako.lesson53_jwt.entity.Role;
import uz.zako.lesson53_jwt.entity.User;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
