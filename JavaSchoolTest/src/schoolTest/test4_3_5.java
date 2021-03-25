package schoolTest;
import java.util.Scanner;
public class test4_3_5 {
	private static boolean isPrime(int n) {
		if (n==2) {
			return true;
		}
		if(n<2){
			return false;
		}
		//n开方+1
		double max=Math.sqrt(n)+1;  //质数算式
		//在2到max范围，找到能把n整除的值
		for (int i = 2; i < max; i++) {
			if (n%i==0) {
				//n不是质数
				return false;
			}
		}
		return true;  //n是质数

	}
	public static void main(String[] args) {
		System.out.println("请输入一个偶数：");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=3;i<n/2;i+=2) {
			int j=n-i;
			if(isPrime(i)&&isPrime(j)) {
				System.out.println(n+"="+i+"+"+j);
			}
		}
		
	}
}
