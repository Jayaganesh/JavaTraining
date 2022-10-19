public class Function {
    public static void main(String[] args) {
        double a = 12.00;
        double b = 24.00;
        double result = average(a, b);
        System.out.println(result);
        double avg = average(3, 4.5, -5, 0);
        double[] scores = { 3, 4.5, -5, 0 };
        double avg1 = average(scores);
    }

    public static double average(double x, double y) {
        double sum = x + y;
        return sum / 2;
    }

    public static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static int[] firstLast(int[] values) {
        if (values.length == 0) return new int[0];
        else return new int[] { values[0], values[values.length - 1] };
    }

    public static double average(double... values) {
        double sum = 0;
        for (double v : values) sum += v;
        return values.length == 0 ? 0 : sum / values.length;
    }
}
