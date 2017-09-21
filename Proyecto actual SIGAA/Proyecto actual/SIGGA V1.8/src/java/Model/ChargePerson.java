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
public class ChargePerson {
    private int IdPerson;
    private int IdCharge;

    public ChargePerson(int IdPerson, int IdCharge) {
        this.IdPerson = IdPerson;
        this.IdCharge = IdCharge;
    }

    public ChargePerson() {
    }

    public int getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(int IdPerson) {
        this.IdPerson = IdPerson;
    }

    public int getIdCharge() {
        return IdCharge;
    }

    public void setIdCharge(int IdCharge) {
        this.IdCharge = IdCharge;
    }
    
}
