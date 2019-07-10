package backend.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    Users users;

    @Before
    public void testing(){
        users = new Users("FirstName", "LastName", "Correo", "Contrasena", "Role", "Creacion", "Creacion2", "TestPic");
        users.set_id("123");
    }

    @Test
    public void get_id() {
        assertEquals("123", users.get_id());
    }

    @Test
    public void set_id() {
        users.set_id("Test");
        assertEquals("Test", users.get_id());
    }

    @Test
    public void getFirstName() {
        assertEquals("FirstName", users.getFirstName());
    }

    @Test
    public void setFirstName() {
        users.setFirstName("Test");
        assertEquals("Test", users.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("LastName", users.getLastName());
    }

    @Test
    public void setLastName() {
        users.setLastName("Test");
        assertEquals("Test", users.getLastName());
    }

    @Test
    public void getEmail() {
        assertEquals("Correo", users.getEmail());
    }

    @Test
    public void setEmail() {
        users.setEmail("Test");
        assertEquals("Test", users.getEmail());
    }

    @Test
    public void getPassword() {
        assertEquals("Contrasena", users.getPassword());
    }

    @Test
    public void setPassword() {
        users.setPassword("Test");
        assertEquals("Test", users.getPassword());
    }

    @Test
    public void getRole() {
        assertEquals("Role", users.getRole());
    }

    @Test
    public void setRole() {
        users.setRole("Test");
        assertEquals("Test", users.getRole());
    }

    @Test
    public void getCreationDate() {
        assertEquals("Creacion", users.getCreationDate());
    }

    @Test
    public void setCreationDate() {
        users.setCreationDate("Test");
        assertEquals("Test", users.getCreationDate());
    }

    @Test
    public void getCreationTime() {
        assertEquals("Creacion2", users.getCreationTime());
    }

    @Test
    public void setCreationTime() {
        users.setCreationTime("Test");
        assertEquals("Test", users.getCreationTime());
    }

    @Test
    public void getProfilePicTest() {
        assertEquals("TestPic", users.getProfilePic());
    }

    @Test
    public void setProfilePicTest() {
        users.setProfilePic("Test");
        assertEquals("Test", users.getProfilePic());
    }
}
