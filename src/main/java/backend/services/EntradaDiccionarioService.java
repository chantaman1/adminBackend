package backend.services;

import backend.models.EntradaDiccionario;
import backend.repositories.EntradaDiccionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntradaDiccionarioService {
    @Autowired
    EntradaDiccionarioRepository entradaDiccionarioRepository;

    public EntradaDiccionario create(String descripcion, int indentacion, String bpmn, String matrizRECI){
        return entradaDiccionarioRepository.save(new EntradaDiccionario(descripcion, indentacion, bpmn, matrizRECI));
    }

    public List<EntradaDiccionario> getAll(){
        return entradaDiccionarioRepository.findAll();
    }

    public EntradaDiccionario updateEntradaDiccionario(String id, String descripcion, int indentacion){
        EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
        if(res != null){
            res.setDescripcion(descripcion);
            res.setIndentacion(indentacion);
            return entradaDiccionarioRepository.save(res);
        }
        else{
            return null;
        }
    }

    public boolean checkEntradaDiccionario(String id){
        EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
        if(res != null){
            if(res.get_id().equals(id)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public EntradaDiccionario updateBPMN(String id, String bpmn){
        EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
        if(res != null){
            res.setBpmn(bpmn);
            return entradaDiccionarioRepository.save(res);
        }
        else{
            return null;
        }
    }

    public EntradaDiccionario updateMatrizRECI(String id, String matrizRECI){
        EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
        if(res != null){
            res.setMatrizRECI(matrizRECI);
            return entradaDiccionarioRepository.save(res);
        }
        else{
            return null;
        }
    }

    public EntradaDiccionario findById(String id){
        EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
        if(res != null){
            return res;
        }
        else{
            return null;
        }
    }
}
