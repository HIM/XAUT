package Arithmetic;
public class t3_2_diskbest {
    static void longFront(int n,double[] len,double[] a){
        //计算每个的时间
        double sum = 0;
        for(int i=0;i<n;i++){
            sum += a[i];
        }
        double[] tt = new double[n];
        for(int i=0;i<n;i++){
            tt[i] = (a[i]/sum)*len[i];  //每个的时间
        }
        double temp;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(tt[i]>tt[j]){
                    temp = tt[i];
                    tt[i] = tt[j];
                    tt[j] = temp;
                }
            }
        }
        double t = 0;
        double time;
        for(int i=0;i<n;i++){
            time = 0;
            for(int j=0;j<=i;j++){
                time += tt[j];
            }
            t += time;
        }
        System.out.print("平均读取时间为：");
        System.out.printf("%.2f",t);
    }
    public static void main(String[] args) {
        int n = 5;
        double[] len = {71,46,9,73,35};        //长度
        double[] a = {875,452,265,120,85};     //频次
        longFront(n,len,a);
    }
}
