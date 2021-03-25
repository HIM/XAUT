import java.util.Scanner;
public class t5_4yundongyuan {
    private static int n;
    private static int[][] p,q;

    private static int[] r;
    private static int best;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (true){
            best = 0;

            n = input.nextInt();

            p = new int[n+1][n+1];
            q = new int[n+1][n+1];
            r = new int[n+1];

            for(int i=1; i<=n; i++)
                for(int j=1; j<=n; j++)
                    p[i][j] = input.nextInt();

            for(int i=1; i<=n; i++)
                for(int j=1; j<=n; j++)
                    q[i][j] = input.nextInt();

            for(int i=1; i<=n; i++)
                r[i] = i;

            backtrack(1);

            System.out.println(best);
        }
    }

    private static void backtrack(int t){
        if(t > n) compute();
        else
            for (int j=t; j<=n; j++){
                swap(r,t,j);
                backtrack(t+1);
                swap(r,t,j);
            }
    }

    private static void compute(){
        int temp = 0;
        for(int i=1; i<=n; i++)
            temp += p[i][r[i]] * q[r[i]][i];
        if(temp > best)
            best = temp;
    }

    private static void swap(int[] x, int i, int j){
        int tmp;
        tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }
}
