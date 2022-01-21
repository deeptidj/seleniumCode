import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

       // int result =  1122 // removing 439

//        String num = "10200";
//        int k = 1;
        //int res = 0001; //removing 2

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            arr.add((Integer.parseInt(num,i,i+1,10)));
        }
        Collections.sort(arr);

        arr.forEach(n -> { System.out.println(n);});

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.size()-k; i++) {
            sb.append(Integer.toString(arr.get(i)));
        }
        System.out.println(sb.toString());



    }
}
