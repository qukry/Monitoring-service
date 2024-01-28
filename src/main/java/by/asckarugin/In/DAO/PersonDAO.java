package by.asckarugin.In.DAO;

import by.asckarugin.In.Enums.Role;
import by.asckarugin.In.Utils.RandomCode;
import by.asckarugin.Models.Measurements;
import by.asckarugin.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDAO {
    private RandomCode randomCode = new RandomCode();
    List<User> users = new ArrayList<>();
    {
        users.add(new User(1,"Evgenyi",453456723, Role.ADMIN));
    }
    private static Integer PEOPLE_COUNTER=0;


    public List<User> showAllUsers(){
        return users;
    }

    public User findByPersonalCode(int personalCode){

        User current = null;

        for(User user: users){
            if(user.getPersonalCode()==personalCode){
                current = user;
            }
        }

        return current;
    }

    public void createUser(String name){
        User user = new User();
        user.setId(++PEOPLE_COUNTER);
        user.setName(name);
        user.setPersonalCode(randomCode.createPersonalCode());
        user.setRole(Role.USER);
        users.add(user);
    }

    public int getLastPersonalCode(){
        User user = users.get(users.size()-1);
        return user.getPersonalCode();
    }

    public boolean checkAuth(int personalCode){
        return findByPersonalCode(personalCode).getPersonalCode() == personalCode;
    }

    public void setUserMeasurements(List<Measurements> measurements){
        users.get(users.size()-1).setMeasurement(measurements);
    }

    public void showUsersWithMeasurements(){
        for(int i=0; i<= users.size()-1; i++){
            System.out.println(users.get(i).getMeasurement());
            System.out.println(users.get(i).getMeasurement());
        }
    }
}
