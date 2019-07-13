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
        String text = "Text test";
        String title = "Title test";
        String email = "Email test";
        String img = "Img test";
        int parent = 0;

        Mockito.when(integranteOrganigramaRepository.save(Mockito.any(IntegranteOrganigrama.class))).thenReturn(new IntegranteOrganigrama(parent, text, title, email, img));

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.create(parent, text, title, email, img);

        Assert.assertEquals(integranteOrganigrama.getText(), text);
        Assert.assertEquals(integranteOrganigrama.getTitle(), title);
        Assert.assertEquals(integranteOrganigrama.getEmail(), email);
        Assert.assertEquals(integranteOrganigrama.getImg(), img);
        Assert.assertEquals(integranteOrganigrama.getParent(), parent);
    }

    @Test
    public void findByTitleTestIfFound() {
        String text = "Text test";
        String title = "Title test";
        String email = "Email test";
        String img = "Img test";
        int parent = 0;
        IntegranteOrganigrama integranteTest = new IntegranteOrganigrama(parent, text, title, email, img);
        List<IntegranteOrganigrama> testList = new ArrayList<>();
        testList.add(integranteTest);

        Mockito.when(integranteOrganigramaRepository.getIntegranteOrganigramaByTitle(Mockito.any(String.class))).thenReturn(testList);

        List<IntegranteOrganigrama> integranteOrganigrama = integranteOrganigramaService.findByTitle(title);

        Assert.assertEquals(integranteOrganigrama.get(0).getTitle(), title);
    }

    @Test
    public void findByTitleTestIfNotFound() {
        String title = "Title test";
        List<IntegranteOrganigrama> testList = new ArrayList<>();

        Mockito.when(integranteOrganigramaRepository.getIntegranteOrganigramaByTitle(Mockito.any(String.class))).thenReturn(testList);

        List<IntegranteOrganigrama> integranteOrganigrama = integranteOrganigramaService.findByTitle(title);

        Assert.assertEquals(0, integranteOrganigrama.size());
    }

    @Test
    public void findByEmailTestIfFound() {
        String text = "Text test";
        String title = "Title test";
        String email = "Email test";
        String img = "Img test";
        int parent = 0;
        IntegranteOrganigrama integranteTest = new IntegranteOrganigrama(parent, text, title, email, img);

        Mockito.when(integranteOrganigramaRepository.getIntegranteOrganigramaByEmail(Mockito.any(String.class))).thenReturn(integranteTest);

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.findByEmail(img);

        Assert.assertEquals(integranteOrganigrama.getEmail(), email);
    }

    @Test
    public void findByEmailTestIfNotFound() {
        String email = "Email test";

        Mockito.when(integranteOrganigramaRepository.getIntegranteOrganigramaByEmail(Mockito.any(String.class))).thenReturn(null);

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.findByEmail(email);

        Assert.assertNull(integranteOrganigrama);
    }

    @Test
    public void update() {
        String text = "Text test";
        String title = "Title test";
        String email = "Email test";
        String img = "Img test";
        int parent = 0;

        Mockito.when(integranteOrganigramaRepository.save(Mockito.any(IntegranteOrganigrama.class))).thenReturn(new IntegranteOrganigrama(parent, text, title, email, img));

        IntegranteOrganigrama integranteOrganigrama = integranteOrganigramaService.update(new IntegranteOrganigrama(parent, text, title, email, img));

        Assert.assertEquals(integranteOrganigrama.getText(), text);
        Assert.assertEquals(integranteOrganigrama.getTitle(), title);
        Assert.assertEquals(integranteOrganigrama.getEmail(), email);
        Assert.assertEquals(integranteOrganigrama.getImg(), img);
        Assert.assertEquals(integranteOrganigrama.getParent(), parent);
    }
}