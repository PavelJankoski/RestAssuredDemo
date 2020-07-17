package mk.ukim.finki.skit.additionalactivity.web;

import mk.ukim.finki.skit.additionalactivity.model.Subject;
import mk.ukim.finki.skit.additionalactivity.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/subjects", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping
    public ResponseEntity<List<Subject>> listSubjects(){
        return ResponseEntity.ok().body(this.subjectService.getAllSubjects());
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("subjectId") long id){
        return ResponseEntity.ok().body(this.subjectService.findSubjectById(id));
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
        return ResponseEntity.ok().body(this.subjectService.createSubject(subject));
    }

    @PatchMapping("/{subjectId}")
    public ResponseEntity<Subject> updateSubject(@PathVariable("subjectId") long id, @RequestBody Subject subject){
        subject.setId(id);
        return ResponseEntity.ok().body(this.subjectService.editSubject(subject));
    }

    @DeleteMapping("/{subjectId}")
    public HttpStatus deleteSubject(@PathVariable("subjectId") long id){
        this.subjectService.deleteSubject(id);
        return HttpStatus.OK;
    }
}
