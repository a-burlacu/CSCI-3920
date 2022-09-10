import java.util.Calendar;

public class HealthRecord {

    //initializing class attributes
    private String firstName, lastName;
    private char gender;
    private int dobDay, dobMonth, dobYear, height, weight;

    //class constructor
    public HealthRecord(String firstName, String lastName, char gender, int dobDay,
                        int dobMonth, int dobYear, int height, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dobDay = dobDay;
        this.dobMonth = dobMonth;
        this.dobYear = dobYear;
        this.height = height;
        this.weight = weight;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public char getGender() {
        return gender;
    }
    public int getDobDay() {
        return dobDay;
    }
    public int getDobMonth() {
        return dobMonth;
    }
    public int getDobYear() {
        return dobYear;
    }
    public int getHeight() {
        return height;
    }
    public int getWeight() {
        return weight;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setDOB(int day, int month, int year) {
        dobDay = day;
        dobMonth = month;
        dobYear = year;
    }

    // Computes person's age
    public int getAge() {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - dobYear;
    }

    // Computes person's max HR
    public int getMaximumHeartRate() {

        return 220 - getAge();

    }

    // Computes person's minimum and maximum HR recommended when exercising
    public String getTargetHeartRate() {

        int minTarget = (int) (0.5 * getMaximumHeartRate());
        int maxTarget = (int) (0.85 * getMaximumHeartRate());

        return String.format("%d - %d", minTarget, maxTarget);
    }

    // Computes person's BMI
    public float getBMI() {
        return (float) (weight * 703)/(height * height);
    }

    // Special printing method
    public String toString() {
       return String.format("Name:%s, %s. Gender:%c DOB:%02d/%02d/%4d AGE:%3d H:%3din. W:%3dlb., MHR:%3d, THR:%s, " +
               "BMI:%.2f",lastName,firstName,gender,dobMonth,dobDay,dobYear,getAge(),height,weight,
               getMaximumHeartRate(),getTargetHeartRate(),getBMI());
    }

    // Driver method for instantiating class
    public static void main(String[] args) {

        HealthRecord hr = new HealthRecord("John","Doe",'M', 1,3,1990,70,180);
        System.out.println(hr);

        hr = new HealthRecord("Jane","Doe",'F', 20,5,1995,60,150);
        System.out.println(hr);

    }
}
