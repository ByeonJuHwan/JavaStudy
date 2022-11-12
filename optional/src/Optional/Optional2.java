package Optional;

import java.util.Optional;
import java.util.OptionalInt;

public class Optional2 {

    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(s->s.length());
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());
        
        int result1 = Optional.of("123")
                        .filter(x->x.length()>0)
                        .map(x->Integer.parseInt(x)).get();
        
        int result2 = Optional.of("")
                        .filter(x->x.length()>0)
                        .map(x->Integer.parseInt(x)).orElse(-1);
        
        System.out.println("result 1 = " +result1 );
        System.out.println("result 2 = " +result2 );
        
        Optional.of("456").map(x->Integer.parseInt(x))
                                        .ifPresent(x->System.out.printf("result3 = %d%n",x));
        
        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();
        
        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());
        
        System.out.println(optInt1.getAsInt());
        //System.out.println(optInt2.getAsInt());  // NoSuchElementException
    }
}
