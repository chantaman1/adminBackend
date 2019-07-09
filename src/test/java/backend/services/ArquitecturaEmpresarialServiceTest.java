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
        String descripcion = "Descripcion test";

        Mockito.when(arquitecturaEmpresarialRepository.save(Mockito.any(ArquitecturaEmpresarial.class))).thenReturn(new ArquitecturaEmpresarial(titulo, descripcion));

        ArquitecturaEmpresarial arquitecturaEmpresarial = arquitecturaEmpresarialService.create(titulo, descripcion);
        Assert.assertEquals(arquitecturaEmpresarial.getTitulo(), titulo);
        Assert.assertEquals(arquitecturaEmpresarial.getDescripcion(), descripcion);
    }

    @Test
    public void updateTest() {
        String titulo = "Titulo test";
        String descripcion = "Descripcion test";
        ArquitecturaEmpresarial arquitecturaEmpresarialTest = new ArquitecturaEmpresarial(titulo, descripcion);
        String id = "1";

        Mockito.when(arquitecturaEmpresarialRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(arquitecturaEmpresarialTest));
        Mockito.when(arquitecturaEmpresarialRepository.save(Mockito.any(ArquitecturaEmpresarial.class))).thenReturn(new ArquitecturaEmpresarial(titulo, descripcion));

        ArquitecturaEmpresarial arquitecturaEmpresarial = arquitecturaEmpresarialService.update(id, titulo, descripcion);

        Assert.assertEquals(arquitecturaEmpresarial.getTitulo(), titulo);
        Assert.assertEquals(arquitecturaEmpresarial.getDescripcion(), descripcion);
    }

    @Test
    public void updateTestIfNotFound() {
        String titulo = "Titulo test";
        String descripcion = "Descripcion test";
        String id = "1";

        Mockito.when(arquitecturaEmpresarialRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        ArquitecturaEmpresarial arquitecturaEmpresarial = arquitecturaEmpresarialService.update(id, titulo, descripcion);
        Assert.assertNull(arquitecturaEmpresarial);
    }

    @Test
    public void existTestIfFound() {
        String titulo = "Ejemplo";

        Mockito.when(arquitecturaEmpresarialRepository.findOneByTitulo(titulo)).thenReturn(new ArquitecturaEmpresarial("test", "test"));

        Assert.assertTrue(arquitecturaEmpresarialService.exist(titulo));
    }

    @Test
    public void existTestIfNotFound() {
        String titulo = "Ejemplo";

        Mockito.when(arquitecturaEmpresarialRepository.findOneByTitulo(titulo)).thenReturn(null);

        Assert.assertFalse(arquitecturaEmpresarialService.exist(titulo));
    }
}