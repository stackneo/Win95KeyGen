import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class win95OemKeyGen {
    //Random instance
    Random rand = new Random();

    //Generates a day of the year and adds it to the string.
    private String genDay() {
        int min = 001;
        int max = 366;
        int combo = rand.nextInt((max-min)+1)+min;
        return Integer.toString(combo);
    }
    //Concatenates a year onto the string.
    private String genYear(String key) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year between 1995-2002 (95-02): ");
        int year = input.nextInt();
        if (year == 01 || year == 02) {
            String key_year = "0" + year;
            return key + key_year;
        }
        else if(year < 95 || year > 99 ){
            System.out.println("Invalid year!");
            genYear(key);
        }
        return key + year;
    }

    //Concatenates OEM to key.
    private String OEM(String key) {
        return key + "-OEM-";
    }

    //Mostly the same as the old keygen, except nums has to start with "00" for it to be a valid key.
    private String nums(String key) {
       String nums = "00";
        int sum = 0;
        List<Integer> seven_numbers = new ArrayList<>();
        int i = 0;
        while (i < 5) {
            int number = rand.nextInt(9);
            seven_numbers.add(number);
            i += 1;
        }
        for(int j = 0; j < seven_numbers.size(); j++){
            sum += seven_numbers.get(j);
        }
        if(sum*7 % 7 == 0){
            for (Integer item : seven_numbers){
                nums += item.toString();
            };
            return key + nums;
        }
        else {
            return "Invalid key";
        }
    }
    public void generate_key() {
        String key;
        key = genDay();
        key = genYear(key);
        key = OEM(key);
        key = nums(key);
        if (key.equals("Invalid key!")) {
            generate_key();
        }
        else {
            System.out.println("Your key is: " + key);
        }

    }
    public static void main(String[] args) {
        win95OemKeyGen key = new win95OemKeyGen();
        key.generate_key();

    }
}
