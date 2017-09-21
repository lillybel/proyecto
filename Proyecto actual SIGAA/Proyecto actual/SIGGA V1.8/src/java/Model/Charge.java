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
public class Charge {
    private int IdCharge;
    private String NameCharge;
    private int IdState;

    public Charge(int IdCharge, String NameCharge, int IdState) {
        this.IdCharge = IdCharge;
        this.NameCharge = NameCharge;
        this.IdState = IdState;
    }

    public Charge() {
    }

    public int getIdCharge() {
        return IdCharge;
    }

    public void setIdCharge(int IdCharge) {
        this.IdCharge = IdCharge;
    }

    public String getNameCharge() {
        return NameCharge;
    }

    public void setNameCharge(String NameCharge) {
        this.NameCharge = NameCharge;
    }

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }
       
}
