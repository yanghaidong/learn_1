package jzOffer.chap2;

public class singleTon {
    private singleTon(){
    }
    private volatile static jzOffer.chap2.singleTon singleTon;

    public synchronized static jzOffer.chap2.singleTon getInstance(){
        if (singleTon == null){
            synchronized (jzOffer.chap2.singleTon.class){
                if (singleTon == null){
                    return new singleTon();
                }
            }
        }
        return singleTon;
    }
    
    public static void main(String[] args) {
        System.out.println(jzOffer.chap2.singleTon.getInstance());
    }
}
