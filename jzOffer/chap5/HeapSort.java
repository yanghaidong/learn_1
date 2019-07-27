package jzOffer.chap5;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public void heapSort(int[] array){
        int len = array.length;
        if (array == null && len == 0) return;

        //建立最大堆
        for (int i=len/2-1;i>=0;i--){
            adjustHeap(array, i, len);
        }

        //交换排序
        for (int j=len-1;j>0;j--){
            swap(array, 0, j);
            // 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
            // 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因
            // 而这里，实质上是自上而下，自左向右进行调整的

            adjustHeap(array, 0, j);
        }
    }

    private void adjustHeap(int[] array, int i, int len) {
        // 先把当前元素取出来，因为当前元素可能要一直移动
        int temp = array[i];
        // 实质上，就是根节点和其左右子节点记性比较，让k指向这个不超过三个节点的子树中最大的值
        // 这里，必须要说下为什么k值是跳跃性的。
        // 首先，举个例子，如果a[0] > a[1]&&a[0]>a[2],说明0,1,2这棵树不需要调整，那么，下一步该到哪个节点了呢？肯定是a[1]所在的子树了，
        // 也就是说，是以本节点的左子节点为根的那棵小的子树
        // 而如果a[0}<a[2]呢，那就调整a[0]和a[2]的位置，然后继续调整以a[2]为根节点的那棵子树，而且肯定是从左子树开始调整的
        // 所以，这里面的用意就在于，自上而下，自左向右一点点调整整棵树的部分，直到每一颗小子树都满足大根堆的规律为止

        for (int k=2*i+1;k<len;k=2*k+1){
            if (k+1 < len && array[k] < array[k+1] ){
                k++;
            }
            // 如果发现子节点更大，则进行值的交换
            if (temp < array[k]){
                swap(array, k, i);
                // 下面就是非常关键的一步了
                // 如果子节点更换了，那么，以子节点为根的子树会不会受到影响呢？
                // 所以，循环对子节点所在的树继续进行判断

                i = k;//改变的是交换的i值
            }else {
                break;
            }
        }
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        int [] arr = {10,7,2,11,3,4,1,8};
        h.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
