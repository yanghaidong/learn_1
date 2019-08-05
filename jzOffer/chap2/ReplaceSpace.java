package jzOffer.chap2;

public class ReplaceSpace {
    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    /**
     * 遍历逐一替换
     * @param str
     * @return
     */
    public String replaceSpace2(StringBuffer str) {
        if (str == null || str.length() ==0){
            return null;
        }
        for (int i=0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    /**
     * 运用stringbuffer可以原地修改的特性
     * 先构造加上空格位置的新长度
     * 然后从最后一位开始往后移
     * 遇到空格则开始设置新字符
     * 直到字符结束
     * @param str
     * @return
     */
    public String replaceSpace4(StringBuffer str) {
        if (str == null || str.length() ==0){
            return null;
        }
        int oldP = str.length()-1;
        int spaceNumber = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                spaceNumber++;
            }
        }
        int newP = oldP + 2*spaceNumber;
        str.setLength(newP+1);
        //保证新字符串指针大于等于旧指针
        while (oldP >= 0 && newP > oldP ){
            if (str.charAt(oldP) != ' '){
                str.setCharAt(newP,str.charAt(oldP));
                oldP--;
                newP--;

            }else {
                str.setCharAt(newP--,'0');
                str.setCharAt(newP--,'2');
                str.setCharAt(newP--,'%');
                oldP--;
            }
        }
        return str.toString();
    }
    /**
     * 库函数
     * @param str
     * @return
     */
    public String replaceSpace3(String str) {
        return str.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace2(new StringBuffer("We Are Happy")));
        System.out.println(rs.replaceSpace3("We Are Happy"));
        System.out.println(rs.replaceSpace4(new StringBuffer("We Are Happy")));

    }
}
