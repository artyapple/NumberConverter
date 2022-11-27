package dev.iablokov.numberconverter.services.input;

import dev.iablokov.numberconverter.models.DataFormat;
import dev.iablokov.numberconverter.services.input.impl.BinStringToIntegerConverterService;
import dev.iablokov.numberconverter.services.input.impl.DecStringToIntegerConverterService;
import org.springframework.stereotype.Service;

/**
 * input service factory
 */
@Service
public class InputServiceFactory {

    /**
     * gets input service by type
     * @param type dataformat
     * @return input service
     */
    public InputService getInputService(DataFormat type){
        if(DataFormat.DECIMAL.equals(type)){
            return new DecStringToIntegerConverterService();
        } else if(DataFormat.BINARY.equals(type)){
            return new BinStringToIntegerConverterService();
        }
        throw new IllegalArgumentException("Not supported input type format.");
    }
}
