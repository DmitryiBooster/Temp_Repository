package learning.spring.labloz.Lab4.Controller;

import learning.spring.labloz.Lab4.Entity.Notes;
import learning.spring.labloz.Lab4.Repository.NoteRepository;
import learning.spring.labloz.Lab4.Service.NoteService;
import learning.spring.labloz.Lab4.Service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    private final NoteService noteService;
    private final TestService testService;
    private final NoteRepository noteRepository;

    public NoteController(NoteService noteService, TestService testService, NoteRepository noteRepository) {
        this.noteService = noteService;
        this.testService = testService;
        this.noteRepository = noteRepository;
    }

    @GetMapping("/health")
    public String health() {
        return testService.health();
    }

    @GetMapping("/version")
    public String version() {
        return testService.version();
    }

    @GetMapping("/allNotes")
    public List<Notes> allNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/getNote/{title}")
    public Notes getNote(@PathVariable String title) {
        return noteService.getNoteByTitle(title);
    }

    @PostMapping("/createNote")
    public Notes createNote(@RequestBody Notes note) {
        return noteService.createNote(note);
    }

    @DeleteMapping("/deleteNote/{title}")
    public void deleteNote(@PathVariable String title) {
        Optional<Notes> noteOptional = Optional.ofNullable(noteService.getNoteByTitle(title));
        if (noteOptional.isPresent()) {
            noteService.deleteNote(title);
        } else {
            throw new IllegalArgumentException("Note not found");
        }
    }

    @PutMapping("/updateNote/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable Integer id, @RequestBody Notes updatedNote) {
        Optional<Notes> noteOptional = noteRepository.findById(id);
        if (noteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Notes note = noteOptional.get();
        note.setTitle(updatedNote.getTitle());
        note.setText(updatedNote.getText());
        note.setDate(updatedNote.getDate());

        Notes saved = noteRepository.save(note);
        return ResponseEntity.ok(saved);
    }
}
