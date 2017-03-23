import java.util.Random;
public class Quick{
    public Quick(){
    }

    public static int part(int[]data, int start, int end){
	Random rand = new Random();
	int pivotI = rand.nextInt(end - start) + start;
	int pivot = data[pivotI];
        int i = start;
	int j = end;
	int lt = start;
	int gt = end;
	int temp = data[0];
	data[0] = pivot;
	data[pivotI] = temp;
	while (i <= j){
	    if (data[i] == pivot){
		i++;
	    }else if (data[i] < pivot){
		
	    }

	}





    }

    public static swap(







}
