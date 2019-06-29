package backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.models.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio, String>{
	public Servicio findByNombre(String nombre);
}