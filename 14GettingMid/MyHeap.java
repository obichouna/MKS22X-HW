import java.util.*;

public class MyHeap{
    public int[] heap;
    private int constant = 1;
    public int size;


    public MyHeap(){
	heap = new int[5];
	size = 1;
    }

    public MyHeap(boolean type){
	heap = new int[5];
	if (type){
    constant = 1;
  }else{
    constant = -1;
  }
	size = 1;
    }

    public String toString(){
        String temp = "";
        for(int each:heap){
            temp += each + " ";
        }
        return temp;
}

    public void add(int s){
      if (size >= heap.length - 1){
        grow();
      }
      heap[size] = s;
      pushUp();
      size++;
    }

    public int remove(){
      int temp = heap[1];
      heap[1] = heap[size - 1];
      pushDown(1);
      size--;
      return temp;
    }

    private void swap(int x, int y){
      int temp = heap[x];
      heap[x] = heap[y];
      heap[x] = temp;
    }

    private void pushUp(){
	   int parent = size;
     while (parent > 1 && ((heap[parent] - heap[parent / 2]) * constant) > 0){
      swap(parent, parent / 2);
      parent = parent / 2;
      }
    }

//Thanks to Sihao Huang - I was looking at him work on this in class
    private void pushDown(int index){
      int temp = 0;
      while ((2 * index) < size){
        if (((heap[index] - heap[index * 2]) * constant) < 1){
            temp = index * 2;
            if(((heap[index] - heap[index * 2 + 1]) * constant) < 1){
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
      int[] temp = new int[size * 2];
      for (int i = 0; i < heap.length; i++){
        temp[i] = heap[i];
      }
      heap = temp;
    }

    public int peek(){
      return heap[1];
    }

}
