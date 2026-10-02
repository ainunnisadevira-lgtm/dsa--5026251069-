package lw03.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner prob1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> song = new ArrayList<>();
        while (prob1.hasNextLine()){
            String line = prob1.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];

            if (type.equals("ADD")){
                String title = parts[1];
                song.add(title);
            }
            else if (type.equals("INSERT")){
                int index = Integer.parseInt(parts[1]);
                String title = parts[2];
                song.add(index, title);
            }
            else if (type.equals("REMOVE")){
                String title = parts[1];
                song.remove(title);
            }

            System.out.println("=== Problem 1 ===");
            System.out.println("Total Songs: "+song.size());

            for (int i=1; i<=song.size(); i++){
                System.out.println((i + 1)+". "+song.get(i-1));
            }
        }
        prob1.close();

        //Problem 2
        Scanner prob2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set <String> participants = new LinkedHashSet<>();
        int duplicate = 0;
        int total = 0;
        while (prob2.hasNext()){
            String name = prob2.next();
            if (participants.contains(name)){
                duplicate++;
            }
            else{
                participants.add(name);
                total++;
            }
        }
        System.out.println("Unique Participants: "+total);
        int urutan=1;
        for (String par : participants){
            System.out.println(urutan+". "+par);
            urutan++;
        }
        System.out.println("Duplicate participants: "+ duplicate);
        prob2.close();

        //Problem 3
        Scanner prob3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map <String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;
        while(prob3.hasNext()){
            String line = prob3.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            if (type.equals("ADD")){
                if (inventory.containsKey(product)){
                    inventory.put(product, inventory.get(product) + quantity);
                }
                else{
                    inventory.put(product, quantity);
                }
            }
            else if (type.equals("SELL")){
                if(inventory.containsKey(product) && inventory.get(product) >= quantity){
                    inventory.put(product, inventory.get(product) - quantity);
                }
                else{
                    failed++;
                }
            }
        } 
        System.out.println("=== Problem 3 ===");
        for (String item : inventory.keySet()) {
            System.out.println(item+": "+inventory.get(item));
        }
        System.out.println("Failed Sales: "+ failed);
        prob3.close();
    }
}
