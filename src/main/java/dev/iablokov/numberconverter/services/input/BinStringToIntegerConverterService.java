package dev.iablokov.numberconverter.services.input;

import org.springframework.stereotype.Service;

@Service
public class BinStringToIntegerConverterService implements InputService {

    @Override
    public Integer convert(String value) {
        return Integer.parseInt(value, 2);
    }
}
