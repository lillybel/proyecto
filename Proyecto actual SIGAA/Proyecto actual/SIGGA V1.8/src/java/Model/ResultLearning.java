/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Estudiante
 */
public class ResultLearning {
    private int IdResultLearning;
    private String NameResultLearning;
    private Date StartDate;
    private Date EndDate;
    private int IdState;
    private int IdProgram;    
        public ResultLearning() {
    }


    public ResultLearning(int IdResultLearning, String NameResultLearning, Date StartDate, Date EndDate, int IdState, int IdProgram) {
        this.IdResultLearning = IdResultLearning;
        this.NameResultLearning = NameResultLearning;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.IdState = IdState;
        this.IdProgram = IdProgram;
    }


    public int getIdResultLearning() {
        return IdResultLearning;
    }

    public void setIdResultLearning(int IdResultLearning) {
        this.IdResultLearning = IdResultLearning;
    }

    public String getNameResultLearning() {
        return NameResultLearning;
    }

    public void setNameResultLearning(String NameResultLearning) {
        this.NameResultLearning = NameResultLearning;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
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
