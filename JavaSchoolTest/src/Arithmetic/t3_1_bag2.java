package Arithmetic;

public class t3_1_bag2 {

    static void valueMax(int[] w,int[] v){
        int capacity = 150;
        int nowBag = 0;
        double nowValue = 0;
        int n = w.length;
        int[] x = new int[n];
        int[] vv = new int[n];
        for(int i=0;i<n;i++){
            vv[i] = v[i];
            x[i] = i;
        }
        int temp = 0;
        int a = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(vv[i]<vv[j]){
                    temp = vv[i];
                    vv[i] = vv[j];
                    vv[j] = temp;
                    a = x[i];
                    x[i] = x[j];
                    x[j] = a;
                }
            }
        }

        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for(int i=0;i<n;i++){
            w1[i] = w[x[i]];
            v1[i] = v[x[i]];
        }


        for(int i=0;i<n;i++){
            if (nowBag+w1[i]<=capacity){
                nowBag += w1[i];
                nowValue += v1[i];
            }
            if (nowBag+w1[i]>capacity){
                int last = capacity - nowBag;
                nowValue += (double) (v1[i]/w1[i])*last;
                break;
            }
        }
        System.out.println("按价值最大装，得到价值："+nowValue);
    }
    static void weightMin(int[] w,int[] v){
        int nowBag = 0;
        double nowValue = 0;
        int n = w.length;
        int capacity = 150;
        int[] x = new int[n];
        int[] ww = new int[n];
        for(int i=0;i<n;i++){
            ww[i] = w[i];
            x[i] = i;
        }
        int temp = 0;
        int a = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(ww[i]>ww[j]){
                    temp = ww[i];
                    ww[i] = ww[j];
                    ww[j] = temp;
                    a = x[i];
                    x[i] = x[j];
                    x[j] = a;
                }
            }
        }

        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for(int i=0;i<n;i++){
            w1[i] = w[x[i]];
            v1[i] = v[x[i]];
        }

        for(int i=0;i<n;i++){
            if (nowBag+w1[i]<=capacity){
                nowBag += w1[i];
                nowValue += v1[i];
            }
            if (nowBag+w1[i]>capacity){
                int last = capacity - nowBag;
                nowValue += (double) (v1[i]/w1[i])*last;
                break;
            }
        }
        System.out.println("按重量最小装，得到价值："+nowValue);
    }

    static void bestMax(int[] w,int[] v){
        int capacity = 150;
        int nowBag = 0;
        double nowValue = 0;
        int n = w.length;
        int[] x = new int[n];
        double[] best = new double[n];
        for(int i=0;i<n;i++){
            best[i] = (double) v[i]/w[i];
            x[i] = i;
        }
        double temp = 0;
        int a = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(best[i]<best[j]){
                    temp = best[i];
                    best[i] = best[j];
                    best[j] = temp;
                    a = x[i];
                    x[i] = x[j];
                    x[j] = a;
                }
            }
        }

        double[] w1 = new double[n];
        double[] v1 = new double[n];
        for(int i=0;i<n;i++){
            w1[i] = (double)w[x[i]];
            v1[i] = (double)v[x[i]];
        }



        for(int i=0;i<n;i++){
            if(nowBag+w1[i]<=capacity){
                nowBag += w1[i];
                nowValue += v1[i];
            }
            if (nowBag+w1[i]>capacity){
                double last = capacity - nowBag;
                nowValue += (v1[i]/w1[i])*last;
                break;
            }
        }
        System.out.println("按价值重量比最大装，得到价值："+nowValue);
    }
    public static void main(String[] args) {
        int[] w = {35,30,60,50,40,10,25};
        int[] v = {10,40,30,50,35,40,30};
        valueMax(w,v);
        weightMin(w,v);
        bestMax(w,v);
    }
}
