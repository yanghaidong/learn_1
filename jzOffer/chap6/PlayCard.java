package jzOffer.chap6;

import java.util.Arrays;

/**
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ������������ǲ��������ġ�2~10�����ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С�����Կ����������֡�
 */
public class PlayCard {
    public boolean isContinuous(int [] numbers) {
         if (numbers == null || numbers.length < 5) return false;
        Arrays.sort(numbers);
        int joker = 0;
        //����������4��0
        for (int i=0;i<4;i++){
            if (numbers[i] == 0) joker++;
        }
        int totalGap = 0;
        //�д�С���Ļ�����ǰ�棬���дӺ����ų���С���ж�
        for (int j=numbers.length-1;j>joker;j--){
            //��������ֱ�ӷ���false
            if (numbers[j] == numbers[j-1]) return false;
            //ͳ���ܼ������������֮��ļ��Ϊ0
            totalGap += numbers[j] - numbers[j-1] -1;
        }
        //�ж��ܼ���Ƿ񳬹���С��
        return totalGap <= joker;
    }

    /**
     * ����2������0֮�⣬�������ֲ����ظ����֣������Сֵֻ��ó���5
     * @param numbers
     * @return
     */
    public static boolean isContinuous2(int [] numbers) {
        if (numbers == null || numbers.length < 5) return false;
        int[] count = new int[14];
        //��Сֵ����������ֵ������С
        int max = -1;
        int min = 14;
        for (int number : numbers){
            count[number]++;
            //ȥ����С��
            if (number != 0){
                //�����ظ�
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
