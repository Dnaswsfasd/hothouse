package cn.moriaty.hothouse.bean;

public class HothouseData {
    private String ID;
    private String hothouse;
    private String time;
    private String temperature;
    private String CO2;
    private String humidity;
    private String soil;
    private String light;

    @Override
    public String toString() {
        return "HothouseData{" +
                "ID='" + ID + '\'' +
                ", hothouse='" + hothouse + '\'' +
                ", time='" + time + '\'' +
                ", temperature='" + temperature + '\'' +
                ", CO2='" + CO2 + '\'' +
                ", humidity='" + humidity + '\'' +
                ", soil='" + soil + '\'' +
                ", light='" + light + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHothouse() {
        return hothouse;
    }

    public void setHothouse(String hothouse) {
        this.hothouse = hothouse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCO2() {
        return CO2;
    }

    public void setCO2(String CO2) {
        this.CO2 = CO2;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }
}
