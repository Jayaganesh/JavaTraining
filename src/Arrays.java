import java.math.BigInteger;

public class Arrays {
    public static void main(String[] args) {
        // Declare Arrays
        // 1
        String[] names;
        names = new String[100];

        // 2
        String[] names1 = new String[100];


//        var names2 = new String[100];

        for (int i = 0; i < names.length; i++) {
            names[i] = "";
        }

//      ***  Array Construction ***

//        Arrays of numeric type (including char) are filled with zeroes.
//        Arrays of boolean are filled with false.
//        Arrays of objects are filled with null reference.

        // 1
        BigInteger[] numbers = new BigInteger[100];
        for (int i = 0; i < 100; i++)
            numbers[i] = BigInteger.valueOf(i);

        // 2
        int[] primes = { 2, 3, 5, 7, 11, 13 };

//        var primes = new int[]{2, 3, 5, 7, 11, 13};

        String[] authors = {
                "James Gosling",
                "Bill Joy",
                "Guy Steele",
        };

        primes = new int[] { 17, 19, 23, 29, 31 };
    }
}
