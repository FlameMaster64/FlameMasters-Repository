import java.util.Scanner;
public class MyClass {
  public static void main(String args[]) {
      
      Scanner input = new Scanner(System.in);
      
      String compute = input.next();
      
      System.out.println(Calc(compute));
  
   }
      
  public static double Calc(String compute){
      
      Scanner equation = new Scanner(compute);
      
      double num1 = equation.nextDouble();
      
      String operation = equation.next();
      
      double num2 = equation.nextDouble();
      
      double nothing = 0;
      
      if(operation.equals("+")){
          double answer = num1 + num2;
          return answer;
      }
      else if(operation.equals("-")){
          double answer = num1 - num2;
          return answer;
      }
      else if(operation.equals("*")){
          double answer = num1 * num2;
          return answer;
      }
      else if(operation.equals("/")){
          double answer = num1 / num2;
          return answer;
      }
      else{
          return nothing;
      }
  }
}
