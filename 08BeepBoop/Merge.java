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

    if (left.length > 1){
      mergesort(left);
    }
    if(right.length > 1){
      mergesort(right);
    }

    merge(data, left, right);
  }


  public static void merge(int[] data, int[] part1, int[] part2){
    if (part1.length + part2.length == data.length){
      return;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < part1.length && j < part2.length){
     if (part1[i] < part2[j])
     {
         data[k] = part1[i];
         i++;
     }
     else
     {
         data[k] = part2[j];
         j++;
     }
     k++;
 }

 while (i < part1.length)
 {
     data[k] = part1[i];
     i++;
     k++;
 }

 while (j < part2.length)
 {
     data[k] = part2[j];
     j++;
     k++;
 }

}

}
