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
	
	public PlanEstrategico create(String vision, String mision, String objetivo, String estrategia, String valor) {
		LocalDate localDate = LocalDate.now();
		return planEstrategicoRepository.save(new PlanEstrategico(vision, mision, objetivo, estrategia, valor, localDate));
	}
	
	public List<PlanEstrategico> getAll(){
		return planEstrategicoRepository.findAll();
	}
	
	public PlanEstrategico updateVision(String vision) {
		List<PlanEstrategico> planes = planEstrategicoRepository.findAll();
		if(planes.isEmpty()) {
			return null;
		}
		PlanEstrategico plan = planes.get(0);
		plan.setVision(vision);
		return planEstrategicoRepository.save(plan);
	}
	
	public PlanEstrategico updateMision(String mision) {
		List<PlanEstrategico> planes = planEstrategicoRepository.findAll();
		if(planes.isEmpty()) {
			return null;
		}
		PlanEstrategico plan = planes.get(0);
		plan.setMision(mision);
		return planEstrategicoRepository.save(plan);
	}
	
	public PlanEstrategico updateObjetivo(String objetivo) {
		List<PlanEstrategico> planes = planEstrategicoRepository.findAll();
		if(planes.isEmpty()) {
			return null;
		}
		PlanEstrategico plan = planes.get(0);
		plan.setObjetivo(objetivo);
		return planEstrategicoRepository.save(plan);
	}
	
	public PlanEstrategico updateEstrategia(String estrategia) {
		List<PlanEstrategico> planes = planEstrategicoRepository.findAll();
		if(planes.isEmpty()) {
			return null;
		}
		PlanEstrategico plan = planes.get(0);
		plan.setEstrategia(estrategia);
		return planEstrategicoRepository.save(plan);
	}
	
	public PlanEstrategico updateValor(String valor) {
		List<PlanEstrategico> planes = planEstrategicoRepository.findAll();
		if(planes.isEmpty()) {
			return null;
		}
		PlanEstrategico plan = planes.get(0);
		plan.setValor(valor);
		return planEstrategicoRepository.save(plan);
	}
	
}
