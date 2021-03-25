package schoolTest;

public class t7_3_4 {
    public static void main(String[] args) {
        int sum = 0;
        int n = 0;
        String str = new String("Java is an Object Oriented programming language");
        String[] s=str.split(" ");
        for (int i = 0; i < s.length; i++) {
            sum += s[i].length();
            n++;
            System.out.print(s[i] + " ");
        }
        System.out.println("平均字母数："+ sum/n);
    }
}
