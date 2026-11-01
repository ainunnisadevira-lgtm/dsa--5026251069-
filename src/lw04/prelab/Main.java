package lw04.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner depsc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = depsc.nextInt();
        int[] nArray = new int[n];
        for (int i=0; i<n; i++){
            nArray[i]=depsc.nextInt();
        };
        int m = depsc.nextInt();
        int[] target = new int[m];
        for (int i=0; i<m; i++){
            target[i]=depsc.nextInt();
        }
        depsc.close();
        //sorting 3 step
        for (int i=1; i<=3; i++){
            int simpan = nArray[i];
            int j = i-1;
            while (j>=0 && nArray[j]<simpan){
                nArray[j+1]=nArray[j];
                j--;
            }
            nArray[j+1]=simpan;
        }
        for (int i=0; i<nArray.length; i++){
            System.out.print(nArray[i]+ " ");
        }
        //searching
        System.out.println();
        int posisi = 0;
        for (int i=0; i<target.length; i++){
            for (int j=0; j<nArray.length; j++){
                if (nArray[j]==target[i]){
                    posisi=j;
                    break;
                }
                else{
                    posisi=-1;
                }
            }
            if (posisi!=-1){
                System.out.println(target[i]+": FOUND at index "+posisi);
            }
            else{
                System.out.println(target[i]+": NOT FOUND");
            }
        }
    }
}
