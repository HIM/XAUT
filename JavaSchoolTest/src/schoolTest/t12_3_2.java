package schoolTest;

public class t12_3_2 extends Thread{
    int pauseTime;
    int speed;
    String name;

    public t12_3_2(int x,int s,String n){
        pauseTime = x;
        speed = s;
        name = n;
    }

    public void run(){
        int t = 1;
        while (t<10){
            try{
                System.out.println(name+"正在跑");
                t=t*speed+1;
                System.out.println(name+"正在睡觉");
                Thread.sleep(pauseTime);
            }catch (InterruptedException e){}
        }
        System.out.println(name+"已到达终点");
    }
    public static void main(String[] args) {
        t12_3_2 tortoise = new t12_3_2(0,1,"乌龟");
        tortoise.start();
        t12_3_2 rabbit = new t12_3_2(5000,3,"兔子");
        rabbit.start();
    }
}
