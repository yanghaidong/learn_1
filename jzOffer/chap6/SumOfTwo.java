package jzOffer.chap6;

import java.util.ArrayList;

/**
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 */
public class SumOfTwo {
    /**
     * ��������ָ�룬һͷһβ���ֱ���֤����s�Ĵ�С,������
     * =
     * >�ƶ���ָ��
     *
     * <�ƶ�Сָ��
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

         ArrayList<Integer> list  = new ArrayList<>();
        if (array == null || array.length == 0) return list;
        int low = 0;
         int high = array.length - 1;
         while (low < high){
             if (array[low] + array[high] == sum){
                 list.add(array[low]);
                 list.add(array[high]);
                 //�ҵ���һ�Ա�������ֶԣ���Ȼ�ǳ˻���С�ģ�a+b=sum,a��bԽԶ�˻�ԽС
                 break;
             }else {
                 if (array[low] + array[high] > sum){
                     high--;
                 }else {
                     low++;
                 }

             }
         }
         return list;
    }

}
