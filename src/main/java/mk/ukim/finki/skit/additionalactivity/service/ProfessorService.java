package mk.ukim.finki.skit.additionalactivity.service;

import mk.ukim.finki.skit.additionalactivity.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> getAllProfessors();

    Professor findProfessorById(long id);

    Professor createProfessor(Professor professor);

    Professor editProfessor(Professor professor);

    void deleteProfessor(long id);
}
