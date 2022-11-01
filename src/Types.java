import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Types {
    public static void main(String[] args) {
//       *** Types ***

//        Type        Storage requirement     Range (inclusive)
//        byte        1 byte                  –128 to 127
//        short       2 bytes                 –32,768 to 32,767
//        int         4 bytes                 –2,147,483,648 to 2,147,483,647 (just over 2 billion)
//        long        8 bytes                 –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // grammer for declaring variable
        // type (int, float) [variable name] ?=values;
        // declare and assign
        byte b1; // declare a variable
        b1 = 121; // assign a value
        byte b2 = 34; // declare and assign
        System.out.println("b1 and b2 values are: " + b1 + " " + b2);

        short s1;
        s1 = 12134;
        short s2 = 3344;
        System.out.println("s1 and s2 values are: " + s1 + " " + s2);

        int i1;
        i1 = 12134;
        int i2 = 3344;
        System.out.println("i1 and i2 values are: " + i1 + " " + i2);

        long l1;
        l1 = 12134;
        long l2 = 3344;
        System.out.println("l1 and l2 values are: " + l1 + " " + l2);

//        float         4 bytes         Approximately ±3.40282347E+38F (6–7 significant decimal digits)
//        double        8 bytes         Approximately ±1.79769313486231570E+308 (15 significant decimal digits)

        System.out.println(1234343434.00 * 343434343434.00);

        float f1;
        f1 = 12134.00f;
        float f2 = 3344.00f;
        System.out.println("f1 and f2 values are: " + f1 + " " + f2);

        double d1;
        d1 = 12134.00;
        double d2 = 3344.00;
        System.out.println("d1 and d2 values are: " + d1 + " " + d2);


//        *** Variable Declarations ***

//        old way
        // type v_name1, v_name2
        int total1 = 0;
        int total2 = 0, count;

        //        new way Java 11
        var total3 = 0;


        //d34343

//        *** Identifiers ***
//        In Java, an identifier must begin with a letter, or _, or $.
//        It can consist of any letters, digits, and the symbols _ and $. However,
//        the $ symbol is intended for automatically generated identifiers,
//        and you should not use it. Finally, the _ by itself is not a valid identifier.

//        *** Initialization ***
        int count1;
//        count1++; // Error—uses an uninitialized variable

//        int count2, total4 = 0;
//        if (total4 == 0) {
//            count2 = 0;
//        } else {
//            count2++; // Error—count might not be initialized
//        }

        var in = new Scanner(System.in); // See Section 1.6.1 for reading input
        System.out.println("How old are you?");
        int age = in.nextInt();

//        *** Constants ***
        // final type v_name = value
        final int DAYS_PER_WEEK = 7;

        final int DAYS_IN_FEBRUARY;
        boolean leapYear = true;
        if (leapYear) {
            DAYS_IN_FEBRUARY = 29;
        } else {
            DAYS_IN_FEBRUARY = 28;
        }


//        *** Arithmetic Operations ***
//        Operators
//          [] . () (method call)
//          ! ~ ++ -- + (unary) - (unary) () (cast) new
//          * / % (modulus)
//          + -
//          << >> >>> (arithmetic shift)
//          < > <= >= instanceof
//          == !=
//          & (bitwise and)
//          ^ (bitwise exclusive or)
//          | (bitwise or)
//          && (logical and)
//          || (logical or)
//          ? : (conditional)
//          = += -= *= /= %= <<= >>= >>>= &= ^= |=

//        *** Number Type Conversions *** Narrow to wider
//        3.14 + 42
//        'J' + 1
//        double x = 42;
//        float f = 123456789; // conversions may lose information

        // cast
        double x = 3.75; // wider
        int n = (int) x; // narrow

        int n1 = 1;
        char next = (char) ('J' + n1); // Converts 75 to 'K'

//        *** Relational (gt, ge, lt, le) and Logical (and, or, not) Operators ***
        int length = 1;
//        0 <= n && n < length // cond1 && cond2
        int s = 10;
//        n != 0 && s + (100 - s) / n < 50  //Short circuit evaluation
//        n == 0 || s + (100 - s) / n >= 50
        int time = 13;
//        time < 12 ? "am" : "pm"  // conditional operator (syntax: condition ? if condition succeed : if condition fails)

//        *** Big numbers ***
        BigInteger n4 = BigInteger.valueOf(876543210123456789L);
        var k = new BigInteger("9876543210123456789");

        BigDecimal.valueOf(17, 1);

        //        *** Strings ***
        String location = "Java";
        String greeting = "Hello " + location;
        System.out.println(greeting);

        int age1 = 42;
        String output = age1 + " years";
        System.out.println(output);

        String names = String.join(", ", "Peter", "Paul", "Mary");

//        *** Control Flow ***
//        Branches
        //        if condition
        int count2 = 9;
        if (count2 > 0) {
            double average = 34 / 4;
            System.out.println(average);
        }

        //        if else condition
        if (count2 > 0) {
            double average = 34 / 4;
            System.out.println(average);
        } else {
            System.out.println(0);
        }

        //        if, else if, else condition
        if (count2 > 0) {
            double average = 45 / 2;
            System.out.println(average);
        } else if (count2 == 0) {
            System.out.println(0);
        } else {
            System.out.println("Huh?");
        }

//        Switches
        int seasonCode = 0;
        String seasonName = switch (seasonCode) { // switch expression
            case 0 -> "Spring";
            case 1 -> "Summer";
            case 2 -> "Fall";
            case 3 -> "Winter";
            default -> {
                System.out.println("???");
                yield "";
            }
        };

        switch (seasonCode) { // switch statement
            case 0 -> seasonName = "Spring";
            case 1 -> seasonName = "Summer";
            case 2 -> seasonName = "Fall";
            case 3 -> seasonName = "Winter";
            default -> {
                System.out.println("???");
                seasonName = "";
            }
        }

//        Each case can have multiple labels, separated by commas
        int numLetters = switch (seasonName) {
            case "Spring", "Summer", "Winter" -> 6;
            case "Fall" -> 4;
            default -> throw new IllegalArgumentException();
        };

//        fall-through variant
        int numLetters1 = switch (seasonName) { // switch expression with fall-through
            case "Spring":
                System.out.println("spring time!");
            case "Summer", "Winter": yield 6;
            case "Fall":
                yield 4;
            default:
                throw new IllegalArgumentException();
        };

        switch (seasonName) { // switch statement with fall-through
            case "Spring":
                System.out.println("spring time!");
            case "Summer", "Winter":
                numLetters1 = 6;
                break;
            case "Fall":
                numLetters1 = 4;
                break;
            default:
                throw new IllegalArgumentException();
        }

//        Loops
        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }

//        1. i = 1, 1 <= 20, execute syatment, i = 2
//        2. 2 < = 20, execute syatment, i = 3


        int i = 1;
        while (i <= 20) {
            i++;
            System.out.println(i);
        }

        for (i = 1; i <= 3; i++); // Uses existing variable i
        for (int i3 = 0, j = n - 1; i3 < j; i1++, j--); // initialize multiple variables, multiple updates, separated by commas


        for (;;) {
            if (i > 20)
                break;
        }

//        Breaking and Continuing
        // loop and half
//        var done = false;
//        while (!done) {
//            String input = in.next();
//            if ("Q".equals(input)) {
//                done = true;
//            } else {
////                Process input
//            }
//        }

//        while (true) {
//            String input = in.next();
//            if ("Q".equals(input)) break; // Exits loop
////            Process input
//        }
          // break jumps here

//        for (int i4 = 1; i4 <= 5; i++) {
//            int input = in.nextInt();
//            if (n < 0) continue; // Jumps to i++
////            Process input
//        }

//        {
//            {
//                break;
//            }
//        }


//        Label break
//        outer:
//        while (...) {
//    ...
//            inner:
//            while (...) {
//        ...
//                if (...) break outer;
//       ...      else break inner;
//            }
//     ...
//        }
//// Labeled break jumps here
    }
}
