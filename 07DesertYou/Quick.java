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
	while (i <= gt){
	    if (data[i] == pivot){
		i++;
	    }else if (data[i] < pivot){
		temp = data[lt];
		data[lt] = data[i];
		data[i] = temp;
		i++;
		lt++;
	    }else{
		temp = data[gt];
		data[gt] = data[i];
		data[i] = temp;
		gt--;
	    }

	}





    }








}
