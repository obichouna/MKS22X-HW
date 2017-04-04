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
	if (size - index < size / 2){

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
	System.out.println(x.toString());
    }
}
