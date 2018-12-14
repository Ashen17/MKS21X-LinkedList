public class Node{
  private int data;
  private Node next, prev;

  public Node(int val, Node previous){
    data = val;
    prev = previous;
    next = null;
    prev.setNext(this);
  }
  public Node(int val){
    data = val;
    prev = next = null;
  }

  public int getData(){
    return data;
  }
  public int setData(int i){
    int save = data;
    data = i;
    return save;
  }

  public Node next(){
    return next;
  }
  public Node prev(){
    return prev;
  }
  public void setNext(Node nxt){
    next = nxt;
  }
  public void setPrev(Node prv){
    prev = prv;
  }

  public String toString(){
    /*
    if (next == null && prev == null)
      return "" + getData() + "\n isolated null";
    else if (prev == null)
      return "" + getData() + "\n head " + next().getData();
    else if (next == null)
      return "" + getData() + "\n tail " + prev.getData();
    return "" + getData() + "\nPrev: "+ prev.getData() + " next " + next().getData();
    */
    return "" + getData();
  }

}
