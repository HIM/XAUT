package Arithmetic;
import java.util.*;
public class DCcourse {
    static void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortArr(int[] arr,int a,int b){
        for(int i=a;i<b;i++){
            for(int j=i+1;j<=b;j++){
                if(arr[i]<arr[j])
                    swap(arr,i,j);
            }
        }
    }
    //找中位数的中位数
    static int Median(int[] arr,int a,int b){
        if(a==b)
            return a;
        int i=0;
        int n=0;
        for(i=a;i<b-5;i+=5){
            sortArr(arr,i,i+4);
            n = i - a;
            swap(arr,a+n/5,i+2);
        }

        //下面是剩余的数
        int last = b-i+1;
        if(last>0){
            sortArr(arr,i,i+last-1);
            n = i - a;
            swap(arr,a+n/5,i+last/2);
        }

        n/=5;
        if(n==a)
            return a;
        return Median(arr,a,a+n);
    }
    //划分
    static int Divide(int[]arr,int a,int b,int m){
        swap(arr,m,a);
        int i = a;
        int j = b;
        int flag = arr[a];
        while (i<j){
            while (arr[j]<=flag && i<j)
                j--;
            arr[i] = arr[j];
            while (arr[i]>=flag && i<j)
                i++;
            arr[j] = arr[i];
        }
        arr[i] = flag;
        return i;
    }

    static int SelectK(int[] arr,int a,int b,int k){
        int m = Median(arr,a,b);
        int i = Divide(arr,a,b,m);

        int x = i-a+1;
        if(x==k)
            return arr[i];
        if(x>k)
            return SelectK(arr,a,i-1,k);
        return SelectK(arr,i+1,b,k-x);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要求的第k大的k：");
        int k = in.nextInt();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,100,99,98,97,96,95,94,93,92,91,
        90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,
        53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26};
//        System.out.println(arr.length);
        System.out.println("第"+k+"大为："+SelectK(arr,0,arr.length-1,k));
    }
}


