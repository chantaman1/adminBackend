package backend.services;

import backend.models.EntradaDiccionario;
import backend.repositories.EntradaDiccionarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EntradaDiccionarioServiceTest {

    @Mock
    EntradaDiccionarioRepository entradaDiccionarioRepository;

    @InjectMocks
    EntradaDiccionarioService entradaDiccionarioService;

    @Test
    public void createTest() {
        String descripcion = "Descripcion test";
        String idArquitectura = "123123";
        int indentacion = 1;
        String bpmn = "BPMN test";
        String reci = "Matriz test";

        Mockito.when(entradaDiccionarioRepository.save(Mockito.any(EntradaDiccionario.class))).thenReturn(new EntradaDiccionario(descripcion, idArquitectura, indentacion, bpmn, reci));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.create(descripcion, idArquitectura, indentacion, bpmn, reci);

        Assert.assertEquals(entradaDiccionario.getTitulo(), descripcion);
        Assert.assertEquals(entradaDiccionario.getIndentacion(), indentacion);
        Assert.assertEquals(entradaDiccionario.getBpmn(), bpmn);
        Assert.assertEquals(entradaDiccionario.getMatrizRECI(), reci);
        Assert.assertEquals(entradaDiccionario.getIdArquitecturaEmpresarial(), idArquitectura);
    }

    @Test
    public void updateEntradaDiccionarioTestIfFound() {
        String descripcion = "Descripcion test";
        String idArquitectura = "123123";
        int indentacion = 1;
        String bpmn = "BPMN test";
        String reci = "Matriz test";
        String id = "1";
        EntradaDiccionario entradaDiccionarioTest = new EntradaDiccionario(descripcion, idArquitectura, indentacion, bpmn, reci);

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(entradaDiccionarioTest));
        Mockito.when(entradaDiccionarioRepository.save(Mockito.any(EntradaDiccionario.class))).thenReturn(new EntradaDiccionario(descripcion, idArquitectura, indentacion, bpmn, reci));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.updateEntradaDiccionario(id, descripcion, indentacion);

        Assert.assertEquals(entradaDiccionario.getTitulo(), descripcion);
        Assert.assertEquals(entradaDiccionario.getIndentacion(), indentacion);
    }

    @Test
    public void updateEntradaDiccionarioTestIfNotFound() {
        String descripcion = "Descripcion test";
        int indentacion = 1;
        String id = "1";

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.updateEntradaDiccionario(id, descripcion, indentacion);

        Assert.assertNull(entradaDiccionario);
    }

    @Test
    public void checkEntradaDiccionarioTestIfFound() {
        String id = "1";
        EntradaDiccionario entradaDiccionario = new EntradaDiccionario();
        entradaDiccionario.set_id(id);

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(entradaDiccionario));

        Assert.assertTrue(entradaDiccionarioService.checkEntradaDiccionario(id));
    }

    @Test
    public void checkEntradaDiccionarioTestIfNotFound() {
        String id = "1";

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        Assert.assertFalse(entradaDiccionarioService.checkEntradaDiccionario(id));
    }

    @Test
    public void updateBPMNTestIfFound() {
        String descripcion = "Descripcion test";
        String idArquitectura = "123123";
        int indentacion = 1;
        String bpmn = "BPMN test";
        String reci = "Matriz test";
        String id = "1";
        EntradaDiccionario entradaDiccionarioTest = new EntradaDiccionario(descripcion, idArquitectura, indentacion, bpmn, reci);

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(entradaDiccionarioTest));
        Mockito.when(entradaDiccionarioRepository.save(Mockito.any(EntradaDiccionario.class))).thenReturn(new EntradaDiccionario(descripcion, idArquitectura, indentacion, bpmn, reci));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.updateBPMN(id, bpmn);

        Assert.assertEquals(entradaDiccionario.getBpmn(), bpmn);
    }

    @Test
    public void updateBPMNTestIfNotFound() {
        String bpmn = "BPMN test";
        String id = "1";

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.updateBPMN(id, bpmn);

        Assert.assertNull(entradaDiccionario);
    }

    @Test
    public void updateMatrizRECITestIfFound() {
        String descripcion = "Descripcion test";
        String idArquitectura = "123123";
        int indentacion = 1;
        String bpmn = "BPMN test";
        String reci = "Matriz test";
        String id = "1";
        EntradaDiccionario entradaDiccionarioTest = new EntradaDiccionario(descripcion, idArquitectura, indentacion, bpmn, reci);

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(entradaDiccionarioTest));
        Mockito.when(entradaDiccionarioRepository.save(Mockito.any(EntradaDiccionario.class))).thenReturn(new EntradaDiccionario(descripcion, idArquitectura, indentacion, bpmn, reci));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.updateMatrizRECI(id, reci);

        Assert.assertEquals(entradaDiccionario.getMatrizRECI(), reci);
    }

    @Test
    public void updateMatrizReciTestIfNotFound() {
        String reci = "Matriz test";
        String id = "1";

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.updateBPMN(id, reci);

        Assert.assertNull(entradaDiccionario);
    }

    @Test
    public void findByIdTestIfFound() {
        String id = "1";
        EntradaDiccionario entradaDiccionarioTest = new EntradaDiccionario();

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(entradaDiccionarioTest));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.findById(id);

        Assert.assertNotNull(entradaDiccionario);
    }

    @Test
    public void findByIdTestIfNotFound() {
        String id = "1";
        EntradaDiccionario entradaDiccionarioTest = new EntradaDiccionario();

        Mockito.when(entradaDiccionarioRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        EntradaDiccionario entradaDiccionario = entradaDiccionarioService.findById(id);

        Assert.assertNull(entradaDiccionario);
    }
}