package backend.controller;

import backend.models.IntegranteOrganigrama;
import backend.services.IntegranteOrganigramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class IntegranteOrganigramaController {
    @Autowired
    IntegranteOrganigramaService integranteOrganigramaService;

    @Autowired
    MongoOperations mongoOperations;

    @PostMapping("/organigrama/create")
    public List<IntegranteOrganigrama> create(@RequestBody Map<String, Object> jsonData){
        List<IntegranteOrganigrama> integrantes = integranteOrganigramaService.findAll();
        IntegranteOrganigrama nuevo = new IntegranteOrganigrama(jsonData.get("firstName").toString(), jsonData.get("lastName").toString(), jsonData.get("photoUrl").toString(), jsonData.get("position").toString(), Integer.parseInt(jsonData.get("parent").toString()), Integer.parseInt(jsonData.get("child").toString()));
        integrantes.add(nuevo);
        return integrantes;
    }

    @GetMapping("/organigrama/getIntegrante/{nombre}/{apellido}")
    public IntegranteOrganigrama findByName(@RequestParam String nombre, @RequestParam String apellido){
        return integranteOrganigramaService.findByName(nombre, apellido);
    }

    @GetMapping("/organigrama/getIntegrante/position/{position}")
    public List<IntegranteOrganigrama> findByPosition(@RequestParam String position){
        return integranteOrganigramaService.findByPosition(position);
    }

    @PostMapping("/organigrama/updateIntegrante")
    public IntegranteOrganigrama updateIntegrante(@RequestParam Map<String, Object> jsonData){
        String firtName = jsonData.get("fisrtName").toString();
        String lastName = jsonData.get("lastName").toString();
        String photoUrl = jsonData.get("photoUrl").toString();
        String position = jsonData.get("position").toString();
        int parent = Integer.parseInt(jsonData.get("parent").toString());
        int child = Integer.parseInt(jsonData.get("child").toString());
        IntegranteOrganigrama res = integranteOrganigramaService.findByName(firtName, lastName);
        res.firstName = firtName;
        res.lastName = lastName;
        res.photoUrl = photoUrl;
        res.position = position;
        res.parent = parent;
        res.child = child;
        return integranteOrganigramaService.update(res);
    }

    @DeleteMapping("/organigrama/deleteIntegrante")
    public void deleteIntegrante(@RequestParam Map<String, Object> jsonData){
        IntegranteOrganigrama res = integranteOrganigramaService.findByName(jsonData.get("firstName").toString(), jsonData.get("lastName").toString());
        mongoOperations.remove(res);
    }
}
