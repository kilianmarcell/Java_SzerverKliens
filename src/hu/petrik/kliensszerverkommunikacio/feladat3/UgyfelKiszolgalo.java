package hu.petrik.kliensszerverkommunikacio.feladat3;

import java.net.Socket;

public class UgyfelKiszolgalo implements Runnable {
    private Socket kapcsolat;

    public UgyfelKiszolgalo(Socket kapcsolat) {
        this.kapcsolat = kapcsolat;
    }

    @Override
    public void run() {
    }
}
