import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class USACO{
   private int row, col, elev, numStomps, time, R1, R2, C1, C2;
   private int[][] pasture, moves;


   public USACO(){}

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
       Scanner scan = new Scanner(new file(fileName));
       row = scan.nextInt();
       col = scan.nextInt();
       time = scan.nextInt();
       scan.nextLine();
       pasture = new int[row][col];
       temp = row;
       while (temp != 0){
         for (int i = 0; i < row; i++){
           for (int x = 0; x < col; x++){
             if (scan.next().equals(".")){
               pasture[i][x] = 0;
             }else{
               pasture[i][x] = -1;
             }
           }
         }
         scan.nextLine();
         temp--;
       }
      R1 = scan.nextInt() - 1;
      C1 = scan.nextInt() - 1;
      R2 = scan.nextInt() - 1;
      C2 = scan.nextInt() - 1;
      return paths(R1, C1, R2, C2);
     }
     catch(FileNotFoundException e){
       System.exit(0);
     }
   }

   public int paths(int startR, int startC, int endR, int endC){
     
   }
}
