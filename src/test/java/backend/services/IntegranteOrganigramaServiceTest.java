package backend.services;

import backend.models.IntegranteOrganigrama;
import backend.repositories.IntegranteOrganigramaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class IntegranteOrganigramaServiceTest {

    @Mock
    IntegranteOrganigramaRepository integranteOrganigramaRepository;

    @InjectMocks
    IntegranteOrganigramaService integranteOrganigramaService;

    @Test
    public void createTest() {
        String firstName = "Nombre test";
        String lastName = "Apellido test";
        String photoUrl = "URL test";
        String position = "Position test";
        int parent = 0;
        int child = 1;

        Mockito.when(integranteOrganigramaRepository.save(Mockito.any(IntegranteOrganigrama.class))).thenReturn(new IntegranteOrganigrama(firstName, lastName, photoUrl, position, parent, child));

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.create(firstName, lastName, photoUrl, position, parent, child);

        Assert.assertEquals(integranteOrganigrama.getFirstName(), firstName);
        Assert.assertEquals(integranteOrganigrama.getLastName(), lastName);
        Assert.assertEquals(integranteOrganigrama.getPhotoUrl(), photoUrl);
        Assert.assertEquals(integranteOrganigrama.getPosition(), position);
        Assert.assertEquals(integranteOrganigrama.getParent(), parent);
        Assert.assertEquals(integranteOrganigrama.getChild(), child);
    }

    @Test
    public void findByNameTestIfFound() {
        String firstName = "Nombre test";
        String lastName = "Apellido test";
        String photoUrl = "URL test";
        String position = "Position test";
        int parent = 0;
        int child = 1;
        IntegranteOrganigrama integranteTest = new IntegranteOrganigrama(firstName, lastName, photoUrl, position, parent, child);
        List<IntegranteOrganigrama> testList = new ArrayList<>();
        testList.add(integranteTest);

        Mockito.when(integranteOrganigramaRepository.getByFirstName(Mockito.any(String.class))).thenReturn(testList);

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.findByName(firstName, lastName);

        Assert.assertEquals(integranteOrganigrama.getFirstName(), firstName);
        Assert.assertEquals(integranteOrganigrama.getLastName(), lastName);
    }

    @Test
    public void findByNameTestIfNotFound() {
        String firstName = "Nombre test";
        String lastName = "Apellido test";
        List<IntegranteOrganigrama> testList = new ArrayList<>();

        Mockito.when(integranteOrganigramaRepository.getByFirstName(Mockito.any(String.class))).thenReturn(testList);

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.findByName(firstName, lastName);

        Assert.assertNull(integranteOrganigrama);
    }

    @Test
    public void findByPosition() {
        String firstName = "Nombre test";
        String lastName = "Apellido test";
        String photoUrl = "URL test";
        String position = "Position test";
        int parent = 0;
        int child = 1;
        IntegranteOrganigrama integranteTest = new IntegranteOrganigrama(firstName, lastName, photoUrl, position, parent, child);
        List<IntegranteOrganigrama> testList = new ArrayList<>();
        testList.add(integranteTest);

        Mockito.when(integranteOrganigramaRepository.getByPosition(Mockito.any(String.class))).thenReturn(testList);

        List<IntegranteOrganigrama> integranteOrganigrama = integranteOrganigramaService.findByPosition(position);

        Assert.assertEquals(integranteOrganigrama.get(0).getPosition(), position);
    }

    @Test
    public void findByPositionTestIfNotFound() {
        String position = "Position test";
        List<IntegranteOrganigrama> testList = new ArrayList<>();

        Mockito.when(integranteOrganigramaRepository.getByPosition(Mockito.any(String.class))).thenReturn(testList);

        List<IntegranteOrganigrama> integranteOrganigrama = integranteOrganigramaService.findByPosition(position);

        Assert.assertNull(integranteOrganigrama);
    }

    @Test
    public void update() {
        String firstName = "Nombre test";
        String lastName = "Apellido test";
        String photoUrl = "URL test";
        String position = "Position test";
        int parent = 0;
        int child = 1;

        Mockito.when(integranteOrganigramaRepository.save(Mockito.any(IntegranteOrganigrama.class))).thenReturn(new IntegranteOrganigrama(firstName, lastName, photoUrl, position, parent, child));

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.update(new IntegranteOrganigrama(firstName, lastName, photoUrl, position, parent, child));

        Assert.assertEquals(integranteOrganigrama.getFirstName(), firstName);
        Assert.assertEquals(integranteOrganigrama.getLastName(), lastName);
        Assert.assertEquals(integranteOrganigrama.getPhotoUrl(), photoUrl);
        Assert.assertEquals(integranteOrganigrama.getPosition(), position);
        Assert.assertEquals(integranteOrganigrama.getParent(), parent);
        Assert.assertEquals(integranteOrganigrama.getChild(), child);
    }
}