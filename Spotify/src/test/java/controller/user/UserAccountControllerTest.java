package controller.user;

import controller.user.userType.Listener.ListenerController;
import exceptions.InvalidFormatException;
import exceptions.failedLogin.FailedLoginException;
import exceptions.failedLogin.type.UserNotFoundException;
import exceptions.failedLogin.type.WrongPasswordException;
import model.Database;
import model.user.UserAccountModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserAccountControllerTest {

    @BeforeAll
    public static void setup() throws Exception {
        HelloApplication.fillDatabase();
    }

    @Test
    public void testSignupNullPointException(){
        //Arrange
        String expected = "fill all text field!";


        //Act
        NullPointerException actual = assertThrows(NullPointerException.class, () -> {
            ListenerController.getListenerController().signup("","asdf","Mary", "Mary@gmail.com","09131234567", LocalDate.now(),"");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSignupUsernameException(){
        //Arrange
        String expected = "username already exists";


        //Act
        Exception actual = assertThrows(Exception.class, () -> {
            ListenerController.getListenerController().signup("Adele","asdf","Mary", "Mary@gmail.com","09131234567", LocalDate.now(),"null");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSignupPasswordException(){
        //Arrange
        String expected = "your password is weak\nuse 0-9 a-z A-Z @#$%& in your password";


        //Act
        InvalidFormatException actual = assertThrows(InvalidFormatException.class, () -> {
            ListenerController.getListenerController().signup("Mary","asdf","Mary", "Mary@gmail.com","09131234567", LocalDate.now(),"null");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSignupPhoneNumberException(){
        //Arrange
        String expected = "Invalid Phone Number";


        //Act
        InvalidFormatException actual = assertThrows(InvalidFormatException.class, () -> {
            ListenerController.getListenerController().signup("Mary","Asdfghj#24","Mary", "Mary@gmail.com","0911234567", LocalDate.now(),"null");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSignupEmailException(){
        //Arrange
        String expected = "Invalid Email";


        //Act
        InvalidFormatException actual = assertThrows(InvalidFormatException.class, () -> {
            ListenerController.getListenerController().signup("Mary","Asdfghj#24","Mary", "Marygmail.com","09131234567", LocalDate.now(),"null");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSignup() throws Exception {
        //Arrange
        String expected = "making new Account Completed Successfully";


        //Act
        String actual = ListenerController.getListenerController().signup("Mary","Asdfghj#24","Mary", "Mary@gmail.com","09131234567", LocalDate.now(),"null");


        //Assert
        assertEquals(expected,actual);
    }



    @Test
    public void testSLoginNullPointException(){
        //Arrange
        String expected = "fill all text field!";


        //Act
        NullPointerException actual = assertThrows(NullPointerException.class, () -> {
            ListenerController.getListenerController().login("","aaaaaa");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSLoginUserNotFoundException(){
        //Arrange
        String expected = new UserNotFoundException().getMessage();


        //Act
        UserNotFoundException actual = assertThrows(UserNotFoundException.class, () -> {
            ListenerController.getListenerController().login("Mary","aaaaaa");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSLoginWrongPasswordException(){
        //Arrange
        String expected = new WrongPasswordException().getMessage();


        //Act
        WrongPasswordException actual = assertThrows(WrongPasswordException.class, () -> {
            ListenerController.getListenerController().login("Adele","aaaaaa");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testSLogin() throws FailedLoginException {
        //Arrange
        UserAccountModel expected = Database.getDatabase().getUserAccounts().get(1);


        //Act
        UserAccountModel actual = ListenerController.getListenerController().login("Adele","Ad88");

        //Assert
        assertEquals(expected,actual);
    }
}
