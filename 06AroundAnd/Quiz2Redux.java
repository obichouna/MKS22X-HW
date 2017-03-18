import java.util.*;
public class Quiz2Redux{

  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help(words, 0, s,"");
      Collections.sort(words);
      return words;
  }

  private static void help(ArrayList<String> words, int start, String s, String x){
      if (start >= s.length()){
        words.add(x);
      }
      else{
        help(words, start + 1, s, x + s.charAt(start));
        help(words, start + 1, s, x);
      }
    }

    public static void main(String[] args){
      System.out.println(Quiz2Redux.combinations("abcd"));
    }
}
