package dev.iablokov.numberconverter.services.input.impl;

import dev.iablokov.numberconverter.services.input.InputService;
import org.springframework.stereotype.Service;

/**
 * input converter
 * decimal string to decimal integer
 */
@Service
public class DecStringToIntegerConverterService implements InputService {

    @Override
    public Integer convert(String value) {
        Integer result;
        try{
            result = Integer.parseInt(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Decimal value "+value + " can't be converted to natural number.");
        }
        return result;
    }
}
