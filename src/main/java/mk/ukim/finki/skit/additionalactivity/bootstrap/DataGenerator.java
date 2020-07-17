package mk.ukim.finki.skit.additionalactivity.bootstrap;

import lombok.Getter;
import mk.ukim.finki.skit.additionalactivity.model.Professor;
import mk.ukim.finki.skit.additionalactivity.model.Subject;
import mk.ukim.finki.skit.additionalactivity.repository.ProfessorRepository;
import mk.ukim.finki.skit.additionalactivity.repository.SubjectRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
@Getter
public class DataGenerator {
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    public DataGenerator(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    @PostConstruct
    public void init(){
        if(this.professorRepository.findAll().size()==0){
            Professor professor1 = new Professor("ProfessorTest1", 30);
            Professor professor2 = new Professor("ProfessorTest2", 40);
            Professor professor3 = new Professor("ProfessorTest3", 50);
            this.professorRepository.saveAndFlush(professor1);
            this.professorRepository.saveAndFlush(professor2);
            this.professorRepository.saveAndFlush(professor3);


            Set<Professor> dataStructures = new HashSet<>();
            dataStructures.add(professor1);
            dataStructures.add(professor3);
            Subject subject1 = new Subject("Data structures", dataStructures);
            Set<Professor> artificialIntelligence = new HashSet<>();
            artificialIntelligence.add(professor2);
            Subject subject2 = new Subject("Artificial Intelligence", artificialIntelligence);
            this.subjectRepository.saveAndFlush(subject1);
            this.subjectRepository.saveAndFlush(subject2);
        }
    }
}
