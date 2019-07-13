package backend.repositories;

import backend.models.IntegranteOrganigrama;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IntegranteOrganigramaRepository extends MongoRepository<IntegranteOrganigrama, String> {
    IntegranteOrganigrama getIntegranteOrganigramaByEmail(String email);
    IntegranteOrganigrama getIntegranteOrganigramaByParent(int parent);
    List<IntegranteOrganigrama> getIntegranteOrganigramaByTitle(String title);
}
