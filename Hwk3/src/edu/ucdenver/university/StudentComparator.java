package edu.ucdenver.university;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    // Compares the standing order by numeric representation using getStandingOrder() method
    @Override
    public int compare(Student o1, Student o2) {

        int result = getStandingOrder(o1.getStanding()) - getStandingOrder(o2.getStanding());

        // If standing order is the same:
        if (result == 0) {
            // iterate through indices of each character in object strings
            for(int i = 0; i < o1.getName().length(); i++) {
                //sort objects lexicographically using string's characters starting at index 0
                int r = o1.getName().charAt(i) - o2.getName().charAt(i);
                // o1 < o2, return a negative integer
                if (r < 0) {
                    result = -1;
                    break;
                }
                //o1 > o2 return a positive int
                else if (r > 0) {
                    result = 1;
                    break;
                }
                // o1 = o2, move to next index and compare again
                else {
                    i++;
                }
            }

        }

        return result;
    }

    //returns an integer (0,1,2,3) representing ordinal of the standing (0 for undergrad, 1 for master, 2 phd and
    // 3 for other,not known yet)
    public int getStandingOrder(String standing){

        int order = 3;

        switch (standing) {
            case "Undergraduate" :
                order = 0;
                break;
            case "Master" :
                order = 1;
                break;
            case "PhD" :
                order = 2;
                break;
        }
        return order;
    }
}
