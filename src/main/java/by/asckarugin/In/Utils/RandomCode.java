package by.asckarugin.In.Utils;

public class RandomCode {
    private static int MAX_NUMBER= 2147483646;

    private static int MIN_NUMBER= 100000000;

    public int createPersonalCode(){
        MAX_NUMBER=MAX_NUMBER-MIN_NUMBER;
        return (int) (Math.random() * ++MAX_NUMBER)+ MIN_NUMBER;
    }
}
