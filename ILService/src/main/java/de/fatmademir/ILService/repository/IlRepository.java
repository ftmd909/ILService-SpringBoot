package de.fatmademir.ILService.repository;

import de.fatmademir.ILService.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IlRepository extends MongoRepository<Il,String> {

    Optional<Il> findByName(String name);
}
