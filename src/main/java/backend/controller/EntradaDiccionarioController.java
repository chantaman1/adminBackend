package backend.controller;

import backend.fileUploader.UploadFileResponse;
import backend.fileUploader.controllers.FileController;
import backend.models.ArquitecturaEmpresarial;
import backend.models.EntradaDiccionario;
import backend.services.ArquitecturaEmpresarialService;
import backend.services.EntradaDiccionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EntradaDiccionarioController {
    @Autowired
    EntradaDiccionarioService entradaDiccionarioService;
    @Autowired
    FileController fileController;
    @Autowired
    ArquitecturaEmpresarialService arquitecturaEmpresarialService;

    @PostMapping("/diccionario/create")
    @ResponseBody
    public HashMap<String, Object> create(@RequestParam("fileBPMN") MultipartFile fileBPMN, @RequestBody Map<String, Object> jsonData){
        HashMap<String, Object> map = new HashMap<>();
        String titulo = jsonData.get("titulo").toString();
        int indentacion = Integer.parseInt(jsonData.get("indentacion").toString());
        String tituloEmp = jsonData.get("tituloEmpresarial").toString();
        ArquitecturaEmpresarial arquitectura = arquitecturaEmpresarialService.getByTitulo(tituloEmp);
        if(titulo != null && fileBPMN != null){
            UploadFileResponse resultBpmn = fileController.uploadFile(fileBPMN);
            //UploadFileResponse resultMatrix = fileController.uploadFile(fileMatrix);
            if(resultBpmn != null){
                EntradaDiccionario result = entradaDiccionarioService.create(titulo, arquitectura.get_id(), indentacion, resultBpmn.getFileDownloadUri(), "");
                if(result != null){
                    map.put("status", 201);
                    map.put("message", "OK");
                    map.put("result", true);
                    return map;
                }
                else{
                    map.put("status", 400);
                    map.put("message", "Could not save the object.");
                    map.put("result", false);
                    return map;
                }
            }
            else{
                map.put("status", 400);
                map.put("message", "Could not upload one or more files.");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("Status", 400);
            map.put("message", "One or more fields are empty.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/diccionario/updatebpmn")
    @ResponseBody
    public HashMap<String, Object> updateBpmn(@RequestParam("fileBPMN") MultipartFile fileBPMN, @RequestBody Map<String, Object> jsonData){
        String id = jsonData.get("id").toString();
        HashMap<String, Object> map = new HashMap<>();
        boolean res = entradaDiccionarioService.checkEntradaDiccionario(id);
        if(res){
            UploadFileResponse file = fileController.uploadFile(fileBPMN);
            if(file != null){
                EntradaDiccionario result = entradaDiccionarioService.updateBPMN(id, file.getFileDownloadUri());
                if(result != null){
                    map.put("status", 200);
                    map.put("message", "OK");
                    map.put("result", true);
                    return map;
                }
                else{
                    map.put("status", 400);
                    map.put("message", "Could not update the bpmn.");
                    map.put("result", false);
                    return map;
                }
            }
            else{
                map.put("status", 400);
                map.put("message", "Could not upload the file.");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("status", 400);
            map.put("message", "Could not find that dictionary.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/diccionario/updatematrix")
    @ResponseBody
    public HashMap<String, Object> updateMatrix(@RequestParam("fileMatrix") MultipartFile fileMatrix, @RequestBody Map<String, Object> jsonData){
        String id = jsonData.get("id").toString();
        HashMap<String, Object> map = new HashMap<>();
        boolean res = entradaDiccionarioService.checkEntradaDiccionario(id);
        if(res){
            UploadFileResponse file = fileController.uploadFile(fileMatrix);
            if(file != null){
                EntradaDiccionario result = entradaDiccionarioService.updateMatrizRECI(id, file.getFileDownloadUri());
                if(result != null){
                    map.put("status", 200);
                    map.put("message", "OK");
                    map.put("result", true);
                    return map;
                }
                else{
                    map.put("status", 400);
                    map.put("message", "Could not update the matrix.");
                    map.put("result", false);
                    return map;
                }
            }
            else{
                map.put("status", 400);
                map.put("message", "Could not upload the file.");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("status", 400);
            map.put("message", "Could not find that dictionary.");
            map.put("result", false);
            return map;
        }
    }

    @PostMapping("/diccionario/updatedictionary")
    @ResponseBody
    public HashMap<String, Object> updateDictionary(@RequestBody Map<String, Object> jsonData){
        String id = jsonData.get("id").toString();
        HashMap<String, Object> map = new HashMap<>();
        String descripcion = jsonData.get("descripcion").toString();
        int indentacion = Integer.parseInt(jsonData.get("indentacion").toString());
        if(id != null){
            boolean res = entradaDiccionarioService.checkEntradaDiccionario(id);
            if(res && descripcion != null){
                EntradaDiccionario result = entradaDiccionarioService.updateEntradaDiccionario(id, descripcion, indentacion);
                if(result != null){
                    map.put("status", 200);
                    map.put("message", "OK");
                    map.put("result", true);
                    return map;
                }
                else{
                    map.put("status", 400);
                    map.put("message", "Could not update the dictionary.");
                    map.put("result", false);
                    return map;
                }
            }
            else{
                map.put("status", 400);
                map.put("message", "Could not find that dictionary.");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("status", 400);
            map.put("message", "No id given.");
            map.put("result", false);
            return map;
        }
    }

    @GetMapping("/diccionario/")
    @ResponseBody
    public List<HashMap<String, Object>> getAll(){
        List<HashMap<String, Object>> result = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        List<ArquitecturaEmpresarial> arquitecturas = arquitecturaEmpresarialService.findAll();
        for(ArquitecturaEmpresarial arquitectura : arquitecturas){
            List<EntradaDiccionario> diccionarios = entradaDiccionarioService.getAll(arquitectura.get_id());
            map.put("titulo", arquitectura.getTitulo());
            map.put("diccionario", diccionarios);
            result.add(map);
            map = new HashMap<>();
        }
        return result;
    }

    @GetMapping("diccionario/{id}")
    @ResponseBody
    public EntradaDiccionario getById(@RequestParam String id){
        return entradaDiccionarioService.findById(id);
    }
}
