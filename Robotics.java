public class Robotics {
    public static void main (String[] args) {
        for (int a = 1;a < 8; a++){
            for (int b = 1; b <= 8 - a; b++) {
                System.out.print(b);
            }
            System.out.println();
        }
        System.out.println("Lets go!");
    }
}
