package learning.spring.labloz.Lab4.Repository;


import learning.spring.labloz.Lab4.Entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface NoteRepository extends JpaRepository<Notes, Integer> {
    Notes findByTitle(String title);
    Notes findByDate(LocalDate date);
    boolean existsByTitle(String title);
}
