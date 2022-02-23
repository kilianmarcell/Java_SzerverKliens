package hu.petrik.kliensszerverkommunikacio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Kliens {
    public static void main(String[] args) {
        try {
            Socket kapcsolat = new Socket("localhost", 8080);
            DataInputStream szervertol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream szerverre = new DataOutputStream(kapcsolat.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
