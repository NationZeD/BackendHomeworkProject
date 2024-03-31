package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.ActorDTO;
import ge.ibsu.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<ActorDTO> getAllActorsNames() {
        List<Object[]> actorsNames = actorRepository.findAllActorsNames();
        return actorsNames.stream()
                .map(nameArray -> new ActorDTO((String) nameArray[0], (String) nameArray[1]))
                .collect(Collectors.toList());
    }
}