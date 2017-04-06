public class MyLinkedList{
    private LNode start;
    private LNode end;
    private int size;

    public MyLinkedList(){
	size = 0;
    }


    public int size(){
	return size;
    }

    public boolean add(int value){
	if (size ==  0){
	    start = new LNode(value);
	    end = new LNode(value);
	    size += 1;
	    return true;
	}
	LNode created = new LNode(value);
	LNode current = start;
	while (current.next != null){
	    current = current.next;
	}
	created.prev = current;
	current.next = created;
	size += 1;
	return true;
    }

    private LNode getNode(int index){
	if (index < size / 2){
    LNode current = start;
    int temp = index;
    while (current.next != null && temp > 0){
      current = current.next;
      temp--;
    }
    return current;
  }

    LNode current = end;
    int temp = size - index;
    while (current.prev != null && temp > 0){
      current = current.prev;
      temp--;
    }
    return current;
  }

    private void addAfter(LNode location, LNode adder){
	if (location.next == null){   //If location = end
	    adder.next = null;
	    adder.prev = location;
	    location.next = adder;
      size += 1;
	}
	adder.prev = location;
	adder.next = location.next;
	location.next.prev = adder;
	location.next = adder;
  size += 1;
    }

    private void addBefore(LNode location, LNode adder){
	if (location.prev == null){   //If location = start
	    adder.prev = null;
	    adder.next = location;
	    location.prev = adder;
      size += 1;
	}
	adder.next = location;
	adder.prev = location.prev;
	location.prev.next = adder;
	location.prev = adder;
  size += 1;
    }

    private void remove(LNode remover){
	remover.prev.next = remover.next;
	remover.next.prev = remover.prev;
	remover.next = null;
	remover.prev = null;
  size -= 1;
    }

    public int get(int index){
	return getNode(index).value;
    }

    public int set(int index, int boop){
	int x = getNode(index).value;
	getNode(index).value = boop;
	return x;
    }

    public int indexOf(int value){
      LNode current = start;
      int temp = 0;
      while (current.value != value){
        current = current.next;
        temp++;
      }
      return temp;
    }

    public int remove(int index){
      int temp  = getNode(index).value;
      remove(getNode(index));
      return temp;
    }

    public void add(int index, int value){
      LNode adam = new LNode(value);
      addAfter(getNode(index - 1), adam);
    }

    public String toString(){
      String boop = "[";
      LNode current = start;
      int temp = size;
      while (temp != 0){
        boop += Integer.toString(current.value) + ", ";
        current = current.next;
        temp--;
      }
      boop += "]";
      return boop;
    }


private class LNode{
    private int value;
    private LNode next;
    private LNode prev;

    public LNode(){
    }

    public LNode(int x){
	value = x;
	next = null;
	prev = null;
    }

}


    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList();
	x.add(29);
	x.add(2);
  x.add(2, 4);
  x.add(1, 49);
  x.add(60);
  x.add(32);
  x.add(89);
	System.out.println(x.toString());
  //System.out.println(Integer.toString(getNode(0).value));
    }
}
