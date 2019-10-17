package Leatcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithmLearning
 * @description: leetcode_字符串中的第一个唯一字符
 * @author: cxr
 * @create: 2019-10-17 17:48
 **/
public class ZiFuChuanZhongDeDIYiGeWeiYiZiFu {
    public static void main(String[] args) {
        System.out.println(new ZiFuChuanZhongDeDIYiGeWeiYiZiFu().firstUniqChar("loveleetcode"));
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
