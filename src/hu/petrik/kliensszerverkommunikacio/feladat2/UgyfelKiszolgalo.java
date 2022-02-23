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

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
