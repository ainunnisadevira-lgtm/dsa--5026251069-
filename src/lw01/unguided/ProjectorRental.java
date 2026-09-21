package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days){
        super(id, days);
    }

    public int calculateCharge(){
        int days=getDays();
        int total;
        if (days<=3){
            total=days*60000;
        }else{
            total=(3*60000)+(days*45000);
        }
        return total+20000;
    }

    @Override 
    public String label(){
        return "Laptop";
    }
}