package by.asckarugin.In.DAO;

import by.asckarugin.Models.Measurements;
import by.asckarugin.Models.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MeasurementsDAO {
    private PersonDAO personDAO = new PersonDAO();
    private List<Measurements> measurements;
    {
        measurements = new ArrayList<>();
    }


    public Measurements showLastMeasurements(){
        return measurements.get(measurements.size()-1);
    }


    public void showAllMeasurements(){
        for(int i=0; i<=measurements.size()-1; i++){
            System.out.println("Показания за "+(i+1)+"-й месяц");
            System.out.println(measurements.get(i));
        }
    }


    public void giveMeasurements(double hotWater, double coldWater, double heating, int personalCode){
        Measurements measurement = new Measurements();
        enrich(measurement, personalCode);
        measurement.setHotWater(hotWater);
        measurement.setColdWater(coldWater);
        measurement.setHeating(heating);
        measurements.add(measurement);
        personDAO.setUserMeasurements(measurements);
    }


    public boolean checkMonths(Calendar calendar){
        if(measurements.size()==0)
            return false;

        return measurements.get(measurements.size() - 1).getMeasurementsDataTime().getMonth() == calendar.getTime().getMonth();
    }


    public boolean checkPreReading(double hotWater, double coldWater, double heating){
        if(measurements.size()==0)
            return true;

        return showLastMeasurements().getHotWater() < hotWater &&
                showLastMeasurements().getColdWater() < coldWater &&
                showLastMeasurements().getHeating() < heating;
    }


    private void enrich(Measurements measurement, int personalCode) {
        measurement.setUser(personDAO.findByPersonalCode(personalCode));
        measurement.setMeasurementsDataTime(Calendar.getInstance().getTime());
    }
}
