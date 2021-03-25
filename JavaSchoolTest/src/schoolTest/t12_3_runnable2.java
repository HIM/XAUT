package schoolTest;

class MyThread implements Runnable {
    private String name;
    private Thread mythread;
    public MyThread(String name) {
        super();
        this.name = name;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + name + "运行" + i);
        }
        System.out.println("线程" + name + "结束");
    }
    public void start() {
        System.out.println("线程开始： " + name);
        if (mythread == null) {
            mythread = new Thread(this, name);
            mythread.start();
        }
    }
}

public class t12_3_runnable2 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("T1");
        t1.start();
        MyThread t2 = new MyThread("T2");
        t2.start();
    }
}
