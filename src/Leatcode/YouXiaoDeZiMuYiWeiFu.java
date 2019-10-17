package Leatcode;

/**
 * @program: algorithmLearning
 * @description: leatcode_有效的字母异位词
 * @author: cxr
 * @create: 2019-10-17 18:10
 **/
public class YouXiaoDeZiMuYiWeiFu {
    public static void main(String[] args) {
        System.out.println(new YouXiaoDeZiMuYiWeiFu().isAnagram("anagram","nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int length = 26;
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (int i = 0 ; i <s.length();i++){
            sArr[s.charAt(i)-'a']++;
            tArr[t.charAt(i)-'a']++;
        }
        for (int i = 0 ; i <sArr.length;i++){
            if (sArr[i]!=tArr[i]){
                return false;
            }
        }
        return true;
    }
}
