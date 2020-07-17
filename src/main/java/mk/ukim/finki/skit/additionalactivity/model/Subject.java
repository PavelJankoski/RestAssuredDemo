package mk.ukim.finki.skit.additionalactivity.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subject_name")
    private String name;

    @ManyToMany(targetEntity = Professor.class)
    private Set<Professor> professors;

    public Subject(String name, Set<Professor> professors){
        this.name = name;
        this.professors = professors;
    }

}
