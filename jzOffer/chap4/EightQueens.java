package jzOffer.chap4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 8X8�Ĺ��������ϣ���8���ʺ�ʹ�䲻���໥�����������ǲ�����ͬһ�С�ͬһ�С���ͬһ���Խ�
 */
public class EightQueens {

    /**
     * 1����֤��ͬ�У�ʹ��һ�������ʾ��ͬ�еĻʺ󣬰˸��ʺ���int[] queens = new int[8]������queens[i]��ʾλ�ڵ�i�еĻʺ��Ᵽ֤�˻ʺ�λ��ͬһ��
     * 2����֤��ͬ�У�Ϊqueens[i]��ֵ������ͬ����ֵ��queens[i] = j��ʾλ��i�еĻʺ�Ҳλ��j�У�ÿ��i�����˲�ͬ��jֵ��֤�˲�ͬ�еĻʺ�Ҳ��λ�ڲ�ͬ��
     * 3����֤��ͬһ���Խ��ߣ������ͬһ���Խ��ߣ�˵�������ε�������������������j > iʱ:
     * j - i == queens[j] -queens[i]����j�еĻʺ��ڵ�i�еĻʺ����·���������j - i == queens[i] -queens[j](��j�еĻʺ��ڵ�i�еĻʺ����·�)
     * <p>
     * ������һ��ȫ���е���չ���⣬��������е����п��ܣ������ų�������Ҫ��İڷŷ�������
     */
    public List<int[]> possibilitiesOfQueensPlaced() {
        List<int[]> list = new ArrayList<>();
        // ��СΪ8�����飬����ֵ������ͬ���������ж���֤�˲�ͬ�в�ͬ��
        int[] array = {0,1,2,3,4,5,6,7};
        //����֮ǰ��ȫ���к���
        PermutationExt permutationExt = new PermutationExt();
        List<int[]> all = permutationExt.permution(array);
        //ȥ������Խ��ߵ����
        for (int[] one : all){
            if (!isLocatedSameDiagonal(one)){
                list.add(one);
            }
        }
        return list;
    }

    //������������ʺ��Ƿ���ͬһ���Խ�����
    private boolean isLocatedSameDiagonal(int[] array) {
        //˫��ѭ������ÿ��������֮����Ԫ��λ�õ��ж�
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
        System.out.println("����" + l.size() + "�ַ��÷���");
        for (int[] arr : l) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
