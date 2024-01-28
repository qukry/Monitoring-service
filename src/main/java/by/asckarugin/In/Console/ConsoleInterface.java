package by.asckarugin.In.Console;

import by.asckarugin.In.DAO.MeasurementsDAO;
import by.asckarugin.In.DAO.PersonDAO;
import by.asckarugin.In.Enums.Role;
import by.asckarugin.In.Utils.ScannerProvider;
import by.asckarugin.Models.User;

import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

public class ConsoleInterface {
    private ScannerProvider scanner = new ScannerProvider();
    private PersonDAO personDAO = new PersonDAO();
    private MeasurementsDAO measurementsDAO = new MeasurementsDAO();
    private int personalCode;


    public void registration(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        personDAO.createUser(name);
        System.out.println("Ваш лицевой счет: "+personDAO.getLastPersonalCode()+" Используйте его при авторизации");
        authorization();
    }

    public void authorization(){
        System.out.println("Введите лицевой счет: ");
        personalCode = scanner.nextInt();

        if(!personDAO.checkAuth(personalCode)){
            System.out.println("Вы ввели неправильный лицевой счет");
        } else if(personDAO.findByPersonalCode(personalCode).getRole()== Role.USER){
            System.out.println("Вы успешно авторизировались");
            menuUser();
        } else{
            System.out.println("Вы успешно авторизировались");
            menuAdmin();
        }
    }

    public void logOut(){
        System.out.println("Вы успешно вышли");
        auth();
    }

    public void auth(){
        while(true){
            System.out.println("1. Авторизация");
            System.out.println("2. Регистрация");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    authorization();
                case 2:
                    registration();
            }
        }
    }

    public void menuUser(){
        int choice;

        while(true){
            System.out.println("Выберите действие: \n"+
                                "1. Подача показания счетчиков \n"+
                                "2. Получение актуальных показаний счетчиков \n"+
                                "3. Просмотр истории подач показаний \n" +
                                "4. Выйти с аккаунта\n" +
                                "5. Закрыть приложение");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    if(!measurementsDAO.checkMonths(Calendar.getInstance())) {
                        System.out.println("Показание счетчика горячей воды: \n" +
                                "Пример показания: '345,85'");
                        double hotWater = scanner.nextDouble();
                        System.out.println("Показание счетчика холодной воды: \n" +
                                "Пример показания: '345,85'");
                        double coldWater = scanner.nextDouble();
                        System.out.println("Показание счетчика отопления: \n" +
                                "Пример показания: '345,85'");
                        double heating = scanner.nextDouble();
                        if(measurementsDAO.checkPreReading(hotWater, coldWater, heating)){
                            measurementsDAO.giveMeasurements(hotWater, coldWater, heating, personalCode);
                            System.out.println("Показания успешно внесены");
                        } else{
                            System.out.println("Введите корректные показания \n"+
                                               "Показания которые вы вносите, должны быть больше, последних показании");
                        }
                    } else{
                        System.out.println("Вы уже вносили показания в этом месяце");
                    }
                    continue;
                case 2:
                    System.out.println(measurementsDAO.showLastMeasurements());
                    continue;
                case 3:
                    measurementsDAO.showAllMeasurements();
                    continue;
                case 4:
                    logOut();
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Выберите нужное действие");
            }
        }
    }

    public void menuAdmin(){
        int choice;

        while(true){
            System.out.println("Выберите действие: \n"+
                                "1. Посмотреть всех пользователей \n"+
                                "2. Просмотр показания всех пользователей \n"+
                                "3. Просмотр аудита пользователя \n"+
                                "4. Выйти с аккаунта");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(personDAO.showAllUsers());
                    continue;
                case 2:
                    personDAO.showUsersWithMeasurements();
                    continue;
                case 3:

                case 4:
                    logOut();
            }
        }
    }
}
