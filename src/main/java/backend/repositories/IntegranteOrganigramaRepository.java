package backend.repositories;

import backend.models.IntegranteOrganigrama;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IntegranteOrganigramaRepository extends MongoRepository<IntegranteOrganigrama, String> {
    List<IntegranteOrganigrama> getByFirstName(String firstName);
    List<IntegranteOrganigrama> getByPosition(String position);
}
