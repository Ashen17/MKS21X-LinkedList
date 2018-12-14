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
    System.out.println(list3.set(5, 8));
    System.out.println(list3.contains(2));
    System.out.println(list3.contains(90));
    System.out.println(list3.indexOf(0));
    System.out.println(list3.indexOf(5));
    MyLinkedList list4 = new MyLinkedList(2);
    System.out.println(list4.contains(-3));
    System.out.println(list4.contains(5));
    System.out.println(list.contains(1));

  }
}
