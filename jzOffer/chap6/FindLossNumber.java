package jzOffer.chap6;

/**
 * 0~n-1��ȱʧ����
 * һ������Ϊn -1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֵĶ��ڷ�Χ0~n-1֮�ڡ�
 * �ڷ�Χ��0~n-1�ڵ�n������������ֻ��һ�����ֲ��ڸ������У��ҳ��������
 */
public class FindLossNumber {
    /**
     * �ֱ����0-n-1�ĺ�n*(n-1)/2
     * �������
     * ���
     *
     */


    /**
     * ���ֲ���
     * @param array
     * @return
     */
    public int findLoss(int[] array) {
        if (array == null) return -1;
        int low = 0;
        int len = array.length;
        int high = len -1;
        while (low <= high){
            int mid = (low+high)>>1;
            if (mid != array[mid]){
                if (mid == 0 || mid-1 == array[mid-1]){
                    return mid;
                }else {
                    high = mid-1;
                }
            }else {
                low = mid + 1;
            }
        }
        if (low == len) return len;
        //  ��Ч���������飬�粻�ǵ������򣬻����е����ֳ�����0~n-1�ķ�Χ
        return -1;
    }
}
