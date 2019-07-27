package jzOffer.chap5;

/**
 * 输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数，
 * 例如输入12, 1~12中出现1的有1、10、11、12共5次
 */
public class NumberOfOne {
    /**
     * 常规方法
     * 计算每个数字中1的个数，复杂度O(nlgn)
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
       if (n == 0) return 0;
       int count = 0;
       for (int i=1;i<=n;i++){
          count += Numof1(i);
       }
       return count;
    }

    /**
     * 复杂度O(lgn)
     * @param number
     * @return
     */
    private static int Numof1(int number) {
        int count = 0;
        while (number > 0){
            if (number%10 == 1){
                count++;
            }
            number = number/10;
        }
        return count;
    }

    /**
     * 用字符串拼接所有数，然后数
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution1(int n) {
        if (n == 0) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=n;i++){
            sb.append(i);
        }
        int count = 0;
        for (int j=0;j<sb.length();j++){
            if (sb.charAt(j) == '1'){
                count++;
            }
        }
        return count;
    }

    /**
     * 像类似这样的问题，我们可以通过归纳总结来获取相关的东西。
     *
     * 首先可以先分类：
     *
     * 个位
     * 我们知道在个位数上，1会每隔10出现一次，例如1、11、21等等，我们发现以10为一个阶梯的话，每一个完整的阶梯里面都有一个1，例如数字22，按照10为间隔来分三个阶梯，在完整阶梯0-9，10-19之中都有一个1，但是19之后有一个不完整的阶梯，我们需要去判断这个阶梯中会不会出现1，易推断知，如果最后这个露出来的部分小于1，则不可能出现1（这个归纳换做其它数字也成立）。
     *
     * 我们可以归纳个位上1出现的个数为：
     *
     * n/10 * 1+(n%10!=0 ? 1 : 0)
     *
     * 十位
     * 现在说十位数，十位数上出现1的情况应该是10-19，依然沿用分析个位数时候的阶梯理论，我们知道10-19这组数，每隔100出现一次，这次我们的阶梯是100，例如数字317，分析有阶梯0-99，100-199，200-299三段完整阶梯，每一段阶梯里面都会出现10次1（从10-19），最后分析露出来的那段不完整的阶梯。我们考虑如果露出来的数大于19，那么直接算10个1就行了，因为10-19肯定会出现；如果小于10，那么肯定不会出现十位数的1；如果在10-19之间的，我们计算结果应该是k - 10 + 1。例如我们分析300-317，17个数字，1出现的个数应该是17-10+1=8个。
     *
     * 那么现在可以归纳：十位上1出现的个数为：
     *
     * 设k = n % 100，即为不完整阶梯段的数字
     * 归纳式为：(n / 100) * 10 + (if(k > 19) 10 else if(k < 10) 0 else k - 10 + 1)
     * 百位
     * 现在说百位1，我们知道在百位，100-199都会出现百位1，一共出现100次，阶梯间隔为1000，100-199这组数，每隔1000就会出现一次。这次假设我们的数为2139。跟上述思想一致，先算阶梯数 * 完整阶梯中1在百位出现的个数，即n/1000 * 100得到前两个阶梯中1的个数，那么再算漏出来的部分139，沿用上述思想，不完整阶梯数k199，得到100个百位1，100<=k<=199则得到k - 100 + 1个百位1。
     *
     * 那么继续归纳百位上出现1的个数：
     *
     * 设k = n % 1000
     * 归纳式为：(n / 1000) * 100 + (if(k >199) 100 else if(k < 100) 0 else k - 100 + 1)
     * 后面的依次类推....
     *
     * 再次回顾个位
     * 我们把个位数上算1的个数的式子也纳入归纳式中
     *
     * k = n % 10
     * 个位数上1的个数为：n / 10 * 1 + (if(k > 1) 1 else if(k < 1) 0 else k - 1 + 1)
     * 完美！归纳式看起来已经很规整了。 来一个更抽象的归纳，设i为计算1所在的位数，i=1表示计算个位数的1的个数，10表示计算十位数的1的个数等等。
     *
     * k = n % (i * 10)
     * count(i) = (n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
     * 好了，这样从10到10的n次方的归纳就完成了。
     *
     * sum1 = sum(count(i))，i = Math.pow(10, j), 0<=j<=log10(n)
     * 但是有一个地方值得我们注意的，就是代码的简洁性来看，有多个ifelse不太好，能不能进一步简化呢？ 我们可以把后半段简化成这样，我们不去计算i * 2 - 1了，我们只需保证k - i + 1在[0, i]区间内就行了，最后后半段可以写成这样
     *
     * min(max((n mod (i*10))?i+1,0),i)
     *
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution2(int n) {
        if (n == 0) return 0;
        int count = 0;
        //考虑到正好n是整十，例如1，10，所以必然要有等于
        for (long i=1;i<=n;i=i*10){
            long diviver = i*10;
            count += n/diviver*i + Math.min(Math.max(n%diviver-i+1,0),i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
        System.out.println(NumberOf1Between1AndN_Solution1(13));
        System.out.println(NumberOf1Between1AndN_Solution2(13));
    }
}
