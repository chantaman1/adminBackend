package backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EntradaDiccionario {
    @Id
    public String _id;
    private String idArquitecturaEmpresarial;
    private String titulo;
    private int indentacion;
    private String bpmn;
    private String matrizRECI;

    public EntradaDiccionario(){

    }

    public EntradaDiccionario(String titulo, String idArquitecturaEmpresarial, int indentacion, String bpmn, String matrizRECI){
        this.titulo = titulo;
        this.idArquitecturaEmpresarial = idArquitecturaEmpresarial;
        this.indentacion = indentacion;
        this.bpmn = bpmn;
        this.matrizRECI = matrizRECI;
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

    public String getIdArquitecturaEmpresarial() {
        return idArquitecturaEmpresarial;
    }

    public void setIdArquitecturaEmpresarial(String idArquitecturaEmpresarial) {
        this.idArquitecturaEmpresarial = idArquitecturaEmpresarial;
    }

    public int getIndentacion() {
        return indentacion;
    }

    public void setIndentacion(int indentacion) {
        this.indentacion = indentacion;
    }

    public String getBpmn() {
        return bpmn;
    }

    public void setBpmn(String bpmn) {
        this.bpmn = bpmn;
    }

    public String getMatrizRECI() {
        return matrizRECI;
    }

    public void setMatrizRECI(String matrizRECI) {
        this.matrizRECI = matrizRECI;
    }
}
