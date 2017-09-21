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
public class Program {
    private int IdProgram;
    private String NameProgram;
    private int IdState;

    public Program(int IdProgram, String NameProgram, int IdState) {
        this.IdProgram = IdProgram;
        this.NameProgram = NameProgram;
        this.IdState = IdState;
    }

    public Program() {
    }

    public int getIdProgram() {
        return IdProgram;
    }

    public void setIdProgram(int IdProgram) {
        this.IdProgram = IdProgram;
    }

    public String getNameProgram() {
        return NameProgram;
    }

    public void setNameProgram(String NameProgram) {
        this.NameProgram = NameProgram;
    }

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }
    
}
