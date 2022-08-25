package model;

/**
 * Created on 2021/12/25 - 23:07.
 *
 * @author CaseyLee
 */
public class Update {

    boolean successOrNot;

    public Update(){
        successOrNot = false;
    }

    public boolean isSuccessOrNot() {
        return successOrNot;
    }

    public void setSuccessOrNot(boolean successOrNot) {
        this.successOrNot = successOrNot;
    }
}
