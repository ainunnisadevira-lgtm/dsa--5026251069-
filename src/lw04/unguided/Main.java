package lw04.unguided;

import java.util.Scanner;

public class Main {
    static void sortCards(int[] ary, int passes){
        for (int i=0; i<passes; i++){
            int posMin=i;
            for (int next = i + 1; next<ary.length; next++) {
                if (ary[next]<ary[posMin]){
                    posMin=next;
                }
            }
            int varSementara = ary[posMin];
            ary[posMin]=ary[i];
            ary[i]=varSementara;
        }
    }

    static int findCard(int[] ary, int target){
        for (int i=0; i<ary.length; i++){
            if (ary[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner depsc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = depsc.nextInt();
        int[] nAry = new int[n];
        for (int i=0; i<n; i++){
            nAry[i]=depsc.nextInt();
        };
        int m = depsc.nextInt();
        int[] askCard = new int[m];
        for (int i=0; i<m; i++){
            askCard[i]=depsc.nextInt();
        }
        depsc.close();

        sortCards(nAry, 2);
        for (int a : nAry){
            System.out.print(a+" ");
        }
        System.out.println();
        for (int i=0; i<askCard.length; i++){
            int posisi = findCard(nAry, askCard[i]);
            if (posisi!=-1){
                System.out.println(askCard[i]+": FOUND at index "+posisi);
            }
            else{
                System.out.println(askCard[i]+": NOT FOUND");
            }
        }
    }
}