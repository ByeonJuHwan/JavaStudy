package Optional;

import java.util.Optional;

public class Optional2 {

    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(s->s.length());
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());
        

    }

}
