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
public class Apprentice {
    private int IdApprentice;
    private String NameApprentice;
    private int IdState;
    private int IdGroup;

    public Apprentice(int IdApprentice, String NameApprentice, int IdState, int IdGroup) {
        this.IdApprentice = IdApprentice;
        this.NameApprentice = NameApprentice;
        this.IdState = IdState;
        this.IdGroup = IdGroup;
    }

    public Apprentice() {
    }

    public int getIdApprentice() {
        return IdApprentice;
    }

    public void setIdApprentice(int IdApprentice) {
        this.IdApprentice = IdApprentice;
    }

    public String getNameApprentice() {
        return NameApprentice;
    }

    public void setNameApprentice(String NameApprentice) {
        this.NameApprentice = NameApprentice;
    }

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }

    public int getIdGroup() {
        return IdGroup;
    }

    public void setIdGroup(int IdGroup) {
        this.IdGroup = IdGroup;
    }
           
}
