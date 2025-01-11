import java.util.*;

public class win95OemKeyGen {
    //Random instance
    Random rand = new Random();

    //Generates a day of the year and adds it to the string.
    private String genDay() {
        int min = 001;
        int max = 366;
        int combo = rand.nextInt((max-min)+1)+min;
        return String.format("%03d", combo);
    }
    //Concatenates a year onto the string.
    private String genYear(String key) {
            ArrayList<String> valid_years = new ArrayList<>(Arrays.asList("95","96","97","98","99","00","01","02"));
            return key + valid_years.get(rand.nextInt(valid_years.size()));
        }

    //Concatenates OEM to key.
    private String OEM(String key) {
        return key + "-OEM-";
    }

    //Mostly the same as the old keygen, except nums has to start with "00" for it to be a valid key.
    private String mult7(String key) {
       StringBuilder nums = new StringBuilder("00");
        int sum = 0;
        List<Integer> seven_numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int number = rand.nextInt(9);
            seven_numbers.add(number);
            sum += number;
        }
        if(sum % 7 == 0){
            for (Integer item : seven_numbers){
                nums.append(item.toString());
            };
            return key + nums;
        }
        return "Invalid key";
    }

    public String randomNums(String key) {
        StringBuilder nums = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            nums.append(String.valueOf(rand.nextInt(10)));
        }
        return key + "-" + nums;
    }
    public void generate_key() {
        String key = "";
        boolean validKey = false;
        while (!validKey) {
            key = genDay();
            key = genYear(key);
            key = OEM(key);
            key = mult7(key);
            if (!key.equals("Invalid key")) {
                validKey = true;
                key = randomNums(key);
            }
        }
        System.out.println("Your key is: " + key);

    }
    public static void main(String[] args) {
        win95OemKeyGen key = new win95OemKeyGen();
        key.generate_key();

    }
}
