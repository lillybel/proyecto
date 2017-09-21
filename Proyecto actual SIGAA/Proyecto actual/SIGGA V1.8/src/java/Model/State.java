/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class State {
    private int IdState;
    private String NameState;

    public State() {
    }

    public State(int IdState, String NameState) {
        this.IdState = IdState;
        this.NameState = NameState;
    }

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }

    public String getNameState() {
        return NameState;
    }

    public void setNameState(String NameState) {
        this.NameState = NameState;
    }
    
    
    
}
