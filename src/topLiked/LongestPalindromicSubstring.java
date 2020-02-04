package topLiked;

import java.util.Stack;
import java.util.Vector;

/**
 * see <a bref="https://leetcode.com/problems/longest-palindromic-substring/"/>
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){
        String s = "jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
    }

    /**
     * 方法一,暴力穷举;
     * @param s
     * @return
     */
    public static  String longestPalindrome(String s) {
        int length = s.length();
        int max = 0;
        String ans = "";
        String temp;
        for(int i=0; i<length; i++){
            for(int j=i+1; j<length+1;j++){
                temp = s.substring(i,j);
                if(isStringPalind(s.substring(i,j)) && max<(j-i)){
                    max = j-i;
                    ans = temp;
                }
            }
        }
        return ans;
    }

    public static boolean isStringPalind(String s) {
        boolean res = false;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        Character c;
        for(int i=0; i<length; i++){
            c = s.charAt(i);
            if(length%2 == 1){//奇数长度
                if(i<length/2){
                    stack.push(c);
                }
                if(i>length/2){
                    if(c == stack.peek()){
                        stack.pop();
                    }
                }
            }
            else{//偶数长度
                if(i<length/2){
                    stack.push(c);
                }
                if(i>=length/2){
                    if(c == stack.peek()){
                        stack.pop();
                    }
                }
            }
        }
        res = (stack.size()==0);
        return  res;
    }

    /**
     * 方法2 见参考答案5,由中间向两端扩散
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if(null == s || s.length() ==0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        int start=0, end=0;
        int max = 0 ;
        int length = s.length();
        for(int i=0; i<length-1; i++){
            //以s.charAt(i)为中心搜索最长回文字符串
            int len1 = expandFromCenter(s,i,i);
            //以s.charAt(i)与s.charAt(i+1)为中心搜索最长回文字符串
            int len2 = expandFromCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);

    }

    private static int expandFromCenter(String s, int start, int end){
        int length = s.length();
        while(start >=0 && end < length && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }

}
