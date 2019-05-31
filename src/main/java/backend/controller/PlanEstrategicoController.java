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

import backend.extra.ApiKey;
import backend.models.PlanEstrategico;
import backend.services.PlanEstrategicoService;

@RestController
public class PlanEstrategicoController {
	
	private ApiKey apikey = new ApiKey();
	private String p_api_key = apikey.getApi_key();
	
	@Autowired
	private PlanEstrategicoService planEstrategicoService;
	
	@RequestMapping(value = "/planEstrategico/create", method = RequestMethod.POST)
	public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			List<PlanEstrategico> planes = planEstrategicoService.getAll();
			if(planes.isEmpty()) {
				planEstrategicoService.create(jsonData.get("vision").toString(), jsonData.get("mision").toString(), jsonData.get("objetivo").toString(), jsonData.get("estrategia").toString(), jsonData.get("valor").toString());
				map.put("status", "201");
				map.put("message", "OK");
				result.add(map);
				return result;
			}
			else {
				map.put("status", "401");
				map.put("message", "STRATEGIC PLAN ALREADY EXIST!");
				result.add(map);
				return result;
			}
			
		}
		else {
			map.put("status", "403");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/get", method = RequestMethod.GET)
	public List<HashMap<String, String>> getPlan(@RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			List<PlanEstrategico> planes = planEstrategicoService.getAll();
			if(planes.isEmpty()) {
				map.put("status", "401");
				map.put("message", "STRATEGIC PLAN NOT CREATED!.");
				result.add(map);
				return result;
			}
			else {
				map.put("status", "200");
				map.put("message", "OK");
				map.put("vision", planes.get(0).getVision());
				map.put("mision", planes.get(0).getMision());
				map.put("objetivo", planes.get(0).getObjetivo());
				map.put("estrategia", planes.get(0).getEstrategia());
				map.put("valor", planes.get(0).getValor());
				result.add(map);
				return result;
			}
		}
		else {
			map.put("status", "403");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/updateVision", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateVision(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String vision = jsonData.get("vision").toString();
			if(vision == null) {
				map.put("status", "404");
				map.put("message", "VISION NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				PlanEstrategico plan = planEstrategicoService.updateVision(vision);
				return getHashMaps(map, result, plan);
			}
		}
		else {
			map.put("status", "400");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/updateMision", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateMision(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String mision = jsonData.get("mision").toString();
			if(mision == null) {
				map.put("status", "404");
				map.put("message", "MISION NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				PlanEstrategico plan = planEstrategicoService.updateMision(mision);
				return getHashMaps(map, result, plan);
			}
		}
		else {
			map.put("status", "400");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/updateObjetivo", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateObjetivo(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String objetivo = jsonData.get("objetivo").toString();
			if(objetivo == null) {
				map.put("status", "404");
				map.put("message", "OBJETIVE NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				PlanEstrategico plan = planEstrategicoService.updateObjetivo(objetivo);
				return getHashMaps(map, result, plan);
			}
		}
		else {
			map.put("status", "400");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/updateEstrategia", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateEstrategia(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String estrategia = jsonData.get("estrategia").toString();
			if(estrategia == null) {
				map.put("status", "404");
				map.put("message", "STRATEGY NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				PlanEstrategico plan = planEstrategicoService.updateEstrategia(estrategia);
				return getHashMaps(map, result, plan);
			}
		}
		else {
			map.put("status", "400");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/updateValor", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateValor(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String valor = jsonData.get("valor").toString();
			if(valor == null) {
				map.put("status", "404");
				map.put("message", "VALOR NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				PlanEstrategico plan = planEstrategicoService.updateValor(valor);
				return getHashMaps(map, result, plan);
			}
		} else {
			map.put("status", "400");
			map.put("message", "WRONG API KEY.");
			result.add(map);
			return result;
		}
	}

	private List<HashMap<String, String>> getHashMaps(HashMap<String, String> map, List<HashMap<String, String>> result, PlanEstrategico plan) {
		if (plan == null) {
			map.put("status", "401");
			map.put("message", "STRATEGIC PLAN NOT CREATED!.");
			result.add(map);
			return result;
		}
		map.put("status", "200");
		map.put("message", "OK");
		result.add(map);
		return result;
	}

}
