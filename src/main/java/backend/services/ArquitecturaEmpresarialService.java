package backend.services;

import backend.models.ArquitecturaEmpresarial;
import backend.repositories.ArquitecturaEmpresarialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArquitecturaEmpresarialService {
    @Autowired
    ArquitecturaEmpresarialRepository arquitecturaEmpresarialRepository;

    public ArquitecturaEmpresarial create(String titulo, String descripcion){
        return arquitecturaEmpresarialRepository.save(new ArquitecturaEmpresarial(titulo, descripcion));
    }

    public List<ArquitecturaEmpresarial> findAll(){
        return arquitecturaEmpresarialRepository.findAll();
    }

    public ArquitecturaEmpresarial update(String id, String titulo, String descripcion){
        ArquitecturaEmpresarial res = arquitecturaEmpresarialRepository.findById(id).get();
        if(res != null){
            res.setTitulo(titulo);
            res.setDescripcion(descripcion);
            return arquitecturaEmpresarialRepository.save(res);
        }
        else{
            return null;
        }
    }

    public boolean exist(String titulo){
        ArquitecturaEmpresarial res = arquitecturaEmpresarialRepository.findOneByTitulo(titulo);
        if(res != null){
            return true;
        }
        else{
            return false;
        }
    }
}
