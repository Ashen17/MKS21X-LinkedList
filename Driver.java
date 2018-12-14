public class Driver{
  public static void main(String[] args) {
    Node one = new Node(3);
    System.out.println(one);
    Node two = new Node(7, one);
    System.out.println(two);
    MyLinkedList list = new MyLinkedList();
    System.out.println(list);
    System.out.println(list.add(1));
    System.out.println(list);
    /*
    MyLinkedList list2  = new MyLinkedList(one, two);
    System.out.println(list2);
    */
    MyLinkedList list3 = new MyLinkedList(10);
    System.out.println(list3);
    //System.out.println(list3.getNthNode(4).getData());
    System.out.println(list3.get(9));
    System.out.println(list3.set(4, 8));
  }
}
