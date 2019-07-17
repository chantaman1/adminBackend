package backend.controller;

import backend.models.ArquitecturaEmpresarial;
import backend.models.EntradaDiccionario;
import backend.services.ArquitecturaEmpresarialService;
import backend.services.EntradaDiccionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArquitecturaEmpresarialController {
    @Autowired
    ArquitecturaEmpresarialService arquitecturaEmpresarialService;
    @Autowired
    EntradaDiccionarioService entradaDiccionarioService;

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
        HashMap<String, Object> map = new HashMap<>();
        if(titulo != null){
            if(arquitecturaEmpresarialService.exist(titulo)){
                map.put("status", 400);
                map.put("message", "This already exist.");
                map.put("result", false);
                return map;
            }
            else{
                ArquitecturaEmpresarial res = arquitecturaEmpresarialService.create(titulo);
                if(res != null){
                    map.put("status", 201);
                    map.put("message", "OK");
                    map.put("result", true);
                    map.put("titulo", titulo);
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
        String id = jsonData.get("id").toString();
        HashMap<String, Object> map = new HashMap<>();
        if(titulo != null && id != null){
            ArquitecturaEmpresarial res = arquitecturaEmpresarialService.update(id, titulo);
            if(res != null){
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("titulo", titulo);
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

    @DeleteMapping("/arquitectura/delete")
    @ResponseBody
    public HashMap<String, Object> delete(@RequestBody Map<String, Object> jsonData){
        String titulo = jsonData.get("titulo").toString();
        HashMap<String, Object> map = new HashMap<>();
        if(titulo != null){
            ArquitecturaEmpresarial arquitectura = arquitecturaEmpresarialService.getByTitulo(titulo);
            if(arquitectura != null){
                List<EntradaDiccionario> diccionarios = entradaDiccionarioService.getAll(arquitectura.get_id());
                for(EntradaDiccionario diccionario : diccionarios){
                    entradaDiccionarioService.deleteById(diccionario.get_id());
                }
                arquitecturaEmpresarialService.deleteById(arquitectura.get_id());
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "NULL");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("status", 404);
            map.put("message", "TITULO NOT PROVIDED.");
            map.put("result", false);
            return map;
        }
    }
}
