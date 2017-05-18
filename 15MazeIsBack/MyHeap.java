import java.util.*;

public class MyHeap{
    public ArrayList<Location> heap;
    private int constant = 1;
    public int size;


    public MyHeap(){
	heap = new ArrayList<Location>();
	size = 1;
    }

    public MyHeap(boolean type){
	heap = new ArrayList<Location>();
	if (type){
    constant = 1;
  }else{
    constant = -1;
  }
	size = 1;
    }


    public void add(Location s){
      if (size >= heap.length - 1){
        grow();
      }
      heap.set(size, s);
      pushUp();
      size++;
    }

    public Location remove(){
      Location temp = heap.get(1);
      heap.set(size, heap.get(size - 1));
      pushDown(1);
      size--;
      return temp;
    }

    private void swap(int x, int y){
      String temp = heap[x];
      heap[x] = heap[y];
      heap[x] = temp;
    }

    private void pushUp(){
	   int parent = size;
     while (parent > 1 && (heap[parent].compareTo(heap[parent / 2]) * constant) > 0){
      swap(parent, parent / 2);
      parent = parent / 2;
      }
    }


    private void pushDown(int index){
      int temp = 0;
      while ((2 * index) < size){
        if ((heap[index].compareTo(heap[index * 2]) * constant) < 1){
            temp = index * 2;
            if((heap[index].compareTo(heap[index * 2 + 1]) * constant) < 1){
            temp += 1;
            }
            swap(index, temp);
            index = temp;
        }else{
          break;
        }
      }
    }

    public void grow(){
      String[] temp = new String[size * 2];
      for (int i = 0; i < heap.length; i++){
        temp[i] = heap[i];
      }
      heap = temp;
    }

    public String peek(){
      return heap[1];
    }

}
