package backend.repositories;

import backend.models.ArquitecturaEmpresarial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArquitecturaEmpresarialRepository extends MongoRepository<ArquitecturaEmpresarial, String> {
    ArquitecturaEmpresarial findOneByTitulo(String titulo);
}
