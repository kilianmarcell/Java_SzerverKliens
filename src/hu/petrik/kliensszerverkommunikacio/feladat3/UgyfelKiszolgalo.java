package hu.petrik.kliensszerverkommunikacio.feladat3;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class UgyfelKiszolgalo implements Runnable {
    private Socket kapcsolat;
    private ArrayList<Indian> lista;

    public UgyfelKiszolgalo(Socket kapcsolat) {
        this.kapcsolat = kapcsolat;
    }

    @Override
    public void run() {
        try {
            DataInputStream ugyfeltol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream ugyfelnek = new DataOutputStream(kapcsolat.getOutputStream());

            int menu;
            beolvas();

            do {
                menu = ugyfeltol.readInt();

                switch (menu){
                    case 0: ugyfelnek.writeUTF("Kilépett!");
                        break;
                    case 1:
                        String s = "";
                        for (Indian i : lista) {
                            s += i + "\n";
                        }

                        ugyfelnek.writeUTF(s);
                        break;
                    case 2: ugyfelnek.writeUTF("Az indiánok száma: " + lista.size());
                        break;
                }

                ugyfelnek.flush();
            } while (menu != 0);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void beolvas() {
        lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("indianok.txt"));

            String sor = br.readLine();
            while (sor != null) {
                lista.add(new Indian(sor));
                sor = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
