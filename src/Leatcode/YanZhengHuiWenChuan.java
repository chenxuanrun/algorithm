package Leatcode;

/**
 * @program: algorithmLearning
 * @description: leetcode_验证回文串 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @author: cxr
 * @create: 2019-11-08 15:01
 **/
public class YanZhengHuiWenChuan {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s = s.replaceAll("[^0-9a-zA-Z]", "");
        StringBuilder stringBuilder=new StringBuilder(s);
        stringBuilder = stringBuilder.reverse();
        String reverseStr = stringBuilder.toString();
        if (reverseStr.equals(s)){
            return true;
        }else {
            return false;
        }
    }
}
