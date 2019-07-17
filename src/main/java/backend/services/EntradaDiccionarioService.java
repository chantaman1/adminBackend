package backend.services;

import backend.models.EntradaDiccionario;
import backend.repositories.EntradaDiccionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class EntradaDiccionarioService {
    @Autowired
    EntradaDiccionarioRepository entradaDiccionarioRepository;

    public EntradaDiccionario create(String titulo, String idArquitecturaEmpresarial, int indentacion, String bpmn, String matrizRECI){
        return entradaDiccionarioRepository.save(new EntradaDiccionario(titulo, idArquitecturaEmpresarial, indentacion, bpmn, matrizRECI));
    }

    public List<EntradaDiccionario> getAll(String idArquitecturaEmpresarial){
        return entradaDiccionarioRepository.findAllByIdArquitecturaEmpresarialOrderByIndentacionAsc(idArquitecturaEmpresarial);
    }

    public EntradaDiccionario updateEntradaDiccionario(String id, String titulo, int indentacion){
        try {
            EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
            if (res != null) {
                res.setTitulo(titulo);
                res.setIndentacion(indentacion);
                return entradaDiccionarioRepository.save(res);
            } else {
                return null;
            }
        }
        catch (NoSuchElementException nse) {
            return null;
        }
    }

    public boolean checkEntradaDiccionario(String id){
        try {
            EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
            if (res != null) {
                if (res.get_id().equals(id)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        catch (NoSuchElementException nse) {
            return false;
        }
    }

    public EntradaDiccionario updateBPMN(String id, String bpmn){
        try {
            EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
            if (res != null) {
                res.setBpmn(bpmn);
                return entradaDiccionarioRepository.save(res);
            } else {
                return null;
            }
        }
        catch (NoSuchElementException nse) {
            return null;
        }
    }

    public EntradaDiccionario updateMatrizRECI(String id, String matrizRECI){
        try {
            EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
            if (res != null) {
                res.setMatrizRECI(matrizRECI);
                return entradaDiccionarioRepository.save(res);
            } else {
                return null;
            }
        }
        catch (NoSuchElementException nse) {
            return null;
        }
    }

    public EntradaDiccionario findById(String id){
        try {
            EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
            if(res != null){
                return res;
            }
            else{
                return null;
            }
        }
        catch (NoSuchElementException nse) {
            return null;
        }
    }

    public void deleteById(String id){
        EntradaDiccionario res = entradaDiccionarioRepository.findById(id).get();
        entradaDiccionarioRepository.delete(res);
    }
}
