package backend.services;

import backend.models.PlanEstrategico;
import backend.repositories.PlanEstrategicoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PlanEstrategicoServiceTest {

    @Mock
    PlanEstrategicoRepository planEstrategicoRepository;

    @InjectMocks
    PlanEstrategicoService planEstrategicoService;

    @Test
    public void createTest() {
        String name = "Test name";
        String description = "Test description";
        LocalDate createdAt = LocalDate.now();

        Mockito.when(planEstrategicoRepository.save(Mockito.any(PlanEstrategico.class))).thenReturn(new PlanEstrategico(name, description, createdAt));

        PlanEstrategico planEstrategico = planEstrategicoService.create(name, description);

        Assert.assertEquals(planEstrategico.getName(), name);
        Assert.assertEquals(planEstrategico.getDescription(), description);
        Assert.assertEquals(planEstrategico.getCreatedAt(), createdAt);
    }

    @Test
    public void updatePlanTestIfFound() {
        String name = "Test name";
        String description = "Test description";
        LocalDate createdAt = LocalDate.now();
        List<PlanEstrategico> testList = new ArrayList<>();
        testList.add(new PlanEstrategico(name, description, createdAt));

        Mockito.when(planEstrategicoRepository.findAll()).thenReturn(testList);
        Mockito.when(planEstrategicoRepository.save(Mockito.any(PlanEstrategico.class))).thenReturn(testList.get(0));

        PlanEstrategico planEstrategico = planEstrategicoService.updatePlan(name, description);

        Assert.assertEquals(planEstrategico.getDescription(), description);
    }

    @Test
    public void updatePlanTestIfNoCorrectPlan() {
        String name = "Test name";
        String description = "Test description";
        LocalDate createdAt = LocalDate.now();
        List<PlanEstrategico> testList = new ArrayList<>();
        testList.add(new PlanEstrategico("Test name distinto", description, createdAt));

        Mockito.when(planEstrategicoRepository.findAll()).thenReturn(testList);

        PlanEstrategico planEstrategico = planEstrategicoService.updatePlan(name, description);

        Assert.assertNull(planEstrategico);
    }

    @Test
    public void updatePlanTestIfNotFound() {
        String name = "Test name";
        String description = "Test description";
        List<PlanEstrategico> testList = new ArrayList<>();

        Mockito.when(planEstrategicoRepository.findAll()).thenReturn(testList);

        PlanEstrategico planEstrategico = planEstrategicoService.updatePlan(name, description);

        Assert.assertNull(planEstrategico);
    }

    @Test
    public void getByNameTestIfFound() {
        String name = "Test name";
        String description = "Test description";
        LocalDate createdAt = LocalDate.now();

        Mockito.when(planEstrategicoRepository.findPlanEstrategicoByName(Mockito.any(String.class))).thenReturn(new PlanEstrategico(name, description, createdAt));

        PlanEstrategico planEstrategico = planEstrategicoService.getByName(name);

        Assert.assertEquals(planEstrategico.getName(), name);
    }

    @Test
    public void getByNameTestIfNotFound() {
        String name = "Test name";

        Mockito.when(planEstrategicoRepository.findPlanEstrategicoByName(Mockito.any(String.class))).thenReturn(null);

        PlanEstrategico planEstrategico = planEstrategicoService.getByName(name);

        Assert.assertNull(planEstrategico);
    }
}