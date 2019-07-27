package jzOffer.chap5;


/**
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����
 */
public class InversePairs {
    public int InversePairs1(int [] array) {
       if (array == null || array.length == 0) return 0;
       int[] aux = new int[array.length];

       return sort(array, aux, 0, array.length-1);

    }

    private int sort(int[] array, int[] aux, int low, int high) {

        //�߽�
        if (low >= high) return 0;
        int mid = low + (high-low)/2;
        ///��Ϊ������Χ
        int left = sort(array, aux, low, mid);
        int right = sort(array, aux, mid+1, high);
        //����ֽ����Ϊ��һ��ָ��Ĭ��ֵ
        int merge = mergePairs(array, aux, low, mid, high);

        return left+right+merge;

    }

    private int mergePairs(int[] array, int[] aux, int low, int mid, int high) {
        int count = 0;
        int len = (high-low)/2;
        //mid��һ����������һ��ֵ������
        int i = mid;
        int j = high;

        //�ݹ���ʼ�㲻��0���б߽�
        for (int m=low;m<array.length;m++){
            aux[m] = array[m];
        }
        //��ʼ����low
        for (int k=high;k>=low;k--){
            if (i < low) array[k] = aux[j--];
            //�ڶ��������mid+1��ʼ
            else if (j < mid+1) array[k] = aux[i--];
            else if (aux[i] > aux[j]){
                //ÿ���ۼӣ����õ���һ�������е�һ�����ȵڶ��������Ӧλ�ô�ʱ����Ϊ�����������Զ������Ӧλ��֮ǰ������ֵ������������Ե�
                count += j - mid;
                array[k] = aux[i--];
            }else {
                array[k] = aux[j--];
            }
        }
        return count;
    }
    //����ȫ�ֱ�����¼����
    private int cnt = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;

        mergeSortUp2Down(array, 0, array.length-1);
        return cnt;

    }

    /*
     * �鲢����(��������)
     */
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end) return;
        //���Ʊ�ʾ����2
        int mid = (start + end) >> 1;

        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid+1, end);
        merge(a, start, mid, end);
    }

    /*
     * ��һ�������е�����������������ϲ���һ��
     */
    public void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= end){
            if (a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                cnt += mid - i +1;
                temp[k++] = a[j++];
            }
        }
        //����һ��������
        while (i <= mid){
            temp[k++] = a[i++];
        }
        while (j <= end){
            temp[k++] = a[j++];
        }
        //���������¸�����Ӧλ�õ�ԭ����
        for (int m=0;m<temp.length;m++){
            a[start+m] = temp[m];
        }

    }
    public static void main(String[] args) {
        InversePairs i = new InversePairs();
        int[]  a = {1,2,3,4,5,6,7,0};
        System.out.println(i.InversePairs(a));
        System.out.println(i.InversePairs(a));
    }
}
