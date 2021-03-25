package schoolTest;

public class t7_3_1 {
    public static void main(String[] args) {
        String in = args[0];
        int n = 0;
        for(int i = 0 ; i < in.length() ; i ++){
            char a = in.charAt(i);
            if(a == 'a'){
                n++;
            }
        }
        System.out.println(n);
    }
}
