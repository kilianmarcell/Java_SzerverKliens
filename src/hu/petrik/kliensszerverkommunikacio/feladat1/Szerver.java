package hu.petrik.kliensszerverkommunikacio.feladat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Szerver {
    public static void main(String[] args) {
        System.out.println("Szerver indulása");

        try {
            ServerSocket socket = new ServerSocket(8080);
            Socket kapcsolat = socket.accept();

            DataInputStream ugyfeltol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream ugyfelnek = new DataOutputStream(kapcsolat.getOutputStream());
            InetAddress ugyfel = kapcsolat.getInetAddress();

            System.out.println("Az ügyfél neve: " + ugyfel.getHostName());
            System.out.println("Az ügyfél címe: " + ugyfel.getHostAddress());

            while (true) {
                int sugar = ugyfeltol.readInt();
                double kerulet = 2 * sugar * Math.PI;
                double terulet = Math.pow(sugar, 2) * Math.PI;

                ugyfelnek.writeDouble(kerulet);
                ugyfelnek.writeDouble(terulet);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
