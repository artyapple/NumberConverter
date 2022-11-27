package dev.iablokov.numberconverter.services.convert.impl;

import dev.iablokov.numberconverter.models.DataFormat;
import dev.iablokov.numberconverter.services.convert.ConverterService;
import dev.iablokov.numberconverter.services.input.InputServiceFactory;
import dev.iablokov.numberconverter.services.input.impl.DecStringToIntegerConverterService;
import dev.iablokov.numberconverter.services.output.OutputServiceFactory;
import dev.iablokov.numberconverter.services.output.impl.IntegerToRomanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

class ConverterServiceImplTest {

    @Mock
    private OutputServiceFactory output;
    @Mock
    private InputServiceFactory input;

    private ConverterService converter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        converter = new ConverterServiceImpl(input, output);
    }

    @Test
    void convert() {
        String test = "5";
        when(input.getInputService(DataFormat.DECIMAL)).thenReturn(new DecStringToIntegerConverterService());
        when(output.getOutputService(DataFormat.ROMAN)).thenReturn(new IntegerToRomanService());
        assertEquals("V", converter.convert(DataFormat.DECIMAL,DataFormat.ROMAN, test));
    }
}