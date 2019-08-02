package jzOffer.chap2;
/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find2DArrays {
    /**
     * 暴力解决
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
     * 从右上角元素开始比较，相等则是
     * 大于该元素就可以去掉上面一行
     * 小于该元素则可以去掉右边一列
     * 下标作为变量进行移动
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        boolean flag = false;
        int row = 0;
        int column = array[0].length-1;
        /***
         * 注意元素列元素下标包括0
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
     * 二分法查找
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int[][] array) {
        if (array != null && array.length > 0) {
            // 注意high在循环外，一旦值更新下次循环不会再被初始化，可减少比较次数
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
