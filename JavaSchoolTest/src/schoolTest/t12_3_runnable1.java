package schoolTest;

class Number implements Runnable{
    int n;
    public void run(){
        //while (true){
        n = (int)(Math.random()*10);
        System.out.println(Thread.currentThread().getName()+":"+n);
        //}
    }
}

public class t12_3_runnable1 {
    public static void main(String[] args) {
        Number num1 = new Number();
        Number num2 = new Number();
        Number num3 = new Number();
        Number num4 = new Number();
        Number num5 = new Number();
        Number num6 = new Number();
        Thread n1 = new Thread(num1);
        Thread n2 = new Thread(num2);
        Thread n3 = new Thread(num3);
        Thread n4 = new Thread(num4);
        Thread n5 = new Thread(num5);
        Thread n6 = new Thread(num6);

        n1.setName("n1");
        n2.setName("n2");
        n3.setName("n3");
        n4.setName("n4");
        n5.setName("n5");
        n6.setName("n6");

        n1.start();
        n2.start();
        n3.start();
        n4.start();
        n5.start();
        n6.start();
    }
}
