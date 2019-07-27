package jzOffer.chap4;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����а˸��������飬�ж���û�п��ܰ���8�����ֱַ�ӵ������εİ˸������ϣ�ʹ���������������������ĸ�����ĺͶ����
 */
public class PermutationExt {
    public List<int[]> possibilitiesOfCube(int[] array){
         List<int[]> list = new ArrayList<>();
         if (array == null && array.length <= 0){
             return list;
         }

         //�ȵõ����е�ȫ�������
         List<int[]> All = permution(array);
         //��������ֵ�Ƿ����
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
                // ����ʹ�ø���������ֱ�Ӵ������ã�����list���е�int[]�������һ��
                list.add(Arrays.copyOf(array,array.length));
            }
        }
        //�ݹ�Ӵ������ʼֵ��ʼ
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
            //�����������ȵ��������ǰ����
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
        System.out.println("��" + list.size() + "�ֿ���");
        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
