public class MyClass {
  public static void main(String args[]) {
      
      Register mine = new Register(20);
      
      
  }
}

class Register {
    
    double price;
    
    Register(double price){
        this.price = price;
    }
    
    void Change(double newPrice){
        this.price = newPrice;
    }
    
}
