package learning.spring.labloz.Lab4.Service;

import learning.spring.labloz.Lab4.Entity.Notes;
import learning.spring.labloz.Lab4.Repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;


    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /**
     * --- Get Methods ---
     **/
    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    public Notes getNoteByDate(LocalDate date) {
        return noteRepository.findByDate(date);
    }

    public Notes getNoteByTitle(String title) {
        return noteRepository.findByTitle(title);
    }

    /**
     * --- CUD Methods ---
     **/

    public Notes createNote(Notes note) {
        Optional<Notes> notesOptional = Optional.ofNullable(noteRepository.findByTitle(note.getTitle()));
        if (notesOptional.isPresent()) {
            throw new RuntimeException("Note already exists");
        }
        return noteRepository.save(note);
    }

    public void deleteNote(String title) {
        if (!noteRepository.existsByTitle(title)) {
            throw new IllegalArgumentException("Note with title: " + title + " not exist");
        }
        noteRepository.delete(noteRepository.findByTitle(title));
    }

    public Notes updateNote(Integer id, Notes note) {
        if (!noteRepository.existsById(id)) {
            throw new IllegalArgumentException("Note with id: " + id + " not exist");
        }

        Notes updatedNote = new Notes(
                note.getTitle(),
                note.getText(),
                note.getDate()
        );
        return noteRepository.save(updatedNote);
    }
}
