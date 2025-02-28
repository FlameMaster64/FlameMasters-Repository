import java.util.Scanner;
public class MyClass {
  public static void main(String args[]) {
      
      Scanner input = new Scanner(System.in);
      
      double num1 = input.nextDouble();
      
      String operation = input.nextLine();
      
      double num2 = input.nextDouble();
      
      System.out.println(Calc(6, "+", 4));
  
   }
      
  public static double Calc(double num1, String operation, double num2){
      
      double nothing = 0;
      
      if(operation=="+"){
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
