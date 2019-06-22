package backend.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Servicio {
	@Id
	public String _id;
	public String nombre;
	public String descripcion;
	public String compromiso;
	public String tarifa;

	public Servicio(String nombre, String descripcion, String compromiso, String tarifa) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.compromiso = compromiso;
		this.tarifa = tarifa;
		
	}



	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;

	}

	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}


	public String getCompromiso(){
		return compromiso;

	}
	public void setCompromiso(String compromiso){
		this.compromiso=compromiso;

	}

	public String getTarifa(){
		return tarifa;
	}

	public void setTarifa(String tarifa){
		this.tarifa=tarifa;
	}
}
