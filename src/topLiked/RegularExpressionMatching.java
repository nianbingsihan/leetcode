package topLiked;


/**
 * 对给定的字符串s和正则表达式p,实现一个正则匹配方法,使得s完全匹配p
 * p包含如下特殊字符:
 * .单个字符
 * *重复前序字符0到多次
 * see <a bref="https://leetcode.com/problems/regular-expression-matching/" />
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        //正则表达式为空,字符串为空即可
        if(p.isEmpty()){
            return s.isEmpty();
        }
        //判断首字母是否匹配
        boolean firstMatch = (s.length()>0 && (s.charAt(0)==p.charAt(0) ||(p.charAt(0))=='.'));
        if(p.length()>=2 && p.charAt(1)=='*'){
            return isMatch(s,p.substring(2)) ||(firstMatch && isMatch(s.substring(1),p));
        }
        else{
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }


}
