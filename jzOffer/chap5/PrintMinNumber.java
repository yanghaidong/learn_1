package jzOffer.chap5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class PrintMinNumber {
    /**
     * * 排序规则如下：
     *  * 若ab > ba 则 a > b，
     *  * 若ab < ba 则 a < b，
     *  * 若ab = ba 则 a = b；
     *  * 解释说明：
     *  * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int a : numbers){
            list.add(a);
        }
        //对list元素按照自定义的规则进行有小到大的排序，java8之lambda表达式，规则是比较连接后的元素大小
        list.sort((a, b)->(a+""+b).compareTo((b+""+a)));

        //另外一种写法
//        Collections.sort(list,new Comparator<Integer>(){
//
//            @Override
//            public int compare(Integer str1, Integer str2) {
//                // TODO Auto-generated method stub
//                String s1=str1+""+str2;f
//                String s2=str2+""+str1;
//
//                return s1.compareTo(s2);
//            }
//        });
        StringBuilder sb = new StringBuilder();
        for (int b : list){
            sb.append(b);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        int[] a = {3,32,321};
        System.out.println(PrintMinNumber(a));
    }
}
