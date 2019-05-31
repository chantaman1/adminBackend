package backend.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Servicio {
	@Id
	public String _id;
	public String textoServicio;
}
