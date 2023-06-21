package DefiningClasses.RawData;//package DefiningClasses.RawData;

public class EngineE {
    private int speed;
    private int power;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public EngineE(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }
}
