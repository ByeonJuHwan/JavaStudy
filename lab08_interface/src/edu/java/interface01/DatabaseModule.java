package edu.java.interface01;

public interface DatabaseModule {
    
    // public static final 필드
    int DB_VERSION = 1;
    
    
    // public abstract 메서드
    
    /**
     * 데이터베이스의 테이블에서 자료를 읽어오는(검색하는) 기능.
     * 
     * @return 검색된 자료의 개수(int).
     */
    int read();
    
    
    /**
     * 데이터베이스의 테이블에 정수와 문자열을 저장하는 기능.
     * 
     * @param intVal 저장할 정수 값.
     * @param strVal 저장할 문자열.
     * 
     * @return 저장된 자료의 개수(int).
     */
    int create(int intVal, String strVal);
}
