package sp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Controller {
  class Queue<T> implements QueueInterface<T> {
    private List<T> impl;
    
    public Queue(List<T> initialImpl) {
      this.impl = initialImpl;
    }
    
    public void add(T element) {
      this.impl.add(element);
    }
    
    public T get() {
      if (this.impl.isEmpty())
        throw new IllegalStateException("Queue is empty"); 
      return this.impl.get(0);
    }
    
    public T remove() {
      if (this.impl.isEmpty())
        throw new IllegalStateException("Queue is empty"); 
      return this.impl.remove(0);
    }
    
    public int size() {
      return this.impl.size();
    }
    
    public void clear() {
      this.impl.clear();
    }
    
    public void changeImpl(List<T> newImpl) {
      newImpl.clear();
      newImpl.addAll(this.impl);
      this.impl = newImpl;
    }
  }
  
  public void run() {
    QueueInterface<Integer> q1 = new Queue<>(new ArrayList<>());
    q1.add(Integer.valueOf(91));
    q1.add(Integer.valueOf(92));
    LinkedList<Integer> aList = new LinkedList<>();
    aList.add(Integer.valueOf(93));
    q1.changeImpl(aList);
    q1.add(Integer.valueOf(94));
    q1.add(Integer.valueOf(95));
    displayAndEmptyQueue(q1);
    QueueInterface<String> q2 = new Queue<>(new LinkedList<>());
    q2.add("Have");
    q2.add("a");
    ArrayList<String> bList = new ArrayList<>();
    bList.add("nice");
    q2.changeImpl(bList);
    q2.add("day");
    q2.add("today!");
    displayAndEmptyQueue(q2);
  }
  
  public static <T> void displayAndEmptyQueue(QueueInterface<T> q) {
    while (q.size() > 0)
      System.out.print(String.valueOf(q.remove()) + " "); 
    System.out.println("");
  }
  
  static interface QueueInterface<T> {
    void add(T param1T);
    
    T get();
    
    T remove();
    
    int size();
    
    void clear();
    
    void changeImpl(List<T> param1List);
  }
}
