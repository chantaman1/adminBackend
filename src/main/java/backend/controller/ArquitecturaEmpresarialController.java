package backend.controller;

import backend.models.ArquitecturaEmpresarial;
import backend.services.ArquitecturaEmpresarialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArquitecturaEmpresarialController {
    @Autowired
    ArquitecturaEmpresarialService arquitecturaEmpresarialService;

    @GetMapping("/arquitectura/")
    @ResponseBody
    public ArquitecturaEmpresarial getData(){
        List<ArquitecturaEmpresarial> result = arquitecturaEmpresarialService.findAll();
        for(ArquitecturaEmpresarial data : result){
            return data;
        }
        return null;
    }

    @PostMapping("/arquitectura/create")
    @ResponseBody
    public HashMap<String, Object> create(@RequestBody Map<String, Object> jsonData){
        String titulo = jsonData.get("titulo").toString();
        String descripcion = jsonData.get("descripcion").toString();
        HashMap<String, Object> map = new HashMap<>();
        if(titulo != null && descripcion != null){
            if(arquitecturaEmpresarialService.exist(titulo)){
                map.put("status", 400);
                map.put("message", "This already exist.");
                map.put("result", false);
                return map;
            }
            else{
                ArquitecturaEmpresarial res = arquitecturaEmpresarialService.create(titulo, descripcion);
                if(res != null){
                    map.put("status", 201);
                    map.put("message", "OK");
                    map.put("result", true);
                    map.put("titulo", titulo);
                    map.put("descripcion", descripcion);
                    return map;
                }
                else{
                    map.put("status", 400);
                    map.put("message", "Could not create the object.");
                    map.put("result", false);
                    return map;
                }
            }
        }
        else{
            map.put("status", 400);
            map.put("message", "one or more fields are empty.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/arquitectura/update")
    @ResponseBody
    public HashMap<String, Object> update(@RequestBody Map<String, Object> jsonData){
        String titulo = jsonData.get("titulo").toString();
        String descripcion = jsonData.get("descripcion").toString();
        String id = jsonData.get("id").toString();
        HashMap<String, Object> map = new HashMap<>();
        if(titulo != null && descripcion != null && id != null){
            ArquitecturaEmpresarial res = arquitecturaEmpresarialService.update(id, titulo, descripcion);
            if(res != null){
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("titulo", titulo);
                map.put("descripcion", descripcion);
                return map;
            }
            else{
                map.put("status", 400);
                map.put("message", "Could not update.");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("status", 400);
            map.put("message", "one or more fields are empty.");
            map.put("result", false);
            return map;
        }
    }
}
