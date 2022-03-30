package prodsmile.test;


public class AtomicTest {


    void init(Integer[][] A, int n, int value) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = value;
            }
        }
    }

    int sum(int n){
        var r = 0;
        for(var i = 1; i <= n; i++) {
            r+=i;
        }

        return r;
    }

    int f(int n) {
        if(n==1) {
            return 1;
        }
        return f(n/2);
    }

    public static void main(String[] argv)  {
        var test = new AtomicTest();
        System.out.println(test.f(100000000));
    }
}
