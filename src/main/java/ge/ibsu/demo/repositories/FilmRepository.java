package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Page<Film> findWithPagination(String title, String description, int releaseYear, String language, Pageable pageable);
}
