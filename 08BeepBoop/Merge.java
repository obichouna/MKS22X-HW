public class Merge{

  public Merge(){

  }

  public static void mergesort(int[] data){
    if (data.length == 1){
      return;
    }
    int[] left = new int[data.length / 2];
    int[] right = new int[data.length - left.length];
    int temp = 0;
    while(temp < left.length){
      left[temp] = data[temp];
    }
    temp = 0;
    while(temp < right.length){
      right[temp] = data[left.length + temp];
    }
    mergesort(left);
    mergesort(right);
    merge(data, left, right);
  }


  public static void merge(int[] data, int[] part1, int[] part2){
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < part1.length && j < part2.length){
     if (part1[i] < part2[j]){
         data[k] = part1[i];
         i++;
         k++;
     }else{
         data[k] = part2[j];
         j++;
         k++;
     }
 }

 while (i < part1.length){
     data[k] = part1[i];
     i++;
     k++;
 }

 while (j < part2.length){
     data[k] = part2[j];
     j++;
     k++;
 }
}

public static String toString(int[] x){
  String beep = "[";
  for (int i = 0; i < x.length; i++){
    beep += Integer.toString(x[i]) + ", ";
  }
  beep += "]";
  return beep;
}

public static void main(String[] args){
  int[] data = {2, 5, 3, 23, 11, 37, 25, 9, 85, 20, 74, 19, 38, 58, 67, 38};
  mergesort(data);
  System.out.println(toString(data));
}

}
