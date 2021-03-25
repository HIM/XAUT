package schoolTest;

public class t12_3_1 extends Thread{
    int pauseTime;
    String name;

    public t12_3_1(int x,String n){
        pauseTime = x;
        name = n;
    }
    public void run(){
        try{
            for(int i=1;i<7;i++){
                System.out.println(name+": 第"+i+"遍");
                Thread.sleep(pauseTime);
            }
        }catch (InterruptedException e){ }
    }

    public static void main(String[] args) {
        t12_3_1 p1 = new t12_3_1(1000,"P1");
        p1.start();
        t12_3_1 p2 = new t12_3_1(2000,"P2");
        p2.start();
        t12_3_1 p3 = new t12_3_1(3000,"P3");
        p3.start();
    }
}