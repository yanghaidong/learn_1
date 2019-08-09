package jzOffer.practice;

import java.util.Scanner;

public class ShiliuToShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String n = sc.nextLine();
            int num = Integer.decode(n);
//            int num = Integer.parseInt(n.substring(2),16);
            System.out.println(num);
        }
        /**
         * 自己转化
         */
        while (sc.hasNextLine()){
            String s = sc.nextLine().substring(2);
            int sum = 0;
            for (int i=0;i<s.length();i++){
                char m = s.charAt(i);
                int num = m >= 'A' ? m - 'A' + 10 : m - '0';
                sum += Math.pow(16,s.length() - 1 - i)*num;
            }
            System.out.println(sum);
        }
    }
}
