public class Node{
  private int data;
  private Node next, prev;

  public Node(int val, Node previous){
    data = val;
    prev = previous;
    next = null;
  }
  public Node(int val){
    data = val;
    prev = next = null;
  }

  public int get(){
    return data;
  }

  public Node getNext(){
    return next;
  }
  public String toString(){
    return "" + get() + "\nPrev: " + prev + " Next " + getNext();
  }

}
