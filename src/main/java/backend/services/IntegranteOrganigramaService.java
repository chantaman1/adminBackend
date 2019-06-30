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

    public IntegranteOrganigrama create(String firstName, String lastName, String photoUrl, String position, int parent, int child){
        return integranteOrganigramaRepository.save(new IntegranteOrganigrama(firstName, lastName, photoUrl, position, parent, child));
    }

    public List<IntegranteOrganigrama> findAll(){
        return integranteOrganigramaRepository.findAll();
    }

    public IntegranteOrganigrama findByName(String firstName, String lastName){
        List<IntegranteOrganigrama> res = integranteOrganigramaRepository.getByName(firstName);
        for(int i=0; i<res.size();i++){
           if (res.get(i).lastName.equalsIgnoreCase(lastName)){
               return res.get(i);
           }
        }
        return null;
    }

    public List<IntegranteOrganigrama> findByPosition(String position){
        List<IntegranteOrganigrama> integrante = integranteOrganigramaRepository.getByPosition(position);
        if(integrante.isEmpty()){
            return null;
        }
        return integrante;
    }

    public IntegranteOrganigrama update(IntegranteOrganigrama integranteOrganigrama){
        return integranteOrganigramaRepository.save(integranteOrganigrama);
    }
}
