public class DoublyLinkedListTester {
    
    public static void main(String[] args) {
        Nucleotide[] list = new Nucleotide[10];
        DoublyLinkedList linkedlist = new DoublyLinkedList(list);
        linkedlist.add(null);
        System.out.println("\n\n" + list.toString());

    }
}
