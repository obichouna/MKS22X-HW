public class RunningMedium{
  public MyHeap maxHeap = new MyHeap(true);
  public MyHeap minHeap = new MyHeap(false);

  public RunningMedium(){
    maxHeap = new MyHeap(true);
    minHeap = new MyHeap(false);
  }

  public double getMedian(){
    if (maxHeap.size == minHeap.size){
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }else if(maxHeap.size > minHeap.size){
      return (double)maxHeap.peek();
    }else{
      return (double)minHeap.peek();
    }
  }

  public void add(int value){
    if (maxHeap.size == 0){
      maxHeap.add(value);
    }else{
      if (maxHeap.peek() < value){
        minHeap.add(value);
      }else{
        maxHeap.add(value);
      }
      if(minHeap.size > maxHeap.size + 1){
        maxHeap.add(minHeap.remove());
      }else if (maxHeap.size > minHeap.size + 1){
        minHeap.add(maxHeap.remove());
      }
    }
  }

}
