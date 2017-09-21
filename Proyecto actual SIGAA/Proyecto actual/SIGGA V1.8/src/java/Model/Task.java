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
public class Task {
    private int IdTask;
    private String NameTask;
    private int IdState;

    public Task(int IdTask, String NameTask, int IdState) {
        this.IdTask = IdTask;
        this.NameTask = NameTask;
        this.IdState = IdState;
    }

    public Task() {
    }

    public int getIdTask() {
        return IdTask;
    }

    public void setIdTask(int IdTask) {
        this.IdTask = IdTask;
    }

    public String getNameTask() {
        return NameTask;
    }

    public void setNameTask(String NameTask) {
        this.NameTask = NameTask;
    }

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }
    
    
}
