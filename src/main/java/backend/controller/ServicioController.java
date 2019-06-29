package backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.extra.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import backend.models.Servicio;
import backend.services.ServicioService;

@RestController
public class ServicioController {
	private ApiKey apikey = new ApiKey();
	private String p_api_key = apikey.getApi_key();

	@Autowired
	private ServicioService servicioService;

	/*Crear servicio*/
	@RequestMapping(value = "/servicio/create", method = RequestMethod.POST)
	public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData, @RequestParam String apiKey) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();

		if(apiKey.equals(p_api_key)){

			Servicio servicio = servicioService.getByNombre(jsonData.get("nombre").toString());

			if(servicio == null){/*No hay servicios con el mismo nombre*/
				servicioService.create(jsonData.get("nombre").toString(), jsonData.get("descripcion").toString(), jsonData.get("compromiso").toString(), jsonData.get("tarifa").toString());
				map.put("status", "201");
				map.put("message", "OK");
				result.add(map);
				return result;
			}else{/*Existe un servicio con el mismo nombre*/
				map.put("status", "401");
				map.put("message", "Servicio Ya Existe!");
				result.add(map);
				return result;
			}
		}else{/*Error de la API*/
			map.put("status", "403");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}/*Fin create*/


	/*Obtener servicio por nombre*/
	@RequestMapping(value = "/servicio/getServicio", method = RequestMethod.GET)
	public Servicio getServicio(@RequestParam String nombre, @RequestParam String api_key) {
        return servicioService.getByNombre(nombre);
		
	}/*Fin GET*/

	/*Obtener todos los servicios*/
	@RequestMapping(value = "/servicio/getAll", method = RequestMethod.GET)
	public List<Servicio> getAll() {
		return servicioService.getAll();
	}


	/*Actualizar Servicio*/
	@RequestMapping(value = "/servicio/updateServicio/{id}", method = RequestMethod.PUT)
	public void updateServicio(@RequestParam Servicio servicio, @PathVariable String id) {
		servicioService.updateServicio(id, servicio);
	}

	/*Eliminar servicio*/
	@RequestMapping(value="/servicio/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@RequestParam String id){
		servicioService.delete(id);
		return "Eliminado" + id;

	}

	/*Eliminar todos los servicios*/
	@RequestMapping(value="/servicio/deleteAll", method = RequestMethod.DELETE)
	public String deleteAll(){
		servicioService.deleteAll();
		return "Eliminados los servicios";

	}


}/*Fin controlador*/