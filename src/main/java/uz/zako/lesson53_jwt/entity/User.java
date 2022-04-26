package uz.zako.lesson53_jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uz.zako.lesson53_jwt.entity.abstractEntity.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")//hohlagancha yoza olasz cheksiz
    private String username;

    private String password;

    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
