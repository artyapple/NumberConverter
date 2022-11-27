package dev.iablokov.numberconverter.services.output.impl;

import dev.iablokov.numberconverter.services.output.OutputService;
import org.springframework.stereotype.Service;

/**
 * output converter
 * decimal integer to roman string
 */
@Service
public class IntegerToRomanService implements OutputService {
    private final int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private final String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private final StringBuilder roman;

    public IntegerToRomanService() {
        this.roman = new StringBuilder();
    }

    @Override
    public String convert(Integer num) {

        if(num < 1 || num > 3999){
            throw new IllegalArgumentException("Roman numerals can't be less than 1 and greather than 3999.");
        }

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();
    }

}
