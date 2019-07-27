package jzOffer.chap4;
import java.util.ArrayList;
import java.util.List;

/**
 * 求字符的所有组合,允许组合中有重复元素
 */
public class combination {

    /**
     * 其实就是求C(n, m) 其中n == str.length; m == num
     *
     * @param str 字符序列
     * @param num 选几个字符进行组合
     * @return C(n, m)的集合
     */
    public List<String> combinationAccordingToNum(String str, int num) {
        List<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0 || num > str.length()){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        collect(str, num , sb , list);
        return list;
    }

    /**
     * 求所有组合
     * @param str
     * @return
     */
    public List<String> combination(String str){
        List<String> list = new ArrayList<>();
        if (str == null || str.length() == 0){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        //1到字符长度的所有单位
        for (int i=1;i<=str.length();i++){
            collect(str, i , sb, list);
        }
        return list;
    }
    private void collect(String str, int num, StringBuilder sb, List<String> list) {
        //还剩下0位，到达最后一位，结束
        // 两个if顺序不可交换，否则C(n, n)不会存入到list中：即collect("", sb, 0)时，要先判断num==0存入后，再判断str.length ==0决定不再递归
        if (num == 0){
            //字符已经去重
            list.add(sb.toString());
            return;
        }
        //// 当str为""时候直接返回，不然下一句charAt(0)就会越界
        if (str.length() == 0){
            return;
        }

        // 公式C(n, m) = C(n-1, m-1)+ C(n-1, m)
        // 第一个字符是组合中的第一个字符，在剩下的n-1个字符中选m-1个字符
        sb.append(str.charAt(0));
        collect(str.substring(1), num-1, sb , list);
        // 第一个字符不是组合中的第一个字符，在剩下的n-1个字符中选m个字符
        sb.deleteCharAt(sb.length()-1);  //取消选中的第一个字符
        collect(str.substring(1), num, sb , list);

    }
    public static void main(String[] args) {
        combination c = new combination();
        System.out.println(c.combination("abcca"));
        System.out.println(c.combination("abc"));
        System.out.println(c.combinationAccordingToNum("aabbc", 2));
    }
}
