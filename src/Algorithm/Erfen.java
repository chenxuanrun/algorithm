package Algorithm;

public class Erfen {
    public static void main(String[] args) {
        int result = 24;
        int maxLength = 100;
        int[] list = new int[maxLength];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        //简单查找
        int time1 = 0;
        for (int i = 0; i < list.length; i++) {
            time1++;
            if (result == i) {
                break;
            }
        }
        System.out.println("简单查找时间为:" + time1);
        //二分查找
        /*原理：将数组分为三部分，依次是中值（所谓的中值就是数组中间位置的那个值）前，中值，中值后；
                将要查找的值和数组的中值进行比较，若小于中值则在中值前 面找，若大于中值则在中值后面找，等于中值时直接返回
             然后依次是一个递归过程，将前半部分或者后半部分继续分解为三部分。
         */
        int time2 = 0;
        int mid = 0;
        int min = 0;
        int max = maxLength - 1;
        while (true) {
            time2++;
            mid = (min + max) / 2;
            if (mid == result) {
                break;
            }
            if (mid > result) {
                max = mid - 1;
                System.out.println(mid);
            }
            if (mid < result) {
                min = mid + 1;
                System.out.println(mid);
            }

        }
        System.out.println("二分查找时间为:" + time2);
    }
}
