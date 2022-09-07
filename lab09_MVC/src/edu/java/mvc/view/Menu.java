package edu.java.mvc.view;

public enum Menu {
QUIT,  CREATE,  SELECT_ALL,  SELECT_BY_INDEX, UPDATE, UNKNOWN;

// int -> Menu 변환 메서드
public static Menu getValue(int n) {
        Menu[] array = values();   // values() 는 모든 enum 타입이 가지고 있는 스테틱 메서드
        int lastIndex = array.length-1; // length 는 6이므로 1을빼줘서 unknown을 나오게 해버림.
        if(n>=0 && n<lastIndex) { // 사용할수 있는 메뉴번호
            return array[n];
        }else {  // 잘못된 메뉴 번호
            return array[lastIndex];
        }
}

}