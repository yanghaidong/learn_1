package jzOffer.chap4;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个含有八个数的数组，判断有没有可能把这8个数字分别加到正方形的八个定点上，使得正方体上三组相对面的四个顶点的和都相等
 */
public class PermutationExt {
    public List<int[]> possibilitiesOfCube(int[] array){
         List<int[]> list = new ArrayList<>();
         if (array == null && array.length <= 0){
             return list;
         }

         //先得到所有的全排列组合
         List<int[]> All = permution(array);
         //检查对立面值是否相等
         for (int[] one : All){
             if (checkSum(one)){
                 list.add(one);
             }
         }
         return list;
    }

    private boolean checkSum(int[] array) {
        if ((array[0] + array[1] + array[2] + array[3] == array[4] + array[5] + array[6] + array[7]) &&
                (array[0] + array[1] + array[4] + array[5] == array[2] + array[3] + array[6] + array[7])
                && (array[0] + array[2] + array[4] + array[6] == array[1] + array[3] + array[5] + array[7])){
            return true;
        }
        return false;
    }

    public List<int[]> permution(int[] array) {
        List<int[]> list = new ArrayList<>();
        collect(array, 0 , list);
        return list;
    }

    private void collect(int[] array, int index, List<int[]> list) {
        if (index == array.length-1){
            if (!has(list,array)){
                // 必须使用副本，不能直接传入引用，否则list所有的int[]对象最后都一样
                list.add(Arrays.copyOf(array,array.length));
            }
        }
        //递归从传入的起始值开始
        for (int i=index;i<array.length;i++){
            swap(array, index, i);
            collect(array, index+1, list);
            swap(array, index, i);
        }
    }

    private boolean has(List<int[]> list, int[] array) {
        for (int[] one : list) {
            if (equal(one,array)) {
                return true;
            }
        }
        return false;
    }

    private boolean equal(int[] a, int[] b){
        for (int i=0;i<a.length;i++){
            //如果遇到不相等的则可以提前返货
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        PermutationExt p = new PermutationExt();
        int[] a = {8, 3, 5, 4, 1, 2, 5, 6};
        List<int[]> list = p.possibilitiesOfCube(a);
        System.out.println("有" + list.size() + "种可能");
        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
