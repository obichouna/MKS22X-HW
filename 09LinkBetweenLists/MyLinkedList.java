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
	    size += 1;
	    return true;
	}
  LNode created = new LNode();
  created.value = value;
  LNode current = start;
  while (current.next() != null){
    current = current.next();
  }
  current.next = created;
  size += 1;


    }


}

private class LNode{
    private int value;
    private LNode next;



}
