import java.util.*;

public class MyHeap{
    public String[] heap;
    private int constant = 1;
    public int size;


    public MyHeap(){
	heap = new String[1];
  heap[0] = "This is a heap:";
	size = 1;
    }

    public MyHeap(boolean type){
	heap = new String[1];
  heap[0] = "This is a heap:";
	if (type){
    constant = 1;
  }else{
    constant = -1;
  }
	size = 1;
    }

    public void add(String s){
      if (size = heap.length){
        grow();
      }
      heap[size] = s;
    }

    private void swap(int x, int y){
      String temp = heap[a];
      heap[a] = heap[b];
      heap[b] = temp;
    }

    private void pushUp(){
	   int parent = size;
     while (parent > 1 && (heap[parent].compareTo(heap[parent / 2] * constant) > 0))
      swap(parent, parent / 2);
      parent = parent / 2;
    }

    public void grow(){
      String[] temp = new String[size * 2];
      for (int i = 0; i < heap.length; i++){
        temp[i] = heap[i];
      }
      heap = temp;
      size = size * 2;
    }
}
