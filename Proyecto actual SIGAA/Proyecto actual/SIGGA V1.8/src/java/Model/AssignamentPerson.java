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
public class AssignamentPerson {
    private int IdProgram;
    private int IdPerson;

    public AssignamentPerson(int IdProgram, int IdPerson) {
        this.IdProgram = IdProgram;
        this.IdPerson = IdPerson;
    }

    public int getIdProgram() {
        return IdProgram;
    }

    public void setIdProgram(int IdProgram) {
        this.IdProgram = IdProgram;
    }

    public int getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(int IdPerson) {
        this.IdPerson = IdPerson;
    }
    
    public AssignamentPerson() {
    }


        
}
