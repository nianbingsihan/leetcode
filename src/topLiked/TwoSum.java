package topLiked;

/**
 * @ <a bref="https://leetcode.com/problems/two-sum" />
 */
public class TwoSum {

    /**
     * 暴力穷举法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if(length<2){
            return null;
        }
        int[] res = new int[2];
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                if((nums[i] + nums[j]) == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
                else {
                    continue;
                }
            }
        }
        return null;
    }

    

}