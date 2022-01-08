public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

    public static int maxArea(int[] height) {

        int maxResult = 0;
        int leftPos = 0;
        int rigtPos = height.length - 1;

        while (leftPos < rigtPos) {
            maxResult = Math.max(maxResult, Math.min(height[leftPos], height[rigtPos]) * (rigtPos - leftPos));
            if(height[leftPos] < height[rigtPos]) {
                leftPos ++;
            } else {
                rigtPos --;
            }
        }


        return maxResult;
    }

    public int maxArea2(int[] height) {
        int maxWater=0, left=0, right=height.length-1;

        while(left<right) {
            maxWater = Math.max(maxWater,(right-left)*Math.min(height[left], height[right]));

            if(height[left]<height[right]) left++;

            else right--;
        }

        return maxWater;
    }

}
