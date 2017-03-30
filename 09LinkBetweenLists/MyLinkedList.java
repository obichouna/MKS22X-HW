public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	size = 0;
    }


    public int size(){
	//	LNode current = start;
	//	while (current.next() != null){
	//	    size += 1;
	//	    current = current.next;
	//	}
	return size;
    }

    public boolean add(int value){
	if (size ==  0){
	    start.value = value;
	    start.next = null;
	    size += 1;
	    return true;
	}
  LNode created = new LNode();
  created.value = value;
  LNode current = start;
  while (current.next != null){
    current = current.next;
  }
  current.next = created;
  size += 1;
  current.value = value;
  current.next = null;
  return true;
    }

    public String toString(MyLinkedList x){
      String boop = "[";
      LNode current = start;
      int temp = size;
      while (temp != 0){
        boop += Integer.toString(current.value);
        current = current.next;
        temp--;
      }
      boop += "]";
      return boop;
    }

private class LNode{
    private int value;
    private LNode next;

    public LNode(){
    }

    public LNode(int x){
	value = x;
    }

}

}
