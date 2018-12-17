//import java.util.Random;//here for testing purposes

public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList(){
    size = 0;
    start = end = null;
  }
  /*
  public MyLinkedList(Node first, Node last){//here for testing purposes
    start = first;
    end = last;
    size = findSize(first, last);
  }
  private int findSize(Node first, Node last){//here for testing purposes
    int result = 0;
    Node current = first;
    while (current != last){
      current = current.next();
      result++;
    }
    return result + 1;
  }
  */
/*
  public MyLinkedList(int s){ //here for testing purposes
    size = s;
    Random seed = new Random(130);
    Node first = new Node(5);
    start = end = first;
    for (int i = 0; i < s; i++){
      this.add(seed.nextInt()%10);
      size--;
    }
  }
  */
  private Node getNthNode(int index){
    if (index < 0){throw new IndexOutOfBoundsException();}
    try {
      Node current = start;
      for (int i = index; i > 0; i--){
        current = current.next();
      }
      return current;
    }
    catch (NullPointerException E){//when it assigns current as end.next() the index is too large.
      throw new IndexOutOfBoundsException();
    }
  }
  public Integer get(int index){
    return getNthNode(index).getData();
  }
  public Integer set(int index, Integer value){
    try{
      Node save = getNthNode(index);
      Integer store = save.getData();
      save.setData(value);
      return store;
    }
    catch (NullPointerException E){
      throw new IndexOutOfBoundsException();
    }
  }
  public int size(){
    return size;
  }
  public boolean add(int value){
    if (size == 0) {
      Node last = new Node(value);//seperate instantiation, since an empty list doesnt have an end
      start = end = last;
    }
    else {
      Node last = new Node(value, end);//using this constructor seemed better than starting with the other node construcor, and continuing off that
      end = last;
    }
    Node last = new Node(value);
    size++;
    return true;
  }

  public void add(int index, Integer value){
    try {
      Node Current = new Node(value);
      if (index == 0){
        start.setPrev(Current);
        Current.setNext(start);
        start = Current;
        size++;
      }
      else if (index == size){add(value);}
      else {//for everything in between 0 and size,exclusive
        Node After = getNthNode(index);
        Node Before = After.prev();
        Current.setNext(After);
        Current.setPrev(Before);
        Before.setNext(Current);
        After.setPrev(Current);
        size++;
      }
  }
  catch (NullPointerException E){//if not between 0 and size, incusive
    throw new IndexOutOfBoundsException();
  }
  }

  public boolean contains(Integer value){
    Node current = start;
    for (int i = 0; i < size; i++, current = current.next()){
      if (current.getData() == value){
        return true;
      }
    }
    return false;
  }
  public int indexOf(Integer value){
    Node current = start;
    for (int i = 0; i < size; i++, current = current.next()){
      if (current.getData() == value){
        return i;
      }
    }
    return -1;
  }
  public Integer remove(int index){
    Node Current = getNthNode(index);//this also handles IndexOutOfBoundsException 
    Node After = Current.next();
    Node Before = Current.prev();
    if (index > 0){Before.setNext(After);}
    else {start = After;}//if index == 0, negatives are covered by the getNthNode
    if (index < size() - 1){After.setPrev(Before);}
    else {end = Before;}//if index exactly size() - 1, size() or greater are covered by getNthNode
    size--;
    return Current.getData();
  }

  public boolean remove(Integer value){
    if (indexOf(value) == -1){return false;}
    Node After = getNthNode(indexOf(value)).next();
    Node Before = After.prev().prev();
    Before.setNext(After);
    After.setPrev(Before);
    size--;
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
