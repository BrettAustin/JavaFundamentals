import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> numberMap = new HashMap<String, Integer>();
        numberMap.put("A", 1);
        numberMap.put("B", 2);
        numberMap.put("C", 3);
        System.out.println(numberMap.keySet());
    }
}
