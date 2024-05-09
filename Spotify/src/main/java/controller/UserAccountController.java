package controller;

import model.Database;
import model.audio.Genre;
import model.exceptions.InvalidFormatException;
import model.exceptions.failedLogin.FailedLoginException;
import model.exceptions.failedLogin.type.UserNotFoundException;
import model.exceptions.failedLogin.type.WrongPasswordException;
import model.user.UserAccountModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class UserAccountController {

    //ثبت نام کاربر
    public String signup(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate) throws InvalidFormatException {
        for(UserAccountModel user : Database.getDatabase().getUserAccounts()){
            if(user.getUserName().equals(userName))
                return "username already exists";
        }

        if(!checkRegex("^[0][9]\\d{9}$",phoneNumber))
            throw new InvalidFormatException("Invalid Phone Number");

        if(!checkRegex("^[\\w\\-\\.]+@([\\w-]+\\.)[\\w-]{2,}$" , email))
            throw new InvalidFormatException("Invalid Email");

        return "making new Account Completed Successfully. The security of your password is: " + checkPassword(password)+"/5";
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
    public String login(String username, String password) throws FailedLoginException {
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

        return userAccount.getClass().toString();
    }
    //genre
    public boolean isGenre(String genreName){
        ArrayList<String> genres = new ArrayList<>();
        genres.add(Genre.TrueCrime.toString());
        genres.add(Genre.Rock.toString());
        genres.add(Genre.Pop.toString());
        genres.add(Genre.Jazz.toString());
        genres.add(Genre.HipHop.toString());
        genres.add(Genre.Country.toString());
        genres.add(Genre.Society.toString());
        genres.add(Genre.InterView.toString());
        genres.add(Genre.History.toString());

        return genres.contains(genreName);
    }

    public StringBuilder getGenre(){
        ArrayList<String> genres = new ArrayList<>();
        genres.add(Genre.TrueCrime.toString());
        genres.add(Genre.Rock.toString());
        genres.add(Genre.Pop.toString());
        genres.add(Genre.Jazz.toString());
        genres.add(Genre.HipHop.toString());
        genres.add(Genre.Country.toString());
        genres.add(Genre.Society.toString());
        genres.add(Genre.InterView.toString());
        genres.add(Genre.History.toString());

        StringBuilder stringBuilder = new StringBuilder("Genres: ");
        for(String genre : genres)
            stringBuilder.append(genre + "  ");

        return stringBuilder;
    }
}
