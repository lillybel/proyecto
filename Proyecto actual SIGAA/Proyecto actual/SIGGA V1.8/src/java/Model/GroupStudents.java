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
public class GroupStudents {
 private int IdGroup;
 private int IdState;
 private int IdProgram;

    public GroupStudents(int IdGroup, int IdState, int IdProgram) {
        this.IdGroup = IdGroup;
        this.IdState = IdState;
        this.IdProgram = IdProgram;
    }

    public GroupStudents() {
    }

    public int getIdGroup() {
        return IdGroup;
    }

    public void setIdGroup(int IdGroup) {
        this.IdGroup = IdGroup;
    }

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }

    public int getIdProgram() {
        return IdProgram;
    }

    public void setIdProgram(int IdProgram) {
        this.IdProgram = IdProgram;
    }
    
}
