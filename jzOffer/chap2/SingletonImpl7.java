package jzOffer.chap2;

public class SingletonImpl7 {
    //用volatile保证线程可见性和指令重排序
    private static volatile SingletonImpl7 singletonImp;
    private SingletonImpl7(){
    }
    public static SingletonImpl7 getInstance(){
        if (null == singletonImp){
            synchronized(SingletonImpl7.class){
                if (null == singletonImp){
                    singletonImp = new SingletonImpl7();
                }
            }
        }
        return singletonImp;
    }
}
