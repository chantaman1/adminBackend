package backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import backend.models.Servicio;
import backend.services.ServicioService;

@RestController
public class ServicioController {
	private ApiKey apikey = new ApiKey();
	private String p_api_key = apikey.getApi_key();

	@Autowired
	private ServicioService servicioService;

	@RequestMapping(value = "/servicio/create", method = RequestMethod.POST)
	public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData, @RequestParam String apiKey) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();

		if(apiKey.equals(p_api_key)){

			Servicio servicio = servicioService.getByNombre(jsonData.get("nombre").toString());

			if(servicio==NULL){/*No hay servicios con el mismo nombre*/
				servicios.create(jsonData.get("nombre").toString(), jsonData.get("descripcion").toString(), jsonData.get("compromiso").toString(), jsonData.get("tarifa").toString());
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






}/*Fin controlador*/