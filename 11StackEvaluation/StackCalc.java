import java.util.*;

public class StackCalc{

  public static Double eval(String s){
      String[] beep = s.split(" ");
      Stack<String> x = new Stack<String>();
      for (String token: beep){
	  if (isOP(token)){
	  String temp1 = x.pop().toString();
	  String temp2 = x.pop().toString();
	  //System.out.println(s.substring(i, i + 1));
	  //System.out.println(temp1);
        x.push(apply(token, temp1, temp2));
      }else{
	  // System.out.println(s.substring(i, i + 1));
	  // System.out.println(x.peek());
	  x.push(token);
      }
    }
    String fin = x.peek().toString();
    return Double.parseDouble(fin);
  }

  private static boolean isOp(String s){
      if (s.equals("*") || s.equals("-") || s.equals("/") || s.equals("+")){
      return true;
    }
    return false;
  }

  private static String apply(String op, String a, String b){
    if(op.equals("*")){
        return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
    }else if(op.equals("+")){
        return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
    }else if(op.equals("/")){
        return Integer.toString(Integer.parseInt(a) / Integer.parseInt(b));
    }else if(op.equals("-")){
        return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
    }
    return " ";
  }

}
