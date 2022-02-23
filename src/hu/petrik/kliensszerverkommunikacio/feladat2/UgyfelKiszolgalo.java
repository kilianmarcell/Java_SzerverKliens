package hu.petrik.kliensszerverkommunikacio.feladat2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class UgyfelKiszolgalo implements Runnable {
    private Socket kapcsolat;

    public UgyfelKiszolgalo(Socket kapcsolat) {
        this.kapcsolat = kapcsolat;
    }

    @Override
    public void run() {
        try {
            DataInputStream ugyfeltol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream ugyfelnek = new DataOutputStream(kapcsolat.getOutputStream());

            while (true) {
                int aOldal = ugyfeltol.readInt();
                int bOldal = ugyfeltol.readInt();
                int menu;

                do {
                    menu = ugyfeltol.readInt();
                    switch (menu) {
                        case 1: ugyfelnek.writeUTF("A téglalap kerülete: " + (2 * (aOldal + bOldal)) + "\n\n");
                            break;
                        case 2: ugyfelnek.writeUTF("A téglalap területe: " + (aOldal * bOldal) + "\n\n");
                            break;
                        case 3: ugyfelnek.writeUTF(aOldal == bOldal ? "Ez a téglalap egy négyzet!\n\n" : "Ez a téglalap nem egy négyzet!\n\n");
                            break;
                        case 4: ugyfelnek.writeUTF("A téglalap átló mérete: " + ( Math.sqrt(Math.pow(aOldal, 2) + Math.pow(bOldal, 2))) + "\n\n");
                            break;
                        case 5: ugyfelnek.writeUTF("Kilépett!");
                            break;
                    }
                } while (menu != 5);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
