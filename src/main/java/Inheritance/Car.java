package Inheritance;

public class Car extends Vehicle{
    private Integer gear;
    private Double speed;

    Car() {

    }

    Car(String steering, Integer gear, Double speed){
        super(steering);
        if (gear <= 6)
            this.gear = gear;
        else {
            System.out.println("Gear limit exceeded");
            this.gear = 1;
        }
        if (speed < 400)
            this.speed = speed;
        else {
            System.out.println("Speed too high");
            this.speed = 0.0;
        }
    }

    public void increaseSpeed(Double speed) {
        if (this.speed + speed > 500)
            System.out.println("Speed exceeding vehicle max speed");
        else {
            this.speed += speed;
            System.out.println("Car speed increased to " + this.speed);
        }

    }

    public void decreaseSpeed(Double speed) {
        if (this.speed - speed < 0)
            System.out.println("Negative speed");
        else {
            this.speed -= speed;
            System.out.println("Car speed decreased to " + this.speed);
        }

    }

    public Double getSpeed() {
        return speed;
    }

    public Integer getGear() {
        return gear;
    }

    public void setGear(Integer gear) {
        if (gear > 6)
            System.out.println("Gear limit exceeded");
        else{
            this.gear = gear;
            System.out.println("Car gear set to " + this.gear);
        }

    }

    @Override
    public String getSteering() {
        return super.getSteering();
    }

    @Override
    public void setSteering(String steering) {
        super.setSteering(steering);
    }
}
