package backend.repositories;

import backend.models.EntradaDiccionario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntradaDiccionarioRepository extends MongoRepository<EntradaDiccionario, String> {
    List<EntradaDiccionario> findAllByIdArquitecturaEmpresarialOrderByIndentacionAsc(String idArquitecturaEmpresarial);
}
