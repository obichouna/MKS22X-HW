import java.io.*;
import java.util.*;

public class USAClone{
   private int row, col, elev, numStomps, time, R1, R2, C1, C2;
   private int[][] pasture, moves, meme;

//Thanks to Adam Abbas for being a good partner in the bronze
//and also I did catch a peek at your code for the silver
   public USAClone(){}

   public int bronze(String filename){
       Scanner inf;
       try{
           inf = new Scanner(new File(filename));
           row = inf.nextInt();
           col = inf.nextInt();
           elev = inf.nextInt();
           numStomps = inf.nextInt();
           inf.nextLine();
           int counter = 0;
           pasture = new int[row][col];
           while (counter < row){
               String line = inf.nextLine();
               String[] temp = line.split(" ");
               for (int i = 0; i < temp.length; i++){
                   pasture[counter][i] = Integer.parseInt(temp[i]);
               }
               counter++;
           }
           moves = new int[numStomps][3];
           for(int i = 0; inf.hasNextLine(); i++){
               moves[i][0] = inf.nextInt();
               moves[i][1] = inf.nextInt();
               moves[i][2] = inf.nextInt();
               inf.nextLine();
           }

           for(int[] ya: moves){
               int raow = ya[0] - 1;
               int caol = ya[1] - 1;
               int depf = ya[2];

               int lowestDepth = findMax(raow, caol) - depf;

               for(int r = raow; r < raow + 3 && r < row; r++){
                   for(int c = caol; c < caol + 3 && c < col; c++){
                       if(pasture[r][c] > lowestDepth){
                           pasture[r][c] = lowestDepth;
                       }
                   }
               }
           }

           return calculateVol() * 5184;
       }
       catch(FileNotFoundException e){
           return 1;
       }

   }

   private int findMax(int trow, int tcol){
       int curMax = 0;
       for(int r = trow; r < trow + 3 && r < row; r++){
           for(int c = tcol; c < tcol + 3 && c < col; c++){
               if(pasture[r][c] > curMax){
                   curMax = pasture[r][c];
               }
           }
       }
       return curMax;
   }
   public int calculateVol(){
       int total = 0;
       for (int r = 0; r < pasture.length; r++){
           for (int c = 0; c < pasture[0].length; c++){
               if (pasture[r][c] >= elev){
                   pasture[r][c] = 0;
               }else{
                   pasture[r][c] = elev - pasture[r][c];
               }
               total += pasture[r][c];
           }
       }
       return total;
   }

   public int silver(String fileName){
     try{
       Scanner scan = new Scanner(new File(fileName));
       row = scan.nextInt();
       col = scan.nextInt();
       time = scan.nextInt();
       //System.out.println(col);
       scan.nextLine();
       pasture = new int[row][col];
       meme = new int[row][col];
       int temp = 0;
       while (temp < row){
         String boop = scan.nextLine();
         String[] soup = boop.split(" ");
        for (int x = 0; x < soup.length; x++){
          if (soup[x].equals(".")){
            pasture[temp][x] = 0;
          }else if(soup[x].equals("*")){
            pasture[temp][x] = -1;
          }
        }
         temp++;
       }
       printTwoDAr(pasture);
      R1 = scan.nextInt() - 1;
      C1 = scan.nextInt() - 1;
      R2 = scan.nextInt() - 1;
      C2 = scan.nextInt() - 1;
     }
     catch(FileNotFoundException e){
       System.exit(0);
     }
     return paths(R1, C1, R2, C2);
   }

//credit to Adam Abbas for having code that could deal with the IndexOutofBoundsException
   public int paths(int startR, int startC, int endR, int endC){
     pasture[startR][startC] = 1;
     int temp1 = 0;
     int temp2 = 0;
     int temp3 = 0;
     int temp4 = 0;
     for (int r = 0; r < pasture.length; r++){
       for (int c = 0; c < pasture[0].length; c++){
         if (pasture[r][c] == -1){
           meme[r][c] = -1;
         }
       }
     }
     while (time != 0){
       for (int i = 0; i < pasture.length; i++){
         for (int j = 0; j < pasture[0].length; j++){
           if (pasture[i][j] != -1){
             try{
               if (pasture[i + 1][j] != -1){
                 temp1 = pasture[i + 1][j];
                 meme[i + 1][j] = 0;
               }
             }
             catch(ArrayIndexOutOfBoundsException e){}
               try{
               if (pasture[i - 1][j] != -1){
                 temp2 = pasture[i - 1][j];
                 meme[i - 1][j] = 0;
               }
             }
             catch(ArrayIndexOutOfBoundsException e){}
               try{
               if (pasture[i][j + 1] != -1){
                 temp3 = pasture[i][j + 1];
                 meme[i][j + 1] = 0;
               }
             }
             catch(ArrayIndexOutOfBoundsException e){}
               try{
               if (pasture[i][j - 1] != -1){
                 temp4 = pasture[i][j - 1];
                 meme[i][j - 1] = 0;
               }
             }
             catch(ArrayIndexOutOfBoundsException e){}
           }
           meme[i][j] = temp1 + temp2 + temp3 + temp4;
         }
       }
       for (int u = 0; u < meme.length; u++){
         for(int o = 0; o < meme[0].length; o++){
           pasture[u][o] = meme[u][o];
         }
       }
       time--;
     }
     return pasture[endR][endC];
   }

   private void printTwoDAr(int[][] toPrint){
    String toRet = "";
    for(int r = 0; r < toPrint.length;r++){
        for(int c = 0; c < toPrint[r].length; c++){
            toRet += toPrint[r][c] + " ";
        }
        toRet += "\n";
    }
    System.out.println(toRet);
}

	public static void main(String[]args){
		USAClone x = new USAClone();
		System.out.println(x.silver("ctravel1.in"));

	}
}
