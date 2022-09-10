
public class PythagoreanTriples {

    //Define new method, isTriple, receives 3 ints, returns T/F if a^2 + b^2 = c^2
    public boolean isTriple(int a, int b, int c) {

        int a2 = (int)Math.pow(a,2);
        int b2 = (int)Math.pow(b,2);
        int c2 = (int)Math.pow(c,2);

        return a2 + b2 == c2;
    }

    //Define new method, listOfTriples, takes 6 ints, returns String of all triples between [aMin,aMax],[bMin,bMax],[cMin,cMax]
    public String listOfTriples(int aMin, int bMin, int cMin, int aMax, int bMax, int cMax) {

        String result = "";

        //within a range from aMin to aMax
        for(int a = aMin; a <= aMax; a++) {
            for(int b = bMin ; b <= bMax; b++) {
                for(int c = cMin; c<= cMax; c++) {
                    // first, check aMin, bMin, cMin with isTriple
                    if(isTriple(a,b,c)) {
                        // if true, add values to str
                        // if false, loop again with a++,b++,c++ until aMax, bMax, cMax

                        result = result + String.format("%s %s %s\n", a, b, c);
                    }
                }
            }
        }
        return result;
    }

    // create an object of PythagoreanTriples and try listOfTriples method
    public static void main(String[] args) {
        //Create class object
        PythagoreanTriples triples = new PythagoreanTriples();

        //call listOfTriples method
        System.out.print(triples.listOfTriples(1,2,3,100,10,20));
    }
}
