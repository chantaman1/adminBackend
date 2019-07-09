package backend.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.models.PlanEstrategico;
import backend.repositories.PlanEstrategicoRepository;

@Component
public class PlanEstrategicoService {
	@Autowired
	PlanEstrategicoRepository planEstrategicoRepository;
	
	public PlanEstrategico create(String name, String description) {
		LocalDate localDate = LocalDate.now();
		return planEstrategicoRepository.save(new PlanEstrategico(name, description, localDate));
	}
	
	public List<PlanEstrategico> getAll(){
		return planEstrategicoRepository.findAll();
	}
	
	public PlanEstrategico updatePlan(String name, String description) {
		List<PlanEstrategico> planes = planEstrategicoRepository.findAll();
		if(planes.isEmpty()) {
			return null;
		}
		for(PlanEstrategico plan : planes){
			if(plan.name.equals(name)){
				plan.setDescription(description);
				return planEstrategicoRepository.save(plan);
			}
		}
		return null;
	}

	public PlanEstrategico getByName(String name){
		return planEstrategicoRepository.findPlanEstrategicoByName(name);
	}
	
}
