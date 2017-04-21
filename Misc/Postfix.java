public class Postfix{

  public static int eval(String s){
    Stack x = new Stack();
    for (int i = 0; i < s.length(); i++){
      if (isOp(s.charAt(i))){
        String temp1 = x.pop();
        String temp2 = x.pop();
        x.push(apply(s.substring(i, i + 1), temp1, temp2));
      }else{
        s.substring(i, i + 1).push();
      }
    }
    String fin = x.peek();
    return Integer.parseInt(fin);
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
