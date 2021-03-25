package Arithmetic;

public class t2_2_maxSbuArr {
    static int MaxSub(int[] n){
        int sum = 0;
        int b = 0;
        for(int i=0;i<n.length;i++){
            if(b>0){
                b += n[i];
            }else {
                b = n[i];
            }
            if(b>sum){
                sum = b;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] n = {5,-1,3,-5,4,5,-2,4,3,-1};
        System.out.println("最大子段和为："+MaxSub(n));
    }
}
