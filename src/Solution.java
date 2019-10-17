import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: algorithmDemo
 * @description: Solution
 * @author: cxr
 * @create: 2019-08-25 00:11
 **/
public class Solution {
  public static void main(String[] args) {
    System.out.println(new Solution().firstUniqChar("loveleetcode"));
  }
  public int firstUniqChar(String s) {
    if (s.equals("")){
      return -1;
    }
      HashSet setRepeat = new HashSet();
      List list = new LinkedList();
      for (int i = 0 ; i < s.length() ; i++){
        if (setRepeat.contains(s.charAt(i))){
            list.remove((Object) s.charAt(i));
            continue;
        }else{
          list.add(s.charAt(i));
          setRepeat.add(s.charAt(i));
        }
      }
      if (list.size()==0){
        return -1;
      }
      return s.indexOf(String.valueOf(list.get(0)));
  }
}
    