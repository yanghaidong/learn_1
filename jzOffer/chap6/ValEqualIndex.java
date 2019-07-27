package jzOffer.chap6;
/**
 * ��������ֵ���±���ȵ�Ԫ�ء�
 * ����һ�������������������ÿ��Ԫ�ض�������������Ψһ�ġ�
 * �ҳ�����������һ����ֵ�������±��Ԫ�ء�����������{-3�� -1�� 1�� 3�� 5}������3�������±����
 */
public class ValEqualIndex {
    public int findValEqualsIndex(int[] array) {
        if (array == null) return -1;
        int low = 0;
        int high = array.length-1;
        while (low <= high){
            int mid = (low + high) >> 1;
            if (mid == array[mid]) return mid;
            //����±����ֵ������ȵ�ֵ��Ȼ���ұ�
            if (mid > array[mid]) low = mid +1;
            //����±�С��ֵ������ȵ�ֵ��Ȼ�����
            if (mid < array[mid]) high = mid -1;
        }
        return -1;
    }
}
