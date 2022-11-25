package dev.iablokov.numberconverter.services.convert;

import dev.iablokov.numberconverter.models.DataFormat;
import dev.iablokov.numberconverter.services.input.InputService;
import dev.iablokov.numberconverter.services.input.InputServiceFactory;
import dev.iablokov.numberconverter.services.output.OutputServiceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConvertService {

    private final InputServiceFactory input;
    private final OutputServiceFactory output;

    public ConverterServiceImpl(InputServiceFactory input, OutputServiceFactory output) {
        this.input = input;
        this.output = output;
    }

    public String convert(DataFormat inpType, DataFormat outType, String value){
        return output.getOutputService(outType).convert(input.getInputService(inpType).convert(value));
    }
}
