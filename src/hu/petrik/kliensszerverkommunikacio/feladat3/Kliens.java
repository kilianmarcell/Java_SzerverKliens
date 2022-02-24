package hu.petrik.kliensszerverkommunikacio.feladat3;

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
            DataOutputStream szervernek = new DataOutputStream(kapcsolat.getOutputStream());

            Scanner s = new Scanner(System.in);
            int menu;

            do {
                System.out.println("Válasszon az alábbi menüpontok közül!:\n" +
                        "\t0. Kilépés\n" +
                        "\t1. Listázás\n" +
                        "\t2. Indiánok száma\n");

                menu = s.nextInt();

                szervernek.writeInt(menu);
                szervernek.flush();

                System.out.println(szervertol.readUTF());
            } while (menu != 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
