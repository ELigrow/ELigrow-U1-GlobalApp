package edu.wctc.eligrow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    private final static FileInput places = new FileInput("places.csv");
    private final static FileInput stuff = new FileInput("stuff.csv");

    public static void main(String[] args) {
        String line;
        String[] fields;
        int numPlaces = 0;
        int numStuff = 0;
        System.out.format("%-21s  %-6s %-5s\n", "Country", "Cities", "Stuff");
        System.out.format("%-21s  %-6s %-5s\n", "=======", "======", "=====");
        ArrayList<String[]> placesArray = sortPlaces();
        ArrayList<String[]> stuffArray = sortStuff();
        String prev = "";
        for(int i = 0; i<placesArray.size(); i++) {
            fields = placesArray.get(i);
            if(!fields[0].equalsIgnoreCase(prev)) {
                numPlaces = findPlaces(fields[0], placesArray);
                numStuff = findStuff(fields[0], stuffArray);
                System.out.format("%-21s  %-6s %-5s\n", fields[0], numPlaces, numStuff);
            }
            prev = fields[0];
        }
    }

    /**
     * Reads the file, places everything in an ArrayList, then returns the ArrayList
     * @return ArrayList<String[]>: ArrayList of read document
     */
    public static ArrayList<String[]> sortPlaces(){
        ArrayList<String[]> placesArray = new ArrayList<String[]>();
        String line;
        String[] fields;
        while((line = places.fileReadLine()) != null) {
            fields = line.split(",");
            placesArray.add(fields);
        }
        Collections.sort(placesArray,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[0].compareTo(otherStrings[0]);
            }

        });
        places.fileClose();
        return placesArray;
    }

    /**
     * Reads the file, places everything in an ArrayList, then returns the ArrayList
     * @return ArrayList<String[]>: ArrayList of read document
     */
    public static ArrayList<String[]> sortStuff(){
        ArrayList<String[]> stuffArray = new ArrayList<String[]>();
        String line;
        String[] fields;
        while((line = stuff.fileReadLine()) != null) {
            fields = line.split(",");
            stuffArray.add(fields);
        }
        Collections.sort(stuffArray,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[0].compareTo(otherStrings[0]);
            }
        });
        stuff.fileClose();
        return stuffArray;
    }

    /**
     * Counts number of places per country and returns number of places
     * @param country String: Country to check against before adding to nums
     * @param ary ArrayList<String[]>: Array of items to check for
     * @return int nums: number of items
     */
    public static int findPlaces(String country, ArrayList<String[]> ary) {
        int nums = 0;
        String line;
        String[] fields;
        boolean done = false;
        for(int i = 0; i<ary.size(); i++) {
            fields = ary.get(i);
            if (fields[0].compareTo(country) > 0) {
                break;

            } else if (fields[0].equals(country)) {
                nums++;
            }
        }
        return nums;
    }

    /**
     * Counts number of items per country and returns number of items
     * @param country String: Country to check against before adding to nums
     * @param ary ArrayList<String[]>: Array of items to check for
     * @return int nums: number of items
     */
    public static int findStuff(String country, ArrayList<String[]> ary) {
        int nums = 0;
        String line;
        String[] fields;
        boolean done = false;
        String prev = "";
        for(int i = 0; i<ary.size(); i++) {
            fields = ary.get(i);

            if (fields[0].compareTo(country) > 0) {
                break;
            } else if (fields[0].equals(country)) {
                if(!fields[1].equalsIgnoreCase(prev))
                nums++;
            }
            prev = fields[1];
        }
        return nums;
    }
}
