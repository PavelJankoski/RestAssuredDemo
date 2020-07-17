package mk.ukim.finki.skit.additionalactivity.service;

import mk.ukim.finki.skit.additionalactivity.model.Professor;
import mk.ukim.finki.skit.additionalactivity.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();

    Subject findSubjectById(long id);

    Subject createSubject(Subject subject);

    Subject editSubject(Subject subject);

    void deleteSubject(long id);
}
