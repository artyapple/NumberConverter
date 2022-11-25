package dev.iablokov.numberconverter.services.output;

import dev.iablokov.numberconverter.models.DataFormat;
import org.springframework.stereotype.Service;

@Service
public class OutputServiceFactory {

    public OutputService getOutputService(DataFormat type){
        if(DataFormat.ROMAN.equals(type)){
            return new IntegerToRomanService();
        }
        throw new IllegalArgumentException("Not supported input data format.");
    }
}
