package jzOffer.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或者3。
 */
public class FindDuplicate {
    /**
     * 先排序，然后两两比较，时间复杂度为o(nlogn)
     * @param numbers
     * @param length
     * @return
     */

    public static ArrayList duplicate(int numbers[],int length) {
        if (numbers.length < 0 || numbers == null){
            return null;
        }
        Arrays.sort(numbers);
        int i;
        ArrayList list = new ArrayList();
        for(i=0;i<length-1;i++){
            if (numbers[i] == numbers[i+1]){
               list.add(numbers[i]);
            }
        }
        return list;
    }

    /**
     * 借用哈希表进行解决，时间复杂度为O(n),需要一个哈希表空间复杂度为o(n)
     * @param numbers
     * @param len
     * @return
     */
    public static ArrayList duplicate2(int numbers[],int len){
        if (numbers.length < 0 || numbers == null){
            return null;
        }
        ArrayList list = new ArrayList();
        Map map = new HashMap<>();
        for (int i=0;i<len;i++){
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], i);
            }else {
                list.add(numbers[i]);
            }
        }
        return list;
    }

    /**
     * 空间复杂度为O(1),循环数组，先跟自己下标相比是否相等
     * 如果相等则继续遍历
     * 如果不相等则比较其值作为下标对应位置的值是否相等
     * 不相等则交换位置
     * 相等则退出
     * @param numbers
     * @param len
     * @return
     */
    public static ArrayList duplicate3(int numbers[],int len){
        if (numbers.length < 0 || numbers == null){
            return null;
        }
        for (int i = 0;i < len;i++){
            if (numbers[i] < 0 || numbers[i] > len -1) {
                return null;
            }
        }
        ArrayList list = new ArrayList();
        int i = 0;
        while (i < len){
            if (numbers[i] == i){
                i++;
            }else if (numbers[i] != numbers[numbers[i]]){
               swap(numbers[i],numbers[numbers[i]]);
            }else {
                list.add(numbers[i]);
                break;
            }
        }

        return list;
    }

    private static void swap(int a,int b) {
        int tepm = a;
        a = b;
        b = tepm;
    }
    /**
     * 双重循环遍历解决
     * @param numbers
     * @param length
     * @return
     */
    public static ArrayList duplicate1(int numbers[],int length) {
        if (numbers.length < 0 || numbers == null){
            return null;
        }
        int i,j;
        ArrayList list = new ArrayList();
        for (i=0;i<length-1;i++){
            for (j=i+1;j<length;j++)
              if (numbers[i] == numbers[j]){
                list.add(numbers[j]);
              }
        }
        return list;
    }
    /**
     * boolean只占一位，所以还是比较省的，利用数组下标不重复，将数组内数值变成布尔类型的下标
     * 遇到下标位置数值为true的则重复,时间和空间复杂度和哈希类似
     */

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(duplicate(nums,7));
        System.out.println(duplicate1(nums,7));
        System.out.println(duplicate2(nums,7));
        System.out.println(duplicate3(nums,7));
    }
}
