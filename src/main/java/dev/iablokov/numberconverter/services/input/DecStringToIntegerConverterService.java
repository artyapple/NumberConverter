package dev.iablokov.numberconverter.services.input;

import org.springframework.stereotype.Service;

@Service
public class DecStringToIntegerConverterService implements InputService {

    @Override
    public Integer convert(String value) {
        return Integer.parseInt(value);
    }
}
