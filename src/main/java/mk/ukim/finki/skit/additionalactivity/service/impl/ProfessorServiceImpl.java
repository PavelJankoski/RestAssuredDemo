package mk.ukim.finki.skit.additionalactivity.service.impl;

import mk.ukim.finki.skit.additionalactivity.model.Professor;
import mk.ukim.finki.skit.additionalactivity.repository.ProfessorRepository;
import mk.ukim.finki.skit.additionalactivity.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> getAllProfessors() {
        return this.professorRepository.findAll();
    }

    @Override
    public Professor findProfessorById(long id) {
        return this.professorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Professor createProfessor(Professor professor) {
        return this.professorRepository.saveAndFlush(professor);
    }

    @Override
    public Professor editProfessor(Professor professor) {
        findProfessorById(professor.getId());
        return this.professorRepository.saveAndFlush(professor);
    }

    @Override
    public void deleteProfessor(long id) {
        Professor professor = findProfessorById(id);
        this.professorRepository.delete(professor);
    }
}
