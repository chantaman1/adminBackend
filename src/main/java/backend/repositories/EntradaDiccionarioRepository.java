package backend.repositories;

import backend.models.EntradaDiccionario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntradaDiccionarioRepository extends MongoRepository<EntradaDiccionario, String> {

}
