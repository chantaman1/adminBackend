package backend.services;

import backend.models.IntegranteOrganigrama;
import backend.repositories.IntegranteOrganigramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntegranteOrganigramaService {
    @Autowired
    IntegranteOrganigramaRepository integranteOrganigramaRepository;

    public IntegranteOrganigrama create(int parent, String text, String title, String email, String img){
        return integranteOrganigramaRepository.save(new IntegranteOrganigrama(parent, text, title, email, img));
    }

    public List<IntegranteOrganigrama> findAll(){
        return integranteOrganigramaRepository.findAll();
    }

    public List<IntegranteOrganigrama> findByTitle(String title){
        List<IntegranteOrganigrama> res = integranteOrganigramaRepository.getIntegranteOrganigramaByTitle(title);
        return res;
    }

    public IntegranteOrganigrama findByEmail(String email){
        IntegranteOrganigrama integrante = integranteOrganigramaRepository.getIntegranteOrganigramaByEmail(email);
        return integrante;
    }

    public IntegranteOrganigrama update(IntegranteOrganigrama integranteOrganigrama){
        return integranteOrganigramaRepository.save(integranteOrganigrama);
    }
}
