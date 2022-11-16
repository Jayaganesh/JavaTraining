import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

//        var list = new chapter2.List();
//        list.addItem(3);
//        list.addItem(4);

//        var myInvoice = new chapter2.Invoice();
//        myInvoice.add(new chapter2.Invoice.Item("Blackwell Toaster", 2, 19.95));
//        myInvoice.add(new chapter2.Invoice.Item("Some", 3, 21.00));
//        myInvoice.display();


//        var myFace = new Network();
//        Network.Member fred = myFace.enroll("Fred");
//        System.out.println(fred);
//        System.out.println(myFace.members);
//        fred.deactivate();
//        System.out.println(fred);
//        System.out.println(myFace.members);


        List list = new ArrayList();
        list.add("jg");
        List list2 = new ArrayList();
        list2.add(1);
        list2.add("jg");
//        for (Object l : list2) {
//            String l1 = (String) l;
//            System.out.println(l);
//        }
        System.out.println(list2);
        System.out.println(list);


        Object[] str = {"jg1", "jg2", 1};
        Arrays.stream(str).forEach(e -> System.out.println(e));

        List<Integer> ints = Arrays.asList(1, 2, 3);

//        List<Number> is a not subclass of List<Integer>
        //        Number[] is a subclass of Integer[]

        Number[] nums = {1, 2,3};




    }
}
