package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.FilmDTO;
import ge.ibsu.demo.entities.Film;
import ge.ibsu.demo.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDTO> searchFilms(String searchTerm, int releaseYear, String language, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Film> films = filmRepository.findWithPagination(searchTerm, searchTerm, releaseYear, language, pageable);
        return films.getContent().stream()
                .map(film -> new FilmDTO(film.getTitle(), film.getDescription(), film.getRating()))
                .collect(Collectors.toList());
    }
}