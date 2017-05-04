import java.util.*;

public class StackCalc{

  public static Double eval(String s){
    Stack<String> x = new Stack<String>();
    for (int i = 0; i < s.length(); i++){
      if (isOp(s.charAt(i))){
	  String temp1 = x.pop().toString();
	  String temp2 = x.pop().toString();
        x.push(apply(s.substring(i, i + 1), temp1, temp2));
      }else{
	  x.push(s.substring(i, i + 1));
      }
    }
    String fin = x.peek().toString();
    return Double.parseDouble(fin);
  }

  private static boolean isOp(char s){
    if (s == '*' || s == '-' || s == '/' || s == '+'){
      return true;
    }
    return false;
  }

  private static String apply(String op, String a, String b){
    if(op.equals("*")){
        return (Integer.parseInt(a) * Integer.parseInt(b)) + "";
    }else if(op.equals("+")){
        return (Integer.parseInt(a) + Integer.parseInt(b)) + "";
    }else if(op.equals("/")){
        return (Integer.parseInt(a) / Integer.parseInt(b)) + "";
    }else if(op.equals("-")){
        return (Integer.parseInt(a) - Integer.parseInt(b)) + "";
    }
    return " ";
  }

}
