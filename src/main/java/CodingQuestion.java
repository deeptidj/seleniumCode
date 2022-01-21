import java.util.HashMap;
import java.util.Map;

public class CodingQuestion {
        private Map<String,Integer> map;

        public CodingQuestion() {
            map = new HashMap<>();
            map.put("foo", 1);
            map.put("bar", 3);
        }

        public int getValue(String input, int numRetries) throws Exception {
            try {
                return map.get(input);
            }
            catch (Exception e) {
                if (numRetries > 3) {
                    throw e;
                }
                return getValue(input, numRetries + 1);
            }
        }

    public static void main(String[] args) throws Exception {
            CodingQuestion c = new CodingQuestion();
        System.out.println("one "+c.getValue("foo", 0));
        System.out.println("two "+ c.getValue("bar", 2));
        //System.out.println("three" +c.getValue("baz", 0));
        System.out.println("Four "+c.getValue("fubar", 1));
    }
}
