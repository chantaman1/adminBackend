package backend.models;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class PlanEstrategico {
	@Id
	public String _id;
	public String vision;
	public String mision;
	public String objetivo;
	public String estrategia;
	public String valor;
	public LocalDate createdAt;
	
	public PlanEstrategico(String vision, String mision, String objetivo, String estrategia, String valor, LocalDate createdAt) {
		this.vision = vision;
		this.mision = mision;
		this.objetivo = objetivo;
		this.estrategia = estrategia;
		this.valor = valor;
		this.createdAt = createdAt;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getMision() {
		return mision;
	}

	public void setMision(String mision) {
		this.mision = mision;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
}
