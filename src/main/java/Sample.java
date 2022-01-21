import java.util.HashMap;

public class Sample {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
//
//        for (int n : nums) {
//            //9 - 2 = 7
//             int second = target - n; //7
//        }
//        int firstIndex = -1;
//        int secondIndex = -1;
//        for (int i = 0; i < nums.length; i++) {
//            int second = target - nums[i];//7
//            firstIndex = i; //0
//            for (int j = i+1; j < nums.length; j++) { // j = 1 to 3
//                if (nums[j] == second) {secondIndex = j; break;}
//            }
//        }
//
//        System.out.println(firstIndex);
//        System.out.println(secondIndex);

        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int second; int secondIndex = -1;
        int firstIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            second = target - nums[i];
            firstIndex = i;
            h.put(nums[i],i);
            if (h.get(second) != null)  {
                secondIndex = h.get(second);
                break;
            }
        }
        System.out.println(firstIndex);
        System.out.println(secondIndex);


    }



}
