package schoolTest;

public class t7_3_5 {
    public static void main(String[] args) {
        int max = 90, min = 10 , x , flag;
        StringBuffer str = new StringBuffer();
        int[] arr = new int[20];
        for(int i=0 ; i<20 ; i++){
            x = (int)(Math.random()*(max - min) + min);
            arr[i] = x;
            flag = 0;
            while(flag == 0){
                flag = 1;
                for(int j=0;j<i;j++){
                    if(arr[j]==arr[i]){
                        flag = 0;
                    }
                }
                if(flag == 0){
                    x = (int)(Math.random()*(max - min) + min);
                    arr[i] = x;
                }
            }
            str.append(x);
            str.append(",");
        }
        System.out.println(str);
        String st = new String(str);
        String[] s = st.split(",");     //接下来开始排序
        int[] Arr = new int[20];
        for (int i = 0; i < s.length; i++) {
            Arr[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < Arr.length - 1; i++) {
            for(int j = i + 1 ;j < Arr.length ; j++){
                if(Arr[i] > Arr[j]){
                    int temp = Arr[i];
                    Arr[i] = Arr[j];
                    Arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            System.out.print(Arr[i] + " ");
        }
    }
}
