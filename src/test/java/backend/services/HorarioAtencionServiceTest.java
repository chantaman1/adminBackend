package backend.services;

import backend.models.HorarioAtencion;
import backend.repositories.HorarioAtencionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HorarioAtencionServiceTest {

    @Mock
    HorarioAtencionRepository horarioAtencionRepository;

    @InjectMocks
    HorarioAtencionService horarioAtencionService;

    @Test
    public void createTest() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        HorarioAtencion horarioAtencion = horarioAtencionService.create(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        Assert.assertEquals(horarioAtencion.getMonday(), monday);
        Assert.assertEquals(horarioAtencion.getTuesday(), tuesday);
        Assert.assertEquals(horarioAtencion.getWednesday(), wednesday);
        Assert.assertEquals(horarioAtencion.getThursday(), thursday);
        Assert.assertEquals(horarioAtencion.getFriday(), friday);
        Assert.assertEquals(horarioAtencion.getSaturday(), saturday);
        Assert.assertEquals(horarioAtencion.getSunday(), sunday);
        Assert.assertEquals(horarioAtencion.getCreatedAt(), createdAt);
    }

    @Test
    public void updateMondayTestIfExist() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateMonday("Test lunes");

        Assert.assertEquals(horarioAtencion.getMonday(), monday);
    }

    @Test
    public void updateMondayTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateMonday("Test lunes");

        Assert.assertNull(horarioAtencion);
    }

    @Test
    public void updateTuesdayTestIfExist() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateTuesday("Test martes");

        Assert.assertEquals(horarioAtencion.getTuesday(), tuesday);
    }

    @Test
    public void updateTuesdayTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateTuesday("Test martes");

        Assert.assertNull(horarioAtencion);
    }

    @Test
    public void updateWednesdayTestIfExists() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateWednesday("Test miercoles");

        Assert.assertEquals(horarioAtencion.getWednesday(), wednesday);
    }

    @Test
    public void updateWednesdayTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateWednesday("Test miercoles");

        Assert.assertNull(horarioAtencion);
    }

    @Test
    public void updateThursdayTestIfExists() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateThursday("Test jueves");

        Assert.assertEquals(horarioAtencion.getThursday(), thursday);
    }

    @Test
    public void updateThursdayTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateThursday("Test jueves");

        Assert.assertNull(horarioAtencion);
    }

    @Test
    public void updateFridayTestIfExist() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateFriday("Test jueves");

        Assert.assertEquals(horarioAtencion.getFriday(), friday);
    }

    @Test
    public void updateFridayTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateFriday("Test viernes");

        Assert.assertNull(horarioAtencion);
    }

    @Test
    public void updateSaturdayTestIfExists() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateSaturday("Test sabado");

        Assert.assertEquals(horarioAtencion.getSaturday(), saturday);
    }

    @Test
    public void updateSaturdayTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateSaturday("Test sabado");

        Assert.assertNull(horarioAtencion);
    }

    @Test
    public void updateSundayTestIfExist() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateSunday("Test domingo");

        Assert.assertEquals(horarioAtencion.getSunday(), sunday);
    }

    @Test
    public void updateSundayTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateSunday("Test domingo");

        Assert.assertNull(horarioAtencion);
    }

    @Test
    public void updateAllTestIfExist() {
        String monday = "Test lunes";
        String tuesday = "Test martes";
        String wednesday = "Test miercoles";
        String thursday = "Test jueves";
        String friday = "Test viernes";
        String saturday = "Test sabado";
        String sunday = "Test domingo";
        LocalDate createdAt = LocalDate.now();
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();
        listaHorario.add(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));

        Mockito.when(horarioAtencionRepository.save(Mockito.any(HorarioAtencion.class))).thenReturn(new HorarioAtencion(monday, tuesday, wednesday, thursday, friday, saturday, sunday, createdAt));
        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateAll(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        Assert.assertEquals(horarioAtencion.getMonday(), monday);
        Assert.assertEquals(horarioAtencion.getTuesday(), tuesday);
        Assert.assertEquals(horarioAtencion.getWednesday(), wednesday);
        Assert.assertEquals(horarioAtencion.getThursday(), thursday);
        Assert.assertEquals(horarioAtencion.getFriday(), friday);
        Assert.assertEquals(horarioAtencion.getSaturday(), saturday);
        Assert.assertEquals(horarioAtencion.getSunday(), sunday);
    }

    @Test
    public void updateAllTestIfNotExist() {
        ArrayList<HorarioAtencion> listaHorario = new ArrayList<>();

        Mockito.when(horarioAtencionRepository.findAll()).thenReturn(listaHorario);

        HorarioAtencion horarioAtencion = horarioAtencionService.updateAll("Test lunes", "Test martes", "Test miercoles", "Test jueves", "Test viernes", "Test sabado", "Test domingo");

        Assert.assertNull(horarioAtencion);
    }
}