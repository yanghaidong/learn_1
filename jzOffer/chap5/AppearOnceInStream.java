package jzOffer.chap5;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class AppearOnceInStream {
    private int index;
    private int[] count;

    public AppearOnceInStream(){
        count = new int[256];
        for (int i=0;i<256;i++){
            count[i] = -1;
        }
    }
    public void Insert(char ch)
    {
       if (count[ch] == -1) count[ch] = index;
       else if (count[ch] >= 0) count[ch] = -2;
       index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        //最大整数2的31次方-1
        int minIndex = Integer.MAX_VALUE;
        char c = '#';
        for (int i=0;i<count.length;i++){
            //每次循环满足条件时，为了保证第一次出现(字母顺序靠前的不一定第一次出现)，必须保证当前索引最小，小于记录下的当前索引才可以重新赋值
            if (count[i] >=0 && count[i] < minIndex){
                minIndex = count[i];
                c = (char)i;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        AppearOnceInStream a = new AppearOnceInStream();
        a.Insert('g');
        a.Insert('o');
        System.out.println(a.FirstAppearingOnce());
        a.Insert('o');
        a.Insert('g');
        a.Insert('l');
        a.Insert('e');
        System.out.println(a.FirstAppearingOnce());
    }
}
