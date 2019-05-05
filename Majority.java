import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Majority {

    public static int majorityNumber(List<Integer> nums) {
        Map<Integer, Integer> majorityCount = new HashMap<>();

        for (int num : nums){
            int count = 1;
            if(majorityCount.containsKey(num)){
                count = majorityCount.get(num);
                majorityCount.put(num, count + 1);
                count++;
            }else {
                majorityCount.put(num, count);
            }

            if(count > nums.size()/2){
                return num;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String args[]){
        System.out.println(majorityNumber(Arrays.asList(1,4,2,1,3,3,1,2,1,1,2,1,1)));
    }

}
