package jzOffer.chap2;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length <= 0 || array == null){
            return 0;
        }
        int left = 0,right = array.length-1,mid = 0;
        //��֤��ת
        while (array[left] >= array[right]){
            //����ָ������ֹͣ
            if (right - left == 1){
                mid = right;
                //ѭ����ֹ
                break;
            }
            /**
             * ����м�ֵ����β��ȣ���˳��Ѱ����Сֵ
             * or mid = (left + right)/2
             */
//            mid = (left + right)/2;
            mid = left + (right - left)/2;
            if (array[left] == array[right] && array[right] == array[mid]){
                return minArray(array,left,right);
            }
            /**
             *����м�ֵ���ڵ������ָ�룬��λ�ڵ�һ�����������У���СԪ��λ���м�Ԫ�ص�ǰ�棬�ı���ָ��
             * ������СԪ��λ�ں������У���СԪ��λ���м�����ĺ��棬�ı���ָ�����
             */
            if (array[mid] >= array[left]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return array[mid];
    }

    private int minArray(int[] array, int left, int right) {
        int min = array[left];
        for (int i=left+1;i<array.length;i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinNumberInRotateArray number = new MinNumberInRotateArray();
        int[] a = {3,4,5,1,2};
        System.out.println(number.minNumberInRotateArray(a));
    }
}
