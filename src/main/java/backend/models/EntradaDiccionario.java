package backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EntradaDiccionario {
    @Id
    public String _id;
    public String descripcion;
    public int indentacion;
    public String bpmn;
    public String matrizRECI;

    public EntradaDiccionario(){

    }

    public EntradaDiccionario(String descripcion, int indentacion, String bpmn, String matrizRECI){
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
