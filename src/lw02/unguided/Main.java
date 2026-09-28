package lw02.unguided;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        List<String[]> reqPinjam = new LinkedList<>();
        Scanner depsc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        while(depsc.hasNext()){
            String[] request = new String[2];
            request[0] = depsc.next();
            request[1] = depsc.next();
            reqPinjam.add(request);
        }
        depsc.close();

        LinkedList<String[]> bukuPerpus = new LinkedList<>();
        bukuPerpus.add(new String[]{"Kalkulus", "2"});
        bukuPerpus.add(new String[]{"Fisika", "1"});
        bukuPerpus.add(new String[]{"Statistika", "2"});

        LinkedList<String[]> memberPerpus = new LinkedList<>();
        for (String[] req : reqPinjam){
            boolean sudahLimit=false;
            for (String[] mem : memberPerpus){
                if (mem[0].equals(req[0])){
                    sudahLimit=true;
                    break;
                }
            }
            if (!sudahLimit){
                memberPerpus.add(new String[]{req[0], "0"});
            }
        }
        Queue<String[]> antrian = new LinkedList<>();
        for (String[] req : reqPinjam){
            antrian.add(req);
        }
        
        LinkedList<String[]> berhasil = new LinkedList<>();
        Stack<String[]> gagal = new Stack<>();
        String[] member = null;
        for (String[] req : reqPinjam) {
            antrian.add(req);
        }
        while (!antrian.isEmpty()){
            String[] req = antrian.poll();
            String nama = req[0];
            String kategori = req[1];

            String[] bukuDipilih = null;
            for (String[] bp : bukuPerpus){
                if (bp[0].equals(kategori)){
                    bukuDipilih = bp;
                    break;
                }
            }
            String[] memberDipilih = null;
            for (String[] mem : memberPerpus){
                if (mem[0].equals(nama)){
                    memberDipilih = mem;
                    break;
                }
            }
        }
    }
}
