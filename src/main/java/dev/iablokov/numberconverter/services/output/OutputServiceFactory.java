package dev.iablokov.numberconverter.services.output;

import dev.iablokov.numberconverter.models.DataFormat;
import dev.iablokov.numberconverter.services.output.impl.IntegerToRomanService;
import org.springframework.stereotype.Service;

/**
 * output service factory
 */
@Service
public class OutputServiceFactory {
    /**
     * gets output service by type
     * @param type dataformat
     * @return output service
     */
    public OutputService getOutputService(DataFormat type){
        if(DataFormat.ROMAN.equals(type)){
            return new IntegerToRomanService();
        }
        throw new IllegalArgumentException("Not supported output type format.");
    }
}
