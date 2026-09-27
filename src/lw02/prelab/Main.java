package lw02.prelab;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        List<String[]> transaksi = new LinkedList<>();
        Scanner depsc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while (depsc.hasNextLine()){
            String cust = depsc.nextLine();
            String[] custDetail = cust.split(" ");
            transaksi.add(custDetail);
        }
        depsc.close();

        //cek cust udah terdaftar ap blm
        List<String[]> bankCustomer = new LinkedList<>();
        for (String[] trn : transaksi){
            String uniqName = trn[0];

            boolean terdaftar = false;
            for (String[] cust : bankCustomer){
                if (cust[0].equals(uniqName)){
                    terdaftar = true;
                    break;
                }
            }
            if (!terdaftar){
                bankCustomer.add(new String[]{uniqName, "0"});
            }
        }

        //penerapan queue
        Queue<String[]> antrian = new LinkedList<>();
        Stack<String[]> gagalWithdraw = new Stack<>();
        for(String[] trn : transaksi){
            antrian.add(trn);
        }
        while (!antrian.isEmpty()){
            String[] custProses = antrian.poll();
            String namaCust = custProses[0];
            String tipeCust = custProses[1];
            int nominal = Integer.parseInt(custProses[2]);
            
            String[] targetCustomer = null;
            for (String[] cust : bankCustomer){
                if (cust[0].equals(namaCust)){
                    targetCustomer = cust;
                    break;
                }
            }
            int saldoLama = Integer.parseInt(targetCustomer[1]);
            if (tipeCust.equals("WITHDRAW")){
                if (nominal>saldoLama){
                    gagalWithdraw.push(custProses);
                }
                else{
                    int saldoBaru = saldoLama - nominal;
                    targetCustomer[1] = String.valueOf(saldoBaru);
                }
            }
            else{
                int saldoBaru = saldoLama + nominal;
                targetCustomer[1] = String.valueOf(saldoBaru);
            }
        }

        //print
        System.out.println("=== Final Balances ===");
        for (String[] cust : bankCustomer){
            System.out.println(cust[0] + " : " + cust[1]);
        }
        System.out.println();
            
        System.out.println("=== Failed Transactions ===");
        while (!gagalWithdraw.isEmpty()){
            String[] gagal = gagalWithdraw.pop();
            System.out.println(gagal[0] + " " + gagal[1] + " " + gagal[2]);
        }
    }
}
