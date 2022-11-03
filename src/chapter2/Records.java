package chapter2;

public class Records {
//
//    record Point(double x, double y) {
//    };

//    1. record var is final
//    2. canonical, custom, compact

//    record Point(double x, double y) {
//        public Point() {
//            this(0, 0);
//        }
//    };
    record Range(int from, int to) {
//        public Range(int from, int to) {
//            if (from <= to) {
//                this.from = from;
//                this.to = to;
//            } else {
//                this.from = to;
//                this.to = from;
//            }
//        }
        public Range {
            if (from > to) {
                int temp = from;
                from = to;
                to = temp;
            }
        }
}

    }
