package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner depsc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> course = new LinkedHashMap<>();
        Map<String, Integer> checkCourse = new LinkedHashMap<>();
        List<String> unavailCourse = new ArrayList<>();
        int reject = 0;

        while (depsc.hasNextLine()){
            String input = depsc.nextLine();
            String[] breakInp = input.split(" ");
            String instruction = breakInp[0];
            String courseCode = breakInp[1];
            
            if (instruction.equals("REGISTER")){
                int count = Integer.parseInt(breakInp[2]);
                if (course.containsKey(courseCode)){
                    course.put(courseCode, course.get(courseCode)+count);
                }
                else {
                    course.put(courseCode, count);
                }
            }
            else if (instruction.equals("WITHDRAW")){
                int count = Integer.parseInt(breakInp[2]);
                if (course.containsKey(courseCode) && course.get(courseCode) >= count){
                    course.put(courseCode, course.get(courseCode)-count);
                }
                else{
                    reject++;
                }
            }
            else if (instruction.equals("CHECK")){
                if (course.containsKey(courseCode)){
                    for (String c : course.keySet()){
                        checkCourse.put(c, course.get(c));
                    }
                }
                else {
                    unavailCourse.add(courseCode);
                    reject++;
                }
            }
        }
        depsc.close();
        System.out.println("===== Enrollment Checks =====");
        for (String cc : checkCourse.keySet()){
            System.out.println(cc + ": " + checkCourse.get(cc) + " students");
        }
        for (String uc : unavailCourse){
            System.out.println(uc + ": Not Found");
        }
        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (String c : course.keySet()){
            System.out.println(c + ": " + course.get(c) + " students");
        }
        System.out.println();
        System.out.println("Rejected operations: "+reject);
    }
}
