package topLiked;

/**
 * see <a href="https://leetcode.com/problems/container-with-most-water/" />
 */
public class ContainerWithMostWater {
    /**
     * 暴力穷举
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                max = Math.max(max,(Math.min(height[i],height[j]))*(j-i));
                System.out.println("(" + height[i] + "," + height[j] + ")=" + (Math.min(height[i],height[j]))*(j-i));
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {
        int max = 0;
        int length = height.length;
        int l=0,r=length-1;
        while(l<r){
            max = Math.max(max,(Math.min(height[l],height[r]))*(r-l));
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
        System.out.println(maxArea2(input));
    }
}
