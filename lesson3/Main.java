package lesson3;

public class Main {
    public static void main(String[] args) {
        
        metodReverseLinkedlist list = new metodReverseLinkedlist();

        list.add(6);
        list.add(0);
        list.add(7);
        list.add(-2);
        list.add(4);

        list.print();
        list.reverse();
        list.print();
    }
}