
package Model;


public class AssignamentTask {
    private int IdTask;
    private int IdPerson;

    public AssignamentTask(int IdTask, int IdPerson) {
        this.IdTask = IdTask;
        this.IdPerson = IdPerson;
    }

    public AssignamentTask() {
    }

    public int getIdTask() {
        return IdTask;
    }

    public void setIdTask(int IdTask) {
        this.IdTask = IdTask;
    }

    public int getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(int IdPerson) {
        this.IdPerson = IdPerson;
    }
    
}
