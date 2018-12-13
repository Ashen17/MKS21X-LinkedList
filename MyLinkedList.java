import java.util.Random;

public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList(){
    size = 0;
    start = end = null;
  }
  /*
  public MyLinkedList(Node first, Node last){
    start = first;
    end = last;
    size = findSize(first, last);
  }
  private int findSize(Node first, Node last){
    int result = 0;
    Node current = first;
    while (current != last){
      current = current.next();
      result++;
    }
    return result + 1;
  }
  */

  public MyLinkedList(int s){
    size = s;
    Random seed = new Random(132);
    Node first = new Node(5);
    start = end = first;
    for (int i = 0; i < s; i++){
      this.add(seed.nextInt()%10);
      size--;
    }
  }
  public Node getNthNode(int index){
    Node current = start;
    for (int i = index - 1; i > 0; i--){
      current = current.next();
    }
    return current;
  }
  public int get(int index){
    return getNthNode(index).getData();
  }

  public int size(){
    return size;
  }
  public boolean add(int value){
    if (size == 0) {
      Node last = new Node(value);
      start = end = last;
    }
    else {
      Node last = new Node(value, end);
      end = last;
    }
    size++;
    return true;
  }

  public String toString(){
    if (size == 0){return "[]";}
    String result = "[";
    result += start.getData();
    Node next = start.next();
    for (int i = 1; i < size; i++){
      result += ", " + next.getData();
      next = next.next();
    }
    return result + "]";
  }

}
