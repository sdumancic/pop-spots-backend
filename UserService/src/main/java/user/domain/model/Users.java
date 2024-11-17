package user.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "[Users]", schema = "[Core]")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "object_id", length = 50)
    private String objectId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "gender", length = 1)
    private String gender;
}