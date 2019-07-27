package jzOffer.chap4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 8X8的国际棋盘上，有8个皇后，使其不能相互攻击，即它们不能在同一行、同一列、且同一条对角
 */
public class EightQueens {

    /**
     * 1、保证不同行：使用一个数组表示不同行的皇后，八个皇后则int[] queens = new int[8]，其中queens[i]表示位于第i行的皇后，这保证了皇后不位于同一行
     * 2、保证不同列：为queens[i]赋值各不相同的数值，queens[i] = j表示位于i行的皇后也位于j列，每个i赋予了不同的j值保证了不同行的皇后也不位于不同列
     * 3、保证在同一条对角线：如果在同一条对角线，说明正方形的行数等于列数，即当j > i时:
     * j - i == queens[j] -queens[i]（第j行的皇后在第i行的皇后右下方）；或者j - i == queens[i] -queens[j](第j行的皇后在第i行的皇后左下方)
     * <p>
     * 这又是一个全排列的扩展问题，先求出所有的排列可能，从中排除不符合要求的摆放方法即可
     */
    public List<int[]> possibilitiesOfQueensPlaced() {
        List<int[]> list = new ArrayList<>();
        // 大小为8的数组，且数值各不相同，任意排列都保证了不同行不同列
        int[] array = {0,1,2,3,4,5,6,7};
        //调用之前的全排列函数
        PermutationExt permutationExt = new PermutationExt();
        List<int[]> all = permutationExt.permution(array);
        //去除满足对角线的情况
        for (int[] one : all){
            if (!isLocatedSameDiagonal(one)){
                list.add(one);
            }
        }
        return list;
    }

    //检查任意两个皇后是否在同一条对角线上
    private boolean isLocatedSameDiagonal(int[] array) {
        //双重循环按照每个依次与之后行元素位置的判断
        for (int i=0;i<array.length;++i){
            for (int j=i+1;j<array.length;++j){
                if ((j - i == array[j] - array[i]) && (j - i == array[i] - array[j])){
//                if ((Math.abs(j - i) == Math.abs(array[j] - array[i]))){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        List<int[]> l = queens.possibilitiesOfQueensPlaced();
        System.out.println("共有" + l.size() + "种放置方法");
        for (int[] arr : l) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
