package backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.models.Servicio;
import backend.repositories.ServicioRepository;

import java.util.List;

@Component
public class ServicioService{
  @Autowired
  private ServicioRepository servicioRepository;

  public Servicio create(String nombre, String descripcion, String compromiso, String tarifa ){
	  return servicioRepository.save(new Servicio(nombre, descripcion, compromiso, tarifa));
  }
  
  public List<Servicio> getAll(){
	  return servicioRepository.findAll();
  }
  
  public Servicio getById(String _id) {
	  return servicioRepository.findById(_id);
  }

  public Servicio getByNombre(String nombre) {
	  return servicioRepository.findByNombre(nombre);
  }

  public Servicio updateNombre(String nombre, String _id) {
		Servicio servicio = servicioRepository.findById(_id);
		if(servicio==NULL) {
			return null;
		}
		
		servicio.setNombre(nombre);
		return servicioRepository.save(servicio);
	}
	
	public Servicio updateDescripcion(String descripcion, String _id) {
		Servicio servicio = servicioRepository.findById(_id);
		if(servicio==NULL) {
			return null;
		}
		servicio.setDescripcion(descripcion);
		return servicioRepository.save(servicio);
	}
	
	public Servicio updateCompromiso(String compromiso, String _id) {
		Servicio servicio = servicioRepository.findById(_id);
		if(servicio==NULL) {
			return null;
		}
		servicio.setCompromiso(compromiso);
		return servicioRepository.save(servicio);
	}
	
	public Servicio updateTarifa(String tarifa, String _id) {
		Servicio servicio = servicioRepository.findById(_id);
		if(servicio==NULL) {
			return null;
		}
		servicio.setTarifa(tarifa);
		return servicioRepository.save(servicio);
	}
	
	/*Actualiza el servicio*/
	public void updateServicio(String _id, Servicio servicio){
		Servicio servicio = servicioRepository.findById(_id);
		servicio.set(servicio);
		return servicio;


	}
	/*Elimina todos los servicios*/
	public void deleteAll(){
		servicioRepository.deleteAll();

	}

	/*Elimina un servicio*/
	public void delete(String id){
		Servicio servicio = servicioRepository.findById(id);
		servicioRepository.delete(servicio);


	}
  
  
  
  
}
