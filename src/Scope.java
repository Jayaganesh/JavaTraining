public class Scope {
    public static void main(String[] args) {
//        Local Variable Scope
//        while (...) {
//            System.out.println(...);
//            String input = in.next(); // Scope of input starts here
//    ...
//            // Scope of input ends here
//        }

//        public static void main(String[] args) { // Scope of args starts here
//    ...
//            // Scope of args ends here
//        }

//        int count = 0;
//        int next;
//        do {
//            next = generator.nextInt(10);
//            count++;
//        } while (next != target);
//
//        for (int i = 0; i < n; i++) { // i is in scope for the test and update
//    ...
//        }
          // i not defined here
    }
//
//      int i;
//      for (i = 0; !found && i < n; i++) {
//       ...
//      }
//      i still available

//    overlapping scopes
//int i = 0;
//while (...) {
//        String i = in.next(); // Error to declare another variable i
//    ...
//    }

//    for (int i = 0; i < n / 2; i++) { ... }
//for (int i = n / 2; i < n; i++) { ... } // OK to redefine i
}
