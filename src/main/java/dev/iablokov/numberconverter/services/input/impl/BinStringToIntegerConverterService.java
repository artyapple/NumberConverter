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
        return Integer.parseInt(value, 2);
    }
}
