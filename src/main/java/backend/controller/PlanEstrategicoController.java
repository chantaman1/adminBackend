package backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public HashMap<String, Object> create(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, Object> map = new HashMap<>();
		if(api_key.equals(p_api_key)) {
			PlanEstrategico plan = planEstrategicoService.getByName(jsonData.get("name").toString());
			if(plan == null) {
				planEstrategicoService.create(jsonData.get("name").toString(), jsonData.get("description").toString());
				map.put("status", 201);
				map.put("message", "OK");
				map.put("result", true);
				return map;
			}
			else {
				map.put("status", 401);
				map.put("message", "STRATEGIC PLAN ALREADY EXIST!");
				map.put("result", false);
				return map;
			}
			
		}
		else {
			map.put("status", 403);
			map.put("message", "WRONG API KEY.");
			map.put("result", false);
			return map;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/get", method = RequestMethod.GET)
	public HashMap<String, Object> getPlan(@RequestParam String api_key) {
		HashMap<String, Object> map = new HashMap<>();
		if(api_key.equals(p_api_key)) {
			List<PlanEstrategico> planes = planEstrategicoService.getAll();
			if(planes.isEmpty()) {
				map.put("status", "401");
				map.put("message", "STRATEGIC PLAN NOT CREATED!.");
				map.put("result", false);
				map.put("data", null);
				return map;
			}
			else {
				map.put("status", 200);
				map.put("message", "OK");
				map.put("result", true);
				map.put("data", planes);
				return map;
			}
		}
		else {
			map.put("status", "403");
			map.put("message", "WRONG API KEY.");
			map.put("result", false);
			map.put("data", null);
			return map;
		}
	}
	
	@RequestMapping(value = "/planEstrategico/updatePlan", method = RequestMethod.POST)
	public HashMap<String, Object> updatePlan(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key) {
		HashMap<String, Object> map = new HashMap<>();
		if(api_key.equals(p_api_key)) {
			String name = jsonData.get("name").toString();
			String description = jsonData.get("description").toString();
			if(name == null) {
				map.put("status", 404);
				map.put("message", "NAME NOT GIVEN.");
				map.put("result", false);
				return map;
			}else {
				PlanEstrategico plan = planEstrategicoService.updatePlan(name, description);
				if (plan == null) {
					map.put("status", 401);
					map.put("message", "STRATEGIC PLAN NOT CREATED!.");
					map.put("result", false);
					return map;
				}
				map.put("status", 200);
				map.put("message", "OK");
				map.put("result", true);
				return map;
			}
		}
		else {
			map.put("status", 400);
			map.put("message", "WRONG API KEY.");
			map.put("result", false);
			return map;
		}
	}
	@DeleteMapping("/planEstrategico/deletePlan")
	@ResponseBody
	public HashMap<String, Object> deletePlan(@RequestBody Map<String, Object> jsonData, @RequestParam String api_key){
		HashMap<String, Object> map = new HashMap<>();
		if(api_key.equals(p_api_key)) {
			String name = jsonData.get("name").toString();
			if(name != null){
				PlanEstrategico plan = planEstrategicoService.getByName(name);
				if(plan != null){
					planEstrategicoService.deletePlan(name);
					map.put("status", 200);
					map.put("message", "OK");
					map.put("result", true);
					return map;
				}
				else{
					map.put("status", 404);
					map.put("message", "THIS PLAN DOES NOT EXIST.");
					map.put("result", false);
					return map;
				}
			}
			else{
				map.put("status", 404);
				map.put("message", "NAME NOT GIVEN.");
				map.put("result", false);
				return map;
			}
		}
		else {
			map.put("status", 400);
			map.put("message", "WRONG API KEY.");
			map.put("result", false);
			return map;
		}
	}
}
