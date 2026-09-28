package lw01.unguided;
import java.util.Scanner;

public class Main {
    Scanner depsc=new Scanner(Main.class.getResourceAsStream("rental.txt"));
    int T=depsc.nextInt();
    depsc.nextLine();
    Object[] rental=new Object[T];
    for (int i=0; i<T;i++){
        String type = depsc.next();
        String id = depsc.next();
        int days = depsc.nextInt();
        int units = depsc.nextInt();
    }
    depsc.close();
    
    for (Rental r: rental) {
        System.out.println(r.summary());
    }
}
