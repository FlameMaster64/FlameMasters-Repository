import java.util.Scanner;
public class MyClass {
  public static void main(String args[]) {
      
      Scanner input = new Scanner(System.in);
      double num1 = input.nextDouble();
      String operation = input.nextLine();
      double num2 = input.nextDouble();
   
      if(operation=="+"){
          double answer = num1 + num2;
          System.out.println(answer);
      }
      else if(operation=="-"){
          double answer = num1 - num2;
          System.out.println(answer);
      }
      else if(operation=="*"){
          double answer = num1 * num2;
          System.out.println(answer);
      }
      else if(operation=="/"){
          double answer = num1 / num2;
          System.out.println(answer);
      }
      else{
          System.out.println("Sorry");
     }
   }
}
