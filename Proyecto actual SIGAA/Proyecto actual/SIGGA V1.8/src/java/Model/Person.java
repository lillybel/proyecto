/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Estudiante
 */
public class Person {
    private int IdPerson;
    private String NamePerson;
    private String UserPerson;
    private  String PasswordPerson;
    private String Email;
    private int IdState;
  

    public Person() {
    }

    public Person(int IdPerson, String NamePerson, String PasswordPerson, String Email, int IdState, String UserPerson) {
        this.IdPerson = IdPerson;
        this.NamePerson = NamePerson;
        this.PasswordPerson = PasswordPerson;
        this.Email = Email;
        this.IdState = IdState;
        this.UserPerson = UserPerson;
    }

    public int getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(int IdPerson) {
        this.IdPerson = IdPerson;
    }

    public String getNamePerson() {
        return NamePerson;
    }

    public void setNamePerson(String NamePerson) {
        this.NamePerson = NamePerson;
    }

    public String getPasswordPerson() {
        return PasswordPerson;
    }

    public void setPasswordPerson(String PasswordPerson) {
        this.PasswordPerson = PasswordPerson;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }

    public String getUserPerson() {
        return UserPerson;
    }

    public void setUserPerson(String UserPerson) {
        this.UserPerson = UserPerson;
    }

    

    
}