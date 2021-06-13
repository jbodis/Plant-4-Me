public class Plant {
    String name;
    String water;
    String light;

    public Plant(String name, String waterLevel, String lightLevel) {
        this.name = name;
        water = waterLevel;
        light = lightLevel;

    }

    public String getWaterLevel() {

        return water;
    }

    public String getLightLevel() {

        return light;
    }

    public String toString() {

        return name;
    }

}
