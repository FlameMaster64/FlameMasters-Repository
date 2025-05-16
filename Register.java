import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class MyClass {
  public static void main(String args[]) {
      
      Register reg = new Register(10);
      
      System.out.println(reg.price);
  }
}

class Register {
    
    double price;
    List<Integer> values = Arrays.asList(1000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1);
    
    Register(double price) {
        this.price = price;
    }
    
    void changePrice(double price) {
        this.price = price;
    }
    
    double getChange(double money) {
        return money - price;
    }
    
    List<Integer> getCash(double money) {
        int change = (int) (100 * getChange(money));
        List<Integer> answers = new ArrayList<>();
        
        /*int hundreds = change / 100;
        change %= 100;*/
        for (int x = 0; x < values.size(); x++){
            int amt = change / values.get(x);
            change %= values.get(x);
            answers.add(amt);
        }
        return answers;
    }
}

class Store {
    
    double itemPrice;
    
    void itemPrices(double itemPrice) {
        Store apple = new Store();
        Store bread = new Store();
        Store chips = new Store();
        Store nintendoSwitch = new Store();
        Store laptop = new Store();
        apple.itemPrice = 5;
        bread.itemPrice = 10;
        chips.itemPrice = 5;
        nintendoSwitch.itemPrice = 200;
        laptop.itemPrice = 700;
    }
