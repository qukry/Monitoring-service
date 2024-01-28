package by.asckarugin.In.Utils;

import java.util.Scanner;

public class ScannerProvider {
    public String nextLine(){
        return new Scanner(System.in).nextLine();
    }

    public int nextInt(){
        return new Scanner(System.in).nextInt();
    }

    public double nextDouble(){
        return new Scanner(System.in).nextDouble();
    }
}
