package Arithmetic;

public class doubleDSort {

    static int n = 0;

    static void merge(int[] arr,int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while (i<=mid&&j<=right){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
                n++;
            }
        }
        while (i<=mid){
            temp[k++] = arr[i++];
            n++;
        }
        while (j<=right){
            temp[k++] = arr[j++];
        }
        for(int a=0;a<temp.length;a++){
            arr[a+left] = temp[a];
        }
    }

    static void MergeSort(int[] arr,int left,int right){
        int mid = (left + right)/2;
        if(left<right){
            MergeSort(arr,left,mid);
            MergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,6,1,5,3,8,4,7};
        MergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("共交换了"+n+"次");
    }
}
