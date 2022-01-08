import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TrheSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> resultSet = new HashSet<>();
        if(nums.length < 3) {
            return new ArrayList<>(resultSet);
        } else {
            Arrays.sort(nums);
            for (int i =0; i < nums.length - 2; i++){
                int left = i + 1;
                int right = nums.length-1;
                while (left < right){
                    int sum = nums[i] + nums [right] + nums[left];
                    if(sum == 0){
                        resultSet.add(Arrays.asList(nums[i], nums[right], nums[left]));
                    }
                    if (sum < 0){
                        left ++;
                    } else {
                        right --;
                    }
                }
            }
        }

        return new ArrayList(resultSet);
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        HashSet<List<Integer>> ans = new HashSet<>();
        if(nums.length<3)
            return new ArrayList(ans);
        else{
            Arrays.sort(nums);
            for(int i=0;i<nums.length-2;i++){
                int l = i+1,r = nums.length-1;
                while(l<r){
                    int sum = nums[l]+nums[r]+nums[i];
                    if(sum==0)
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    if(sum<0)
                        l++;
                    else
                        r--;
                }
            }
        }
        return new ArrayList(ans);
    }
}
