package edu.java.interface01;

public class MariaDbModule implements DatabaseModule {

    @Override
    public int read() {
        System.out.println("Maria DB read()");
        return 0;
    }

    @Override
    public int create(int intVal, String strVal) {
        System.out.println("Maria DB create(" + intVal + "," + strVal +")");
        return 0;
    }

}
