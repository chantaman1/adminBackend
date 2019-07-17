package backend.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArquitecturaEmpresarialTest {

    ArquitecturaEmpresarial empresarial;

    @Before
    public void testing(){
        empresarial =  new ArquitecturaEmpresarial();
        empresarial.set_id("123");
        empresarial.setTitulo("Titulo Test");
    }

    @Test
    public void getIdTest(){
        Assert.assertEquals("123", empresarial.get_id());
    }

    @Test
    public void getTituloTest(){
        Assert.assertEquals("Titulo Test", empresarial.getTitulo());
    }

}
