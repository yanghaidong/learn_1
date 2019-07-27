package jzOffer.chap2;


/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    /**
     * 将二进制数右移与1，如果结果等于1则最右位是1，右移一位继续比较
     * 存在问题：右移正负值处理不同可能会出现死循环
     * java中有三种移位运算符
     *
     * <<      :     左移运算符，num << 1,相当于num乘以2
     *
     * >>      :     右移运算符，num >> 1,相当于num除以2
     *
     * >>>    :     无符号右移，忽略符号位，空位都以0补齐
     * 本方法左右移，效率高于乘除
     * 可以使用无符号右移解决死循环问题
     */
    public int numberOf1_1(int n) {
        int count = 0;
        while (n !=0){
          if ((n & 1) == 1){
             count++;

          }
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 常规解法
     * 分别与每个位置上的符号位相与，每次乘以2，意味着左移一位
     * @param n
     * @return
     */
    public int numberOf1_2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((flag & n) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;

    }

    public int numberOf1_3(int n) {
        int count = 0;
        String binaryN = Integer.toBinaryString(n);
        char[] chars = binaryN.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i] == '1'){
                count++;
            }
        }
        return count;

    }
    /**
     * 最优解法
     * 如果一个二进制数减1，则第一个为1的二进制位变为0，其后如果有0的话，则全部变为1
     * 将其与数与操作，如果不为0，则一个数为1，继续进行同样的操作，一直到数为0停止
     * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
    /**
     * 判断一个整数是不是2的正整数次方。
     * 直接统计1的个数，看其是否等于1
     */
    public boolean isExponOf2(int n) {
        return numberOf1(n) == 1;
    }

    /**
     * 输入两个整数m和n，计算需要改变m的二进制表示中的几位才能得到n。
     * 比如10的二进制是1010，13的二进制是1101，则需要改变3次。
     * @param m 一个整数
     * @param n 另一个整数
     * @return 需要改变的位数
     */
    public int bitNumNeedsToBeChanged(int m, int n) {
        /**
         * 关键操作：先做异或操作
         * 如果不同则为1，相同为0
         * & 与操作，都为1才为1
         * | 或操作，都为0时才为0
         */

        return numberOf1(m ^ n);
    }
    public static void main(String[] args) {
        NumberOf1 n = new NumberOf1();
        System.out.println(n.numberOf1_1(9));
        System.out.println(n.numberOf1_2(9));
        System.out.println(n.numberOf1_3(9));
    }

    /**
     * 总结：
     * 三个方面：编程语言，数据结构，算法
     * 数据结构
     * {最基本的数组和字符串，频率高：链表，栈和队列，递归调用，
     * 查找（尤其是hash查找和二分查找）和排序（快速排序），加大难度：二叉树}
     * 初试复试复习的时候都应该去重视这些知识点
     * 三种题型:概念题，应用题，编程题
     */
}
