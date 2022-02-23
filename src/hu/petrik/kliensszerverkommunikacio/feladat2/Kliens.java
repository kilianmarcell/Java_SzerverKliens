package hu.petrik.kliensszerverkommunikacio.feladat2;

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

            while (true) {
                System.out.print("Kérem az a oldalt!: ");
                int aOldal = s.nextInt();

                System.out.print("Kérem az b oldalt!: ");
                int bOldal = s.nextInt();

                szervernek.writeInt(aOldal);
                szervernek.writeInt(bOldal);

                szervernek.flush();

                int menu;

                do {
                    System.out.println("Melyik menüpontot választja az alábbi lehetőségek közül?:\n" +
                            "1: Kerület\n" +
                            "2: Terület\n" +
                            "3: Négyzet-e\n" +
                            "4: Átló mérete\n" +
                            "5: Kilépés\n");

                    menu = s.nextInt();

                    szervernek.writeInt(menu);
                    szervernek.flush();

                    System.out.println(szervertol.readUTF());
                } while (menu != 5);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
