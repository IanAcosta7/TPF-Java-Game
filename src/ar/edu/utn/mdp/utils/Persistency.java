package ar.edu.utn.mdp.utils;

import java.io.*;
import java.util.HashSet;

public class Persistency <T extends Serializable> {

    private File file;

    public Persistency(String path) {
        file = new File(path);
    }

    private void openFile () {
        // CREA EL ARCHIVO SI NO EXISTE
        try {
            if (file.createNewFile()) {
                System.out.println("Archivo Creado.");
            } else {
                System.out.println("El archivo ya existia.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<T> getData() {
        HashSet<T> data = new HashSet<>();

        // LEE EL ARCHIVO
        boolean read = true;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            while (read) {
                Object o = ois.readObject();
                data.add((T) o);
            }

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            read = false;
        }

        return data;
    }

    public void setData(HashSet<T> data) {
        // ESCRIBE EL ARCHIVO
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                for (T value : data) {
                    try {
                        oos.writeObject(value);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
