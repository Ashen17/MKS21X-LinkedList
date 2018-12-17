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
    Random seed = new Random(130);
    Node first = new Node(5);
    start = end = first;
    for (int i = 0; i < s; i++){
      this.add(seed.nextInt()%10);
      size--;
    }
  }
  private Node getNthNode(int index){
    if (index < 0){throw new IndexOutOfBoundsException();}
    try {
      Node current = start;
      for (int i = index; i > 0; i--){
        current = current.next();
      }
      return current;
    }
    catch (NullPointerException E){
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
      //if (index == 0){start = save;}
      //if (index == size() - 1){end = save;}
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
    Node Current = getNthNode(index);
    Node After = Current.next();
    Node Before = Current.prev();
    Before.setNext(After);
    After.setPrev(Before);
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
/*
TO DO lIST
1) add reminder comments
2) organize functions
3) add error handling
  3.1) throwing indexoutofbounds errors
  3.2) other unfathomable errors uncaught by lackluster testing
4) put node into the linkedlist class */
