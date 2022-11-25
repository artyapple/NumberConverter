package dev.iablokov.numberconverter.services.input;

import dev.iablokov.numberconverter.models.DataFormat;
import org.springframework.stereotype.Service;

@Service
public class InputServiceFactory {

    public InputService getInputService(DataFormat type){
        if(DataFormat.DECIMAL.equals(type)){
            return new DecStringToIntegerConverterService();
        } else if(DataFormat.BINARY.equals(type)){
            return new BinStringToIntegerConverterService();
        }
        throw new IllegalArgumentException("Not supported input data format.");
    }
}
