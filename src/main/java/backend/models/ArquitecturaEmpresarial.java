package backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ArquitecturaEmpresarial {
    @Id
    private String _id;
    private String titulo;

    public ArquitecturaEmpresarial(){

    }

    public ArquitecturaEmpresarial(String titulo){
        this.titulo = titulo;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
