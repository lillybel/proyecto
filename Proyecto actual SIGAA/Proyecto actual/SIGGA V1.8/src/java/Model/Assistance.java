
package Model;

import java.sql.Date;

public class Assistance {
    private int IdAssitenace;
    private String Kind;
    private Date Datea;
    private int IdApprentice;

    public Assistance(int IdAssitenace, String Kind, Date Datea, int IdApprentice) {
        this.IdAssitenace = IdAssitenace;
        this.Kind = Kind;
        this.Datea = Datea;
        this.IdApprentice = IdApprentice;
    }

    public Assistance() {
    }

    public int getIdAssitenace() {
        return IdAssitenace;
    }

    public void setIdAssitenace(int IdAssitenace) {
        this.IdAssitenace = IdAssitenace;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String Kind) {
        this.Kind = Kind;
    }

    public Date getDatea() {
        return Datea;
    }

    public void setDatea(Date Datea) {
        this.Datea = Datea;
    }

    public int getIdApprentice() {
        return IdApprentice;
    }

    public void setIdApprentice(int IdApprentice) {
        this.IdApprentice = IdApprentice;
    }
    
}
