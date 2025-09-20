public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long res = 0;
        long pow = 1;
        long control = 1;

        while (((long) x % control) != (long) x) {
            control *= 10;
        }

        control /= 10;

        while (((long) x % pow) != (long) x) {
            long temp = ((long) x % (pow * 10L) - (long) x % pow) / pow;
            res += (long) temp * control;
            control /= 10;
            pow *= 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) res;
    }
}
