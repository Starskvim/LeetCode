import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{0, 4, 3, 0}, 0)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> mapNumber = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mapNumber.put(nums[i], i);
        }

        for (Map.Entry<Integer, Integer> item : mapNumber.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }

        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (mapNumber.containsKey(find) && mapNumber.get(find) != i) {
                result[0] = i;
                result[1] = mapNumber.get(find);
                break;
            }
        }

        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
