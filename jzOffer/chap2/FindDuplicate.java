package jzOffer.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2����3��
 */
public class FindDuplicate {
    /**
     * ������Ȼ�������Ƚϣ�ʱ�临�Ӷ�Ϊo(nlogn)
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
     * ���ù�ϣ����н����ʱ�临�Ӷ�ΪO(n),��Ҫһ����ϣ��ռ临�Ӷ�Ϊo(n)
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
     * �ռ临�Ӷ�ΪO(1),ѭ�����飬�ȸ��Լ��±�����Ƿ����
     * ���������������
     * ����������Ƚ���ֵ��Ϊ�±��Ӧλ�õ�ֵ�Ƿ����
     * ������򽻻�λ��
     * ������˳�
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
     * ˫��ѭ���������
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
     * booleanֻռһλ�����Ի��ǱȽ�ʡ�ģ����������±겻�ظ�������������ֵ��ɲ������͵��±�
     * �����±�λ����ֵΪtrue�����ظ�,ʱ��Ϳռ临�ӶȺ͹�ϣ����
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
