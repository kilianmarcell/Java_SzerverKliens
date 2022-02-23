package hu.petrik.kliensszerverkommunikacio.feladat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Kliens {
    public static void main(String[] args) {
        try {
            Socket kapcsolat = new Socket("localhost", 8080);

            DataInputStream szervertol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream szerverre = new DataOutputStream(kapcsolat.getOutputStream());

            Scanner s = new Scanner(System.in);

            while (true) {
                System.out.println("Kérem a kör sugarát: ");

                int sugar = s.nextInt();

                szerverre.writeInt(sugar);
                szerverre.flush();

                System.out.printf("Szervertől a kerület: %.2f\n", szervertol.readDouble());
                System.out.printf("Szervertől a terület: %.2f\n\n", szervertol.readDouble());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
