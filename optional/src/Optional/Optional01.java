package Optional;

import java.util.Optional;
    
public class Optional01 {

    public static void main(String[] args) {
        //int [] arr = null; NullPointerException 발생
        int [] arr = new int [0];
        System.out.println("arr.length = " + arr.length);
        
        //Optional<String> opt = null;  Error는 안나지만 바람직하지 않음!!
        Optional<String> opt = Optional.empty();
        System.out.println("opt = " + opt);
        
        String str = "";
        
//        try { 
//            str = opt.get();
//        } catch (Exception e) {
//            str = ""; // 예외가 발생하면 빈문자열("")로 초기화
//        } // 예외 발생
//        이 방식으로 하면 너무 번거로워서 이렇게 안함.
        
        str = opt.orElse("EMPTY"); // Optional에 저장된 값이 null 이면 "EMPTY" 반환.
        System.out.println("str = " + str); // 저장된 값이 null이기 때문에 EMPTY 출력
        
        Optional<String> opt2 = Optional.of("abc");  // opt2에 abc  값 입력
        str= opt2.orElse("EMPTY");
        System.out.println("str = " + str); // null이 아니므로 abc 출력
    }

}
