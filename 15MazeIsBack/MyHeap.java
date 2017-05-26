import java.util.*;

public class MyHeap{
    public Location[] heap;
    private int constant = 1;
    public int size;


    public MyHeap(){
	heap = new Location[5];
	size = 1;
    }

    public MyHeap(boolean type){
	heap = new Location[5];
	if (type){
    constant = 1;
  }else{
    constant = -1;
  }
	size = 1;
    }

    public String toString(){
        String temp = "";
        for(Location each:heap){
            temp += each + " ";
        }
        return temp;
}

    public void add(Location s){
      if (size >= heap.length - 1){
        grow();
      }
      heap[size] = s;
      pushUp(size);
      size++;
    }

    public Location remove(){
      Location temp = heap[1];
      heap[1] = heap[size - 1];
      pushDown(1);
      size--;
      return temp;
    }

    private void swap(int x, int y){
      Location temp = heap[x];
      heap[x] = heap[y];
      heap[x] = temp;
    }

    private void pushUp(int index){
        while(index != 1 && (heap[index].compareTo(heap[index/2]) * constant > 0)){
            swap(index, index/2);
            index = index/2;
        }
    }

    private void pushDown(int index){
      int temp = 0;
      while ((2 * index) < size){
        if (((heap[index].compareTo(heap[index * 2])) * constant) < 0){
            temp = index * 2;
            if((heap[index * 2].compareTo(heap[index * 2 + 1]) * constant) < 0){
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
      Location[] temp = new Location[size * 2];
      for (int i = 0; i < heap.length; i++){
        temp[i] = heap[i];
      }
      heap = temp;
    }

    public Location peek(){
      return heap[1];
    }

}
