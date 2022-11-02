public class Main {
    public static void main(String[] args) throws Exception {

//        var list = new List();
//        list.addItem(3);
//        list.addItem(4);

//        var myInvoice = new Invoice();
//        myInvoice.add(new Invoice.Item("Blackwell Toaster", 2, 19.95));
//        myInvoice.add(new Invoice.Item("Some", 3, 21.00));
//        myInvoice.display();


        var myFace = new Network();
        Network.Member fred = myFace.enroll("Fred");
        System.out.println(fred);
        System.out.println(myFace.members);
        fred.deactivate();
        System.out.println(fred);
        System.out.println(myFace.members);
    }
}
