package jzOffer.chap2;
/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * ���һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class Find2DArrays {
    /**
     * �������
     * @param arrays
     * @param m
     * @return
     */
    public boolean find2DArrays(int[][] arrays,int m){
        if (arrays == null || arrays.length ==0){
            return false;
        }
        boolean flag = false;
        for (int i=0;i < arrays.length;i++){
            for (int j=0;j < arrays[i].length;j++){
                if (arrays[i][j] == m){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * �����Ͻ�Ԫ�ؿ�ʼ�Ƚϣ��������
     * ���ڸ�Ԫ�ؾͿ���ȥ������һ��
     * С�ڸ�Ԫ�������ȥ���ұ�һ��
     * �±���Ϊ���������ƶ�
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        boolean flag = false;
        int row = 0;
        int column = array[0].length-1;
        /***
         * ע��Ԫ����Ԫ���±����0
         */
        while (row < array.length && column >= 0) {
            if (target == array[row][column]) {
                flag = true;
                return flag;
            } else if (target < array[row][column]) {
                --column;
            }else {
                ++row;
            }
        }
        return flag;
    }

    /**
     * ���ַ�����
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int[][] array) {
        if (array != null && array.length > 0) {
            // ע��high��ѭ���⣬һ��ֵ�����´�ѭ�������ٱ���ʼ�����ɼ��ٱȽϴ���
            int high = array[0].length - 1;
            for (int i = 0; i < array.length; i++) {
                int low = 0;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (target > array[i][mid]) {
                        low = mid + 1;
                    } else if (target < array[i][mid]) {
                        high = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arrays = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Find2DArrays find2DArrays = new Find2DArrays();
        System.out.println(find2DArrays.find2DArrays(arrays,15));
        System.out.println(find2DArrays.Find(13,arrays));
        System.out.println(find2DArrays.Find2(7,arrays));
    }
}
