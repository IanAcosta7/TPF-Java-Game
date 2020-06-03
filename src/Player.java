import ar.edu.utn.mdp.Component;

public class Player {

    private int speed;
    private int fuel;


    public Player(int speed, int fuel) {
        this.speed = speed;
        this.fuel = fuel;
    }

    //***********************************************************************
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    //***********************************************************************
}
