package backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.models.HorarioAtencion;

public interface HorarioAtencionRepository extends MongoRepository<HorarioAtencion, String> {

}
