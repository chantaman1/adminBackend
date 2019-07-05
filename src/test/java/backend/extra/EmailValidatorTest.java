package backend.extra;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.Email;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    private EmailValidator emailValidator = new EmailValidator();

    @Test
    public void testValidEmailAddress() {
        Assert.assertTrue(emailValidator.isValidEmailAddress("example@gmail.com"));
    }

    @Test
    public void testInvalidEmailAddress() {
        Assert.assertFalse(emailValidator.isValidEmailAddress("error@@gmail,com"));
    }
}