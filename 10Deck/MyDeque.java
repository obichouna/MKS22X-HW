public class MyDeque{
  public String[] dque;
  public int start;
  public int end;
  public int size;

  public MyDeque(){
    dque = new String[5];
    size = 0;
    start = 0;
    end = 0;
  }

  public void increase(){
    String[] newDque = new String[size * 2];
    int x = start;
    int i = 0;
    while(x != end){
      newDque[i] = dque[x];
      x = (x + 1) % (dque.length);
      i++;
    }
    newDque[i] = dque[end];
    end = i;
    start = 0;
    dque = newDque;
  }

  public void addFirst(String s){
    if (s.equals(null)){
      throw new NullPointerException();
    }
    if (size == dque.length){
      increase();
    }
    start--;
    if (start < 0){
      start = dque.length - 1;
    }
    dque[start] = s;
    size++;
  }

  public void addLast(String s){
    if(s.equals(null)){
      throw new NullPointerException();
    }
    if (size == dque.length){
      increase();
    }
    end++;
    if(end == dque.length){
      end = 0;
    }
    dque[end] = s;
    size++;
  }

  public String removeFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    String x = dque[start];
    dque[start] = null;
    if (start < dque.length - 1){
      start++;
    }else{
      start = 0;
    }
    size--;
    return x;
  }

  public String removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    String x;
    if(end > 0){
      x = dque[end];
      end--;
    }else{
      x = dque[0];
      end = dque.length - 1;
    }
    dque[end + 1] = null;
    size--;
    return x;
  }

  public String getFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    return dque[start];
  }

  public String getLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    return dque[end];
  }
}
