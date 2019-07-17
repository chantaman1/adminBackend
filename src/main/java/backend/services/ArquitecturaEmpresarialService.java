package backend.services;

import backend.models.ArquitecturaEmpresarial;
import backend.repositories.ArquitecturaEmpresarialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ArquitecturaEmpresarialService {
    @Autowired
    ArquitecturaEmpresarialRepository arquitecturaEmpresarialRepository;

    public ArquitecturaEmpresarial create(String titulo){
        return arquitecturaEmpresarialRepository.save(new ArquitecturaEmpresarial(titulo));
    }

    public List<ArquitecturaEmpresarial> findAll(){
        return arquitecturaEmpresarialRepository.findAll();
    }

    public ArquitecturaEmpresarial update(String id, String titulo){
        try {
            ArquitecturaEmpresarial res = arquitecturaEmpresarialRepository.findById(id).get();
            if(res != null){
                res.setTitulo(titulo);
                return arquitecturaEmpresarialRepository.save(res);
            }
            else{
                return null;
            }
        }
        catch (NoSuchElementException nse) {
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

    public ArquitecturaEmpresarial getByTitulo(String titulo){
        if(titulo != null){
            return arquitecturaEmpresarialRepository.findOneByTitulo(titulo);
        }
        else{
            return null;
        }
    }
}
