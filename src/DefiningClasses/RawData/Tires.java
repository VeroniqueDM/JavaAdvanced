package DefiningClasses.RawData;

public class Tires {
    private double firstTirePressure;
    private int firstTireAge;
    private double secondTirePressure;
    private int secondTireAge;
    private double thirdTirePressure;
    private int thirdTireAge;

    public double getFirstTirePressure() {
        return firstTirePressure;
    }

    public void setFirstTirePressure(double firstTirePressure) {
        this.firstTirePressure = firstTirePressure;
    }

    public int getFirstTireAge() {
        return firstTireAge;
    }

    public void setFirstTireAge(int firstTireAge) {
        this.firstTireAge = firstTireAge;
    }

    public double getSecondTirePressure() {
        return secondTirePressure;
    }

    public void setSecondTirePressure(double secondTirePressure) {
        this.secondTirePressure = secondTirePressure;
    }

    public int getSecondTireAge() {
        return secondTireAge;
    }

    public void setSecondTireAge(int secondTireAge) {
        this.secondTireAge = secondTireAge;
    }

    public double getThirdTirePressure() {
        return thirdTirePressure;
    }

    public void setThirdTirePressure(double thirdTirePressure) {
        this.thirdTirePressure = thirdTirePressure;
    }

    public int getThirdTireAge() {
        return thirdTireAge;
    }

    public void setThirdTireAge(int thirdTireAge) {
        this.thirdTireAge = thirdTireAge;
    }

    public double getFourthTirePressure() {
        return fourthTirePressure;
    }

    public void setFourthTirePressure(double fourthTirePressure) {
        this.fourthTirePressure = fourthTirePressure;
    }

    public int getFourthTireAge() {
        return fourthTireAge;
    }

    public void setFourthTireAge(int fourthTireAge) {
        this.fourthTireAge = fourthTireAge;
    }

    private double fourthTirePressure;
    private int fourthTireAge;

    public Tires(double firstTirePressure, int firstTireAge, double secondTirePressure, int secondTireAge, double thirdTirePressure, int thirdTireAge, double fourthTirePressure, int fourthTireAge) {
        this.firstTirePressure = firstTirePressure;
        this.firstTireAge = firstTireAge;
        this.secondTirePressure = secondTirePressure;
        this.secondTireAge = secondTireAge;
        this.thirdTirePressure = thirdTirePressure;
        this.thirdTireAge = thirdTireAge;
        this.fourthTirePressure = fourthTirePressure;
        this.fourthTireAge = fourthTireAge;
    }

    public boolean ifTirePressureIsUnder() {
        return this.firstTirePressure<1 || this.secondTirePressure<1 || this.thirdTirePressure<1 || this.fourthTirePressure <1;
    }
}
