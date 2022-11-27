package dev.iablokov.numberconverter.services.input.impl;

import dev.iablokov.numberconverter.services.input.InputService;
import org.springframework.stereotype.Service;

/**
 * input converter
 * binary string to decimal integer
 */
@Service
public class BinStringToIntegerConverterService implements InputService {

    @Override
    public Integer convert(String value) {
        Integer result;
        try {
            result = Integer.parseInt(value, 2);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("Binary value "+value + " can't be converted to natural number.");
        }
        return result;
    }
}
