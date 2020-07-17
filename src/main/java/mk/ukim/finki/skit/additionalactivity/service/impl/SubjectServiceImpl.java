package mk.ukim.finki.skit.additionalactivity.service.impl;

import mk.ukim.finki.skit.additionalactivity.model.Professor;
import mk.ukim.finki.skit.additionalactivity.model.Subject;
import mk.ukim.finki.skit.additionalactivity.repository.SubjectRepository;
import mk.ukim.finki.skit.additionalactivity.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return this.subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectById(long id) {
        return this.subjectRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Subject createSubject(Subject subject) {
        return this.subjectRepository.saveAndFlush(subject);
    }

    @Override
    public Subject editSubject(Subject subject) {
        findSubjectById(subject.getId());
        return this.subjectRepository.saveAndFlush(subject);
    }

    @Override
    public void deleteSubject(long id) {
        Subject subject = findSubjectById(id);
        this.subjectRepository.delete(subject);

    }
}
