package controller;

import model.Database;
import model.exceptions.InvalidFormatException;
import model.exceptions.failedLogin.FailedLoginException;
import model.exceptions.failedLogin.type.UserNotFoundException;
import model.exceptions.failedLogin.type.WrongPasswordException;
import model.user.UserAccountModel;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class UserAccountController {

    //ثبت نام کاربر
    public String signup(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio) throws Exception {
        if(userName.isEmpty() || name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || birthDate==null || bio.isEmpty())
            throw new NullPointerException("fill all text field!");

        for(UserAccountModel user : Database.getDatabase().getUserAccounts()){
            if(user.getUserName().equals(userName))
                throw new Exception("username already exists");
        }

        if(!checkRegex("^[0][9]\\d{9}$",phoneNumber))
            throw new InvalidFormatException("Invalid Phone Number");

        if(!checkRegex("^[\\w\\-\\.]+@([\\w-]+\\.)[\\w-]{2,}$" , email))
            throw new InvalidFormatException("Invalid Email");

        return "making new Account Completed Successfully\nThe security of your password is: " + checkPassword(password)+"/5";
    }
    private int checkPassword(String password){
        int score = 0;
        if(password.length() >= 8)
            score ++;

        if(checkRegex("^(?=.*[0-9])",password))
            score ++;

        if(checkRegex("^(?=.*[a-z])",password))
            score ++;

        if(checkRegex("^(?=.*[A-Z])",password))
            score ++;

        if(checkRegex("^(?=.*[@#$%^&+=])",password))
            score ++;
        return score;
    }
    private boolean checkRegex(String regex, String str){
        Pattern emailPattern = Pattern.compile(regex);
        Matcher matcher = emailPattern.matcher(str);
        return matcher.find();
    }
    //ورود به حساب کاربری
    public UserAccountModel login(String username, String password) throws FailedLoginException {
        if(username.isEmpty() || password.isEmpty())
            throw new NullPointerException("fill text Box!");
        UserAccountModel userAccount = null;
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(username.equals(user.getUserName())) {
                userAccount = user;
                break;
            }
        if(userAccount == null)
            throw new UserNotFoundException();
        if(!userAccount.getPassword().equals(password))
            throw new WrongPasswordException();

        return Database.getDatabase().getUserAccounts().get(findUser(username));
    }

    private int findUser(String username){
        for(UserAccountModel userAccount : Database.getDatabase().getUserAccounts())
            if(userAccount.getUserName().equals(username))
                return Database.getDatabase().getUserAccounts().indexOf(userAccount);

        return 0;
    }
}
