package mk.ukim.finki.skit.additionalactivity.repository;

import mk.ukim.finki.skit.additionalactivity.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
