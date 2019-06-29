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
import backend.models.HorarioAtencion;
import backend.models.PlanEstrategico;
import backend.services.HorarioAtencionService;

@RestController
public class HorarioAtencionController {
	
	private ApiKey apikey = new ApiKey();
	private String p_api_key = apikey.getApi_key();
	
	@Autowired
	private HorarioAtencionService horarioAtencionService;
	
	@RequestMapping(value = "/horarioAtencion/create", method = RequestMethod.POST)
	public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			List<HorarioAtencion> horarios = horarioAtencionService.getAll();
			if(horarios.isEmpty()) {
				horarioAtencionService.create(jsonData.get("monday").toString(), jsonData.get("tuesday").toString(), jsonData.get("wednesday").toString(), jsonData.get("thursday").toString(), jsonData.get("friday").toString(), jsonData.get("saturday").toString(), jsonData.get("sunday").toString());
				map.put("status", "201");
				map.put("message", "OK");
				result.add(map);
				return result;
			}
			else {
				map.put("status", "401");
				map.put("message", "SCHEDULE OF ATTENTION ALREADY EXIST!");
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
	
	@RequestMapping(value = "/horarioAtencion/get", method = RequestMethod.GET)
	public List<HashMap<String, String>> getPlan(@RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			List<HorarioAtencion> horarios = horarioAtencionService.getAll();
			if(horarios.isEmpty()) {
				map.put("status", "401");
				map.put("message", "SCHEDULE OF ATTENTION NOT CREATED!.");
				result.add(map);
				return result;
			}
			else {
				map.put("status", "200");
				map.put("message", "OK");
				map.put("monday", horarios.get(0).getMonday());
				map.put("tuesday", horarios.get(0).getTuesday());
				map.put("wednesday", horarios.get(0).getWednesday());
				map.put("thursday", horarios.get(0).getThursday());
				map.put("friday", horarios.get(0).getFriday());
				map.put("saturday", horarios.get(0).getSaturday());
				map.put("sunday", horarios.get(0).getSunday());
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
	
	@RequestMapping(value = "/horarioAtencion/updateMonday", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateMonday(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String monday = jsonData.get("monday").toString();
			if(monday == null) {
				map.put("status", "404");
				map.put("message", "MONDAY DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateMonday(monday);
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

	@RequestMapping(value = "/horarioAtencion/updateTuesday", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateTuesday(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String tuesday = jsonData.get("tuesday").toString();
			if(tuesday == null) {
				map.put("status", "404");
				map.put("message", "MONDAY DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateTuesday(tuesday);
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

	@RequestMapping(value = "/horarioAtencion/updateWednesday", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateWednesday(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String wednesday = jsonData.get("wednesday").toString();
			if(wednesday == null) {
				map.put("status", "404");
				map.put("message", "MONDAY DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateWednesday(wednesday);
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

	@RequestMapping(value = "/horarioAtencion/updateThursday", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateThursday(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String thursday = jsonData.get("thursday").toString();
			if(thursday == null) {
				map.put("status", "404");
				map.put("message", "MONDAY DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateThursday(thursday);
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

	@RequestMapping(value = "/horarioAtencion/updateFriday", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateFriday(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String friday = jsonData.get("friday").toString();
			if(friday == null) {
				map.put("status", "404");
				map.put("message", "MONDAY DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateFriday(friday);
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

	@RequestMapping(value = "/horarioAtencion/updateSaturday", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateSaturday(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String saturday = jsonData.get("saturday").toString();
			if(saturday == null) {
				map.put("status", "404");
				map.put("message", "MONDAY DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateSaturday(saturday);
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

	@RequestMapping(value = "/horarioAtencion/updateSunday", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateSunday(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String sunday = jsonData.get("sunday").toString();
			if(sunday == null) {
				map.put("status", "404");
				map.put("message", "MONDAY DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateSunday(sunday);
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

	@RequestMapping(value = "/horarioAtencion/updateAll", method = RequestMethod.POST)
	public List<HashMap<String, String>> updateAll(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, String> map = new HashMap<>();
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		if(api_key.equals(p_api_key)) {
			String monday = jsonData.get("monday").toString();
			String tuesday = jsonData.get("tuesday").toString();
			String wednesday = jsonData.get("wednesday").toString();
			String thursday = jsonData.get("thursday").toString();
			String friday = jsonData.get("friday").toString();
			String saturday = jsonData.get("saturday").toString();
			String sunday = jsonData.get("sunday").toString();
			if(friday == null) {
				map.put("status", "404");
				map.put("message", "DATA NOT GIVEN.");
				result.add(map);
				return result;
			}else {
				HorarioAtencion plan = horarioAtencionService.updateAll(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
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

	private List<HashMap<String, String>> getHashMaps(HashMap<String, String> map, List<HashMap<String, String>> result, HorarioAtencion plan) {
		if(plan == null) {
			map.put("status", "401");
			map.put("message", "SCHEDULE OF ATTENTION NOT CREATED!.");
			result.add(map);
			return result;
		}
		map.put("status", "200");
		map.put("message", "OK");
		result.add(map);
		return result;
	}

}
