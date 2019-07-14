package backend.controller;

import backend.fileUploader.UploadFileResponse;
import backend.fileUploader.controllers.FileController;
import backend.models.IntegranteOrganigrama;
import backend.services.IntegranteOrganigramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IntegranteOrganigramaController {
    @Autowired
    IntegranteOrganigramaService integranteOrganigramaService;

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    FileController fileController;

    @PostMapping("/organigrama/create")
    public HashMap<String, Object> create(@RequestBody Map<String, Object> jsonData){
        List<IntegranteOrganigrama> integrantes = integranteOrganigramaService.findAll();
        HashMap<String, Object> map = new HashMap<>();
        boolean emailExist = false;
        if(jsonData.get("parent") == null || jsonData.get("text") == null || jsonData.get("title") == null || jsonData.get("email") == null){
            map.put("status", 403);
            map.put("message", "One or more values are null.");
            map.put("result", false);
            return map;
        }
        for(IntegranteOrganigrama integrante : integrantes){
            if(integrante.getEmail().equalsIgnoreCase(jsonData.get("email").toString())){
                emailExist = true;
            }
        }
        if(emailExist){
            map.put("status", 403);
            map.put("message", "Member already exist.");
            map.put("result", false);
            return map;
        }
        else{
            IntegranteOrganigrama result = integranteOrganigramaService.create(Integer.parseInt(jsonData.get("parent").toString()), jsonData.get("text").toString(), jsonData.get("title").toString(), jsonData.get("email").toString(), "");
            if(result != null){
                map.put("status", 201);
                map.put("message", "OK");
                map.put("result", true);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "Could not create the new member.");
                map.put("result", false);
                return map;
            }
        }
    }

    @GetMapping("/organigrama/getAll")
    public List<IntegranteOrganigrama> findAll(){
      return integranteOrganigramaService.findAll();
    }

    @GetMapping("/organigrama/getIntegrante/{email}/")
    public IntegranteOrganigrama findByName(@RequestParam String email){
        return integranteOrganigramaService.findByEmail(email);
    }

    @GetMapping("/organigrama/getIntegrante/title/{title}")
    public List<IntegranteOrganigrama> findByTitle(@RequestParam String title){
        return integranteOrganigramaService.findByTitle(title);
    }

    @PostMapping("/organigrama/updateIntegranteEmail")
    public HashMap<String, Object> updateIntegranteEmail(@RequestParam Map<String, Object> jsonData){
        HashMap<String, Object> map = new HashMap<>();
        if(jsonData.get("email") != null && jsonData.get("newEmail") != null){
            IntegranteOrganigrama integrante = integranteOrganigramaService.findByEmail(jsonData.get("email").toString());
            if(integrante != null){
                integrante.setEmail(jsonData.get("newEmail").toString());
                IntegranteOrganigrama res = integranteOrganigramaService.update(integrante);
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", res);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "Could not create the new member.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "One or more fields are null.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/organigrama/updateIntegranteParent")
    public HashMap<String, Object> updateIntegranteParent(@RequestParam Map<String, Object> jsonData){
        HashMap<String, Object> map = new HashMap<>();
        if(jsonData.get("email") != null && jsonData.get("parent") != null){
            IntegranteOrganigrama integrante = integranteOrganigramaService.findByEmail(jsonData.get("email").toString());
            if(integrante != null){
                integrante.setParent(Integer.parseInt(jsonData.get("newEmail").toString()));
                IntegranteOrganigrama res = integranteOrganigramaService.update(integrante);
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", res);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "no member with this email.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "One or more fields are null.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/organigrama/updateIntegranteTitle")
    public HashMap<String, Object> updateIntegranteTitle(@RequestParam Map<String, Object> jsonData){
        HashMap<String, Object> map = new HashMap<>();
        if(jsonData.get("email") != null && jsonData.get("title") != null){
            IntegranteOrganigrama integrante = integranteOrganigramaService.findByEmail(jsonData.get("email").toString());
            if(integrante != null){
                integrante.setTitle(jsonData.get("title").toString());
                IntegranteOrganigrama res = integranteOrganigramaService.update(integrante);
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", res);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "No member with this email.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "One or more fields are null.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/organigrama/updateIntegranteText")
    public HashMap<String, Object> updateIntegranteText(@RequestParam Map<String, Object> jsonData){
        HashMap<String, Object> map = new HashMap<>();
        if(jsonData.get("email") != null && jsonData.get("text") != null){
            IntegranteOrganigrama integrante = integranteOrganigramaService.findByEmail(jsonData.get("email").toString());
            if(integrante != null){
                integrante.setText(jsonData.get("text").toString());
                IntegranteOrganigrama res = integranteOrganigramaService.update(integrante);
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", res);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "No member with this email.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "One or more fields are null.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/organigrama/updateIntegrantePic")
    public HashMap<String, Object> updateIntegrantePic(@RequestParam("file") MultipartFile file, @RequestParam String email){
        HashMap<String, Object> map = new HashMap<>();
        if(email != null && file != null){
            IntegranteOrganigrama integrante = integranteOrganigramaService.findByEmail(email);
            UploadFileResponse fileUpload = fileController.uploadFile(file);
            if(integrante != null && fileUpload != null){
                integrante.setImg(fileUpload.getFileDownloadUri());
                IntegranteOrganigrama res = integranteOrganigramaService.update(integrante);
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", res);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "No member with this email.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "One or more fields are null.");
            map.put("result", false);
            return map;
        }
    }

    @DeleteMapping("/organigrama/deleteIntegrante")
    public void deleteIntegrante(@RequestParam Map<String, Object> jsonData){
        IntegranteOrganigrama res = integranteOrganigramaService.findByEmail(jsonData.get("email").toString());
        mongoOperations.remove(res);
    }
}
