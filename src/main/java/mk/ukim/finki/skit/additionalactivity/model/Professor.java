package mk.ukim.finki.skit.additionalactivity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "professors")
@NoArgsConstructor
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int age;


    public Professor(String name, int age){
        this.name = name;
        this.age = age;
    }
}
