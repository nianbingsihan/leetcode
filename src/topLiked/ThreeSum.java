package topLiked;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * see <a href="https://leetcode.com/problems/3sum/" />
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(length <3){
            return ans;
        }
        for(int i=0; i<length-2; i++){
            for(int j=i+1; j<length-1; j++){
                for(int k=j+1; k<length; k++){
                    if(0==(nums[i]+nums[j]+nums[k])){
                        List<Integer> ele = new ArrayList<Integer>();
                        ele.add(nums[i]);
                        ele.add(nums[j]);
                        ele.add(nums[k]);
                        if(!isRepeatInCollection(ans,ele)){
                            ans.add(ele);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static boolean isRepeatInCollection(List<List<Integer>> list,List<Integer> ele){
        for(int i=0; i<list.size(); i++){
            List<Integer> it = list.get(i);
            if(it.containsAll(ele)&& ele.containsAll(it)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
//        int[] input = {-1, 0, 1, 2, -1, -4};
        int[] input = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
//        int[] input = {};
        List<List<Integer>> ans = threeSum(input);
        System.out.println(ans.toString());

    }

}
