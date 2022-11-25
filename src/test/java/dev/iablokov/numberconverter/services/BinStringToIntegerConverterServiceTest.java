package dev.iablokov.numberconverter.services;

import dev.iablokov.numberconverter.services.input.BinStringToIntegerConverterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinStringToIntegerConverterServiceTest {

    private BinStringToIntegerConverterService binStringToIntegerConverterService;

    @BeforeEach
    void setUp() {
        binStringToIntegerConverterService = new BinStringToIntegerConverterService();
    }

    @Test
    void convertToInteger() {
        assertEquals(71, binStringToIntegerConverterService.convert("01000111"));
    }


}