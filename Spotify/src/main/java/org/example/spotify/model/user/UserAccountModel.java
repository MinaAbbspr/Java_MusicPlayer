package model.user;

import java.time.LocalDate;
public abstract class UserAccountModel {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;

    public UserAccountModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    //Getter
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    //Setter
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return "user name: " + userName + "\tpassword: " + password + "\tname: " + name + "\temail: " + email +
                "\n\tphone number: " + phoneNumber + "\tbirth date: " + birthDate;
    }
}

