package Leatcode;

/**
 * @program: algorithmLearning
 * @description: leetcode_整数反转
 * @author: cxr
 * @create: 2019-10-17 16:57
 **/
public class ZhengShuFanZhuan {
    public static void main(String[] args) {
        System.out.println(new ZhengShuFanZhuan().reverse(-123));
    }
    public int reverse(int x) {
        String content = String.valueOf(x);
        String sign="";//符号位
        String num = "";//数字
        //匹配为负数则作为负数处理,否则则作为正数处理
        if ("-".equals(String.valueOf(content.charAt(0)))){
            sign="-";
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = content.length()-1;i>=1;i--){
                stringBuilder.append(content.charAt(i));
            }
            num = stringBuilder.toString();
        }else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = content.length()-1 ; i>=0 ; i--){
                stringBuilder.append(content.charAt( i));
            }
            num = stringBuilder.toString();
        }
        //超过范围则返回0
        long numLong = Long.parseLong(num);
        long left = -1<<31;
        long right = (1<<31)-1;
        if (numLong<left||numLong>right){
            return 0;
        }
        return Integer.parseInt(sign+num);
    }
}
