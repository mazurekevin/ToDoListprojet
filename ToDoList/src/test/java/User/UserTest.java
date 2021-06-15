package User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class UserTest {

    private User user;
    private User user2;

    @Before
    public void init(){
        this.user = new User( "test@yopmail.fr", "TEST", "Bla", "24", "blablabla");
        this.user2 = new User( "user.testgmail.com", "TEST", "Bla", "20", "blablabla");

    }

    @Test
    public void isValidTest(){
        Assert.assertTrue(this.user.isValid());
        Assert.assertFalse(this.user2.isValid());

    }

    @Test
    public void isValidFirstname(){
        Assert.assertEquals(true, this.user.isFirstnameValid(this.user.getFirstname()));
    }

    @Test
    public void isValidLastname(){
        Assert.assertEquals(true, this.user.isLastnameValid(this.user.getLastname()));
    }

    @Test
    public void isValidMail(){
        Assert.assertEquals(true, this.user.isEmailValid(this.user.getMail()));
    }

    @Test
    public void isValidPassword() {
        Assert.assertEquals(true, this.user.isPasswordValid(this.user.getPassword()));
    }
}
