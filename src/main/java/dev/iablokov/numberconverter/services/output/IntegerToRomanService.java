package dev.iablokov.numberconverter.services.output;


public class IntegerToRomanService implements OutputService {

    private final StringBuilder roman;

    public IntegerToRomanService() {
        this.roman = new StringBuilder();
    }

    public String convert(int num) {

        if(num < 1 || num > 3999){
            throw new IllegalArgumentException("Roman numberals can't be less than 1 and greather than 3999.");
        }

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        System.out.println("Roman: " + roman.toString());
        System.out.println("---------------------------------------------------");

        return roman.toString();
    }

}
