package backend.services;

import backend.models.ArquitecturaEmpresarial;
import backend.repositories.ArquitecturaEmpresarialRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ArquitecturaEmpresarialServiceTest {

    @Mock
    ArquitecturaEmpresarialRepository arquitecturaEmpresarialRepository;

    @InjectMocks
    ArquitecturaEmpresarialService arquitecturaEmpresarialService;

    @Test
    public void createTest() {
        String titulo = "Titulo test";

        Mockito.when(arquitecturaEmpresarialRepository.save(Mockito.any(ArquitecturaEmpresarial.class))).thenReturn(new ArquitecturaEmpresarial(titulo));

        ArquitecturaEmpresarial arquitecturaEmpresarial = arquitecturaEmpresarialService.create(titulo);
        Assert.assertEquals(arquitecturaEmpresarial.getTitulo(), titulo);
    }

    @Test
    public void updateTest() {
        String titulo = "Titulo test";
        ArquitecturaEmpresarial arquitecturaEmpresarialTest = new ArquitecturaEmpresarial(titulo);
        String id = "1";

        Mockito.when(arquitecturaEmpresarialRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(arquitecturaEmpresarialTest));
        Mockito.when(arquitecturaEmpresarialRepository.save(Mockito.any(ArquitecturaEmpresarial.class))).thenReturn(new ArquitecturaEmpresarial(titulo));

        ArquitecturaEmpresarial arquitecturaEmpresarial = arquitecturaEmpresarialService.update(id, titulo);

        Assert.assertEquals(arquitecturaEmpresarial.getTitulo(), titulo);
    }

    @Test
    public void updateTestIfNotFound() {
        String titulo = "Titulo test";
        String id = "1";

        Mockito.when(arquitecturaEmpresarialRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        ArquitecturaEmpresarial arquitecturaEmpresarial = arquitecturaEmpresarialService.update(id, titulo);
        Assert.assertNull(arquitecturaEmpresarial);
    }

    @Test
    public void existTestIfFound() {
        String titulo = "Ejemplo";

        Mockito.when(arquitecturaEmpresarialRepository.findOneByTitulo(titulo)).thenReturn(new ArquitecturaEmpresarial("test"));

        Assert.assertTrue(arquitecturaEmpresarialService.exist(titulo));
    }

    @Test
    public void existTestIfNotFound() {
        String titulo = "Ejemplo";

        Mockito.when(arquitecturaEmpresarialRepository.findOneByTitulo(titulo)).thenReturn(null);

        Assert.assertFalse(arquitecturaEmpresarialService.exist(titulo));
    }
}