package backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.models.PlanEstrategico;

public interface PlanEstrategicoRepository extends MongoRepository<PlanEstrategico, String>{
	
}
