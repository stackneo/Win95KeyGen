import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    //TODO: Implement year between 95-2003. (Could do through input).
    private String genYear(String key) {
        return key + "95";
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
        if(sum % 7 == 0){
            for (Integer item : seven_numbers){
                nums += item.toString();
            };
            return key + nums;
        }
        else {
            nums(key);
        }
        return "Try Again!";
    }
    public String generate_key() {
        String key;
        key = genDay();
        key = genYear(key);
        key = OEM(key);
        key = nums(key);
        return key;

    }
    public static void main(String[] args) {
        win95OemKeyGen key = new win95OemKeyGen();
        System.out.println(key.generate_key());

    }
}
