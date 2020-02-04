package topLiked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * see <a bref="https://leetcode.com/problems/median-of-two-sorted-arrays/" />
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0.0;
        int l1 = nums1.length,l2 = nums2.length;
        int l3 = l1+l2;
        int[] n3 = new int[l3];
        for(int i=0; i<l1; i++){
            n3[i] = nums1[i];
        }
        for(int j=0; j<l2; j++){
            n3[l1+j] = nums2[j];
        }
        Arrays.sort(n3);
        if(l3%2==0){
            ans = (double)(n3[l3/2-1]+n3[l3/2])/2;
        }
        else{
            ans = n3[(l3-1)/2];
        }
        return ans;
    }

    public static void main(String[] args){
        int[] a1 = {1,3,5,7};
        int[] a2 = {4,6,8,9};
        System.out.println(findMedianSortedArrays(a1,a2));
    }

    /**
     * 看答案后的写法
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //确保m<=n
        if(m>n){
            int temp=m;
            m=n;
            n=temp;
            int[] tmp=nums1;
            nums1 = nums2;
            nums1 = tmp;
        }
        int imin=0, imax=m;
        //同时兼容m+n为奇数/偶数的情况
        int mid = (m+n-1)/2;
        while(imin <= imax){
            int i = (imin + imax)/2;
            int j = mid - i;
            if(i<imax && nums2[j-1]>nums1[i]){
                imin=i+1;
            }
            if(i>imin && nums1[i-1] > nums2[j]){
                imax = i-1;
            }
            else{
                double maxLeft=0.0;
                if(i==0){
                    maxLeft = nums2[j-1];
                }
                if(j==0){
                    maxLeft = nums1[i-1];
                }
                else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2==0){
                    return maxLeft;
                }

                double minRight = 0.0;
                if(i==m){
                    minRight = nums2[j];
                }
                if(j==n){
                    minRight = nums1[i];
                }
                else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                if((m+n)%2==1){
                    return  (maxLeft+minRight)/2.0;
                }
            }
        }
        return 0.0;
    }


}
