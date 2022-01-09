import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ThreSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));

    }


    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        TreeMap<Integer, Integer> resultMap = new TreeMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[right] + nums[left];

                if(target >= 0) {
                    resultMap.put(Math.abs(Math.abs(target) - sum), sum);
                } else {
                    resultMap.put(Math.abs(Math.abs(target) + sum), sum);
                }
                if (sum == target){
                    return sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        for (Map.Entry<Integer, Integer> item : resultMap.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }

        return resultMap.get(resultMap.firstKey());
    }

    public static int threeSumClosest2(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && diff != 0; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (target > sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return target - diff;
    }
}
