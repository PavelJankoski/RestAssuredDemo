package mk.ukim.finki.skit.additionalactivity.web;

import mk.ukim.finki.skit.additionalactivity.model.Professor;
import mk.ukim.finki.skit.additionalactivity.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/professors", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listProfessors(){
        return ResponseEntity.ok().body(this.professorService.getAllProfessors());
    }

    @GetMapping("/{professorId}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable("professorId") long id){
        return ResponseEntity.ok().body(this.professorService.findProfessorById(id));
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor){
        return ResponseEntity.ok().body(this.professorService.createProfessor(professor));
    }

    @PatchMapping("/{professorId}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable("professorId") long id, @RequestBody Professor professor){
        professor.setId(id);
        return ResponseEntity.ok().body(this.professorService.editProfessor(professor));
    }

    @DeleteMapping("/{professorId}")
    public HttpStatus deleteProfessor(@PathVariable("professorId") long id){
        this.professorService.deleteProfessor(id);
        return HttpStatus.OK;
    }
}
