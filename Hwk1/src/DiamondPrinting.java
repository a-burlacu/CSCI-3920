
public class DiamondPrinting {

    //Define method getCharSequence, takes 2 args:(String s, int n) returns String, str, of n times String s
    public String getCharSequence(String s, int n) {
        String str = "";
        for(int i = 0; i < n; i++) {
             str = str + s;
         }
        return str;
    }
    //Define method getDiamond, takes one arg, int num (odd num of rows) returns String representing diamond
    public String getDiamond(int num) {

        String result = "";

        //number must be odd and between 1 and 99
        if (num % 2 == 1 && num <= 99) {

            // i represents number of *'s and j represents number of leading spaces
            // for top half of diamond:
            for (int i = 1, j = (num / 2); i <= num; i += 2, j--) {
                result = result + getCharSequence(" ", j) + getCharSequence("*", i) + "\n";
            }
            // for bottom half of diamond:
            for (int i = (num - 2), j = 1; i > 0; i -= 2, j++) {
                result = result + getCharSequence(" ", j) + getCharSequence("*", i) + "\n";
            }
        }
        //if input is invalid, return empty String
        return result;
    }

    // create an object of DiamondPrinter and use it to try the getDiamond method.
    public static void main(String[] args) {

        //Create class object
        DiamondPrinting diamond = new DiamondPrinting();

        //Call getDiamond method
        System.out.print(diamond.getDiamond(5));
        System.out.print(diamond.getDiamond(11));
    }

}
