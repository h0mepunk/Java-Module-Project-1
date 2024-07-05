public class Car {
    private Integer speed;
    private String name;

    public Car(Integer speed, String name) {
        this.setSpeed(speed);
        this.setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
