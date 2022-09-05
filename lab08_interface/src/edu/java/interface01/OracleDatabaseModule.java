package edu.java.interface01;


// DatabaseModule 인터페이스를 구현하는 클래스
public class OracleDatabaseModule implements DatabaseModule{

    @Override
    public int read() {
        System.out.println("Orable 데이터 검색");
        return 1;
    }

    @Override
    public int create(int intVal, String strVal) {
       System.out.println("Oracle 데이터 저장");
        return 1;
    }

}
