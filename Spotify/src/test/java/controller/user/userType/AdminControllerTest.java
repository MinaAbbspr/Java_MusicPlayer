package controller.user.userType;

import exceptions.failedLogin.FailedLoginException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdminControllerTest {

    @Test
    public void testReportInfoNullPointerException() throws FailedLoginException {
        //Arrange
        String expected = "There is no report";


        //Act
        NullPointerException actual = assertThrows(NullPointerException.class, () -> {
            AdminController.getAdminController().reportInfo();
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }
}
