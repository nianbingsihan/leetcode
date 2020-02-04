package topLiked;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/" />
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int length = s.length();
        Map charMap = new HashMap<>();
        int i=0;
        char charI;
        char[] sChars = s.toCharArray();
        while(i<length){
            charI = sChars[i];
            if(charMap.containsKey(charI)){
                result = (charMap.size()>result)?charMap.size():result;
                charMap.clear();
            }
            charMap.put(charI,1);
            i++;
        }
        return (charMap.size()>result)?charMap.size():result;
    }

    public static void main(String[] args){
        String s = "abcabd";
        System.out.println(s);
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring3(s));
    }

    /**
     * 方法1 暴力穷举
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        int max = 0;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(allUnique(s,i,j)){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

    public static boolean allUnique(String s, int begin, int end){
        Set<Character> sets = new HashSet<Character>();
        for(int i=begin; i<=end; i++){
            Character c = s.charAt(i);
            if(!sets.contains(c)){
                sets.add(c);
            }
            else{
                return false;
            }
        }
        return true;
    }

    /**
     * 滑动窗口解法,使用HashSet
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int res = 0;
        HashSet<Character> hs = new HashSet<Character>();
        int i=0,j=0;
        while(i<n && j<n){
            Character c = s.charAt(j);
            if(!hs.contains(c)){
                hs.add(c);
                j++;
                res = Math.max(res,j-i);
            }
            else{
                hs.remove(c);
                i++;
            }
        }
        return res;
    }

    /**
     * 优化后的滑动窗口解法,使用HashMap保存每个char在string中的index
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
//        int res=0;
//        int n = s.length();
//        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
//        for(int i=0,j=0;j<n;j++){
//            Character c = s.charAt(j);
//            if(hm.containsKey(c)){
//                i = j;
//                res = Math.max(res,hm.size());
//                hm.clear();
//            }
//            hm.put(c,j);
//        }
//        return res;
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            //保存char的index+1,保证i = Math.max(map.get(s.charAt(j)), i);
            // 这一步滑动窗口的左边边缘可以一次性跳到上一个重复字符的index+1
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }





}
