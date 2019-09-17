package algorithm;

public class Fibonacci {

    private int n3 = 0;
    private int n2 = 0;
    private int n1 = 0;

    /**
     * 피보나치 수열을 구현한다.
     * 최적으로 알고리즘을 작성한다.
     * n는 몇번째까지의 피보나치 수열값을 구하는지에 대한 파라미터
     * 리턴값은 n까지의 피보나치 수열의 값이다.
     * @param n
     * @return
     */
    private int fibo(int n) {
        if(n == 2 || n == 1) return 1;
        if(n3 == 0) {
            // n2 = fibo(n-1) + fibo(n-2);
            n2 = fibo(n-1);
            n1 = fibo(n-2);
            n3 = n2 + n1;
            // System.out.println("n3 : " + n3 + ", n2 : " + n2 + ", n1 : " + n1 +", n : " + n);
            return n3;
        } else {
            // ex)  f(5)를 계산할때,f(5) = f(4) + f(3)인데,
            //      f(3)은 이전에 계산을 하여 else로 오게 된다. 
            //      이때, n2는 f(4)이고 n1은 f(2)이다.
            //      f(4)는 f(3) + f(2) 즉, f(3) + f(2) - f(2)는 f(3)이므로 
            //      f(5)는 f(4)와 f(3)의 합으로 나타낼 수 있으므로 n2-n1으로 반환해준다
            return n2-n1;
        }

    }

    public void solution(int n) {
        n3 = 0;
        n2 = 0;
        n1 = 0;

        System.out.println(fibo(n));
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.solution(10);
        f.solution(9);
        f.solution(8);
        f.solution(7);
        f.solution(6);
        f.solution(5);
        f.solution(4);
        f.solution(3);
        f.solution(2);
        f.solution(1);
    }
}