public class Node{
  private int data;
  private Node next, prev;

  public Node(int val, Node previous){
    data = val;
    prev = previous;
    next = null;
    prev.LinkNext(this);
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
  private void LinkNext(Node nxt){
    next = nxt;
  }

  public String toString(){
    if (next == null && prev == null)
      return "" + get() + "\n isolated null";
    else if (prev == null)
      return "" + get() + "\n head " + getNext().get();
    else if (next == null)
      return "" + get() + "\n tail " + prev.get();
    return "" + get() + "\nPrev: "+ prev.get() + " Next " + getNext().get();
  }

}
