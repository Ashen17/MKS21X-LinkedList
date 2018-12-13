public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList(){
    size = 0;
    start = end = null;
  }

  //public MyLinkedList()

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
    result += start.get();
    Node next = start.getNext();
    for (int i = 1; i < size; i++){
      result += next.get();
      next = next.getNext();
    }
    return result + "]";
  }

}
