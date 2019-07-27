package jzOffer.chap6;

/**
 * 数组中唯一出现一次的数字。
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次，请找出那个只出现一次的数字
 */
public class FindOneOnlyOnceAndThree {
    /**
     * 通过一个32位的数组保存数组中每个数相同位上的累加和，累加只有加1和加0
     * 然后从每个整数最后一位开始判断每一位的数字
     * 设置一个初试为1的标志位，判断每个整数每一位的数字，跟着循环逐次左移，遇1则累加
     * 将数组的每一位依次取余3，可以得到唯一数的每一位数字（0或1）
     * 设置一个初始为0的数，每次先左移，然后累加余数
     *
     * @param numbers
     * @return
     */
    public int findNumberAppearOnlyOnce(int[] numbers) {
        if (numbers == null && numbers.length < 2) throw new RuntimeException("无效输入");
        int[] bitSum = new int[32];
        int bitMask = 1;
        //因为对比值从1开始
        for (int i=31;i>=0;i--){
            for (int number : numbers){
                //与操作的条件不一定是1，如果在其他索引位可能是2的n次方，所以判断条件是是否为0
                if ((number & bitMask) != 0){
                    bitSum[i] += 1;
                }
            }
            bitMask = bitMask << 1;
        }
        int result = 0;
        //低位往高位移,循环从高位开始
        for (int j=0;j<32;j++){
            //必须先左移，才能保证第一个数不能被抹除，意味着低位往高位移
            result = result << 1;
            //通过取余是否为0，判断唯一数的二进制，判断唯一
            result += bitSum[j] % 3;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 4};
        FindOneOnlyOnceAndThree appearOnlyOnce = new FindOneOnlyOnceAndThree();
        System.out.println(appearOnlyOnce.findNumberAppearOnlyOnce(a));
    }
}
