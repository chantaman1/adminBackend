package backend.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.models.HorarioAtencion;
import backend.repositories.HorarioAtencionRepository;

@Component
public class HorarioAtencionService {
	@Autowired
	HorarioAtencionRepository horarioAtencionRepository;
	
	public HorarioAtencion create(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
		LocalDate localDate = LocalDate.now();
		return horarioAtencionRepository.save(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, localDate));
	}
	
	public List<HorarioAtencion> getAll(){
		return horarioAtencionRepository.findAll();
	}
	
	public HorarioAtencion updateMonday(String monday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setMonday(monday);
		return horarioAtencionRepository.save(horario);
	}
	
	public HorarioAtencion updateTuesday(String tuesday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setTuesday(tuesday);
		return horarioAtencionRepository.save(horario);
	}
	
	public HorarioAtencion updateWednesday(String wednesday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setWednesday(wednesday);
		return horarioAtencionRepository.save(horario);
	}
	
	public HorarioAtencion updateThursday(String thursday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setThursday(thursday);
		return horarioAtencionRepository.save(horario);
	}
	
	public HorarioAtencion updateFriday(String friday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setFriday(friday);
		return horarioAtencionRepository.save(horario);
	}
	
	public HorarioAtencion updateSaturday(String saturday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setSaturday(saturday);
		return horarioAtencionRepository.save(horario);
	}
	
	public HorarioAtencion updateSunday(String sunday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setSunday(sunday);
		return horarioAtencionRepository.save(horario);
	}
	
	public HorarioAtencion updateAll(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
		List<HorarioAtencion> horarios = horarioAtencionRepository.findAll();
		if(horarios.isEmpty()) {
			return null;
		}
		HorarioAtencion horario = horarios.get(0);
		horario.setMonday(monday);
		horario.setTuesday(tuesday);
		horario.setWednesday(wednesday);
		horario.setThursday(thursday);
		horario.setFriday(friday);
		horario.setSaturday(saturday);
		horario.setSunday(sunday);
		return horarioAtencionRepository.save(horario);
	}
}
