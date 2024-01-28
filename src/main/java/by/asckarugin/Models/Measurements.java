package by.asckarugin.Models;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Measurements {
    private double hotWater;
    private double coldWater;
    private double heating;
    private User user;
    private Date measurementsDataTime;

    public Measurements(){}

    public Measurements(double hotWater, double coldWater, double heating) {
        this.hotWater = hotWater;
        this.coldWater = coldWater;
        this.heating = heating;
    }

    public double getHotWater() {
        return hotWater;
    }

    public void setHotWater(double hotWater) {
        this.hotWater = hotWater;
    }

    public double getColdWater() {
        return coldWater;
    }

    public void setColdWater(double coldWater) {
        this.coldWater = coldWater;
    }

    public double getHeating() {
        return heating;
    }

    public void setHeating(double heating) {
        this.heating = heating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getMeasurementsDataTime() {
        return measurementsDataTime;
    }

    public void setMeasurementsDataTime(Date measurementsDataTime) {
        this.measurementsDataTime = measurementsDataTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurements that = (Measurements) o;

        if (Double.compare(that.hotWater, hotWater) != 0) return false;
        if (Double.compare(that.coldWater, coldWater) != 0) return false;
        return Double.compare(that.heating, heating) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(hotWater);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coldWater);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(heating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "Горячая вода = " + hotWater +
                "\n Холодная вода = " + coldWater +
                "\n Отопление = " + heating +
                "\n Время подачи = " + measurementsDataTime +
                '}';
    }
}
