package jzOffer.chap6;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这五张牌是不是连续的。2~10是数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
 */
public class PlayCard {
    public boolean isContinuous(int [] numbers) {
         if (numbers == null || numbers.length < 5) return false;
        Arrays.sort(numbers);
        int joker = 0;
        //排序后最多有4个0
        for (int i=0;i<4;i++){
            if (numbers[i] == 0) joker++;
        }
        int totalGap = 0;
        //有大小王的话都在前面，所有从后面排除大小王判断
        for (int j=numbers.length-1;j>joker;j--){
            //遇到对子直接返回false
            if (numbers[j] == numbers[j-1]) return false;
            //统计总间隔，比如相邻之间的间隔为0
            totalGap += numbers[j] - numbers[j-1] -1;
        }
        //判断总间隔是否超过大小王
        return totalGap <= joker;
    }

    /**
     * 方法2：除了0之外，其他数字不可重复出现；最大最小值只差不得超过5
     * @param numbers
     * @return
     */
    public static boolean isContinuous2(int [] numbers) {
        if (numbers == null || numbers.length < 5) return false;
        int[] count = new int[14];
        //最小值保持最大，最大值保持最小
        int max = -1;
        int min = 14;
        for (int number : numbers){
            count[number]++;
            //去除大小王
            if (number != 0){
                //不能重复
                if (count[number] > 1) return false;
                if (min > number) min = number;
                if (max < number) max = number;
            }

        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,2,5,4};
        System.out.println(isContinuous2(numbers));
    }
}
