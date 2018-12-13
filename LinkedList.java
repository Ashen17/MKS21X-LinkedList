public class LinkedList {
  private int size;
  private Node start, end;

  public int size(){
    return size;
  }
  public boolean add(int value){
    return true;
  }

  public String toString(){
    String result = "[";
    result += start.get();
    Node next = start.getNext();
    for (int i = 0; i < size; i++){
      result += next.get();
      next = next.getNext();
    }
    return result;
  }

}
