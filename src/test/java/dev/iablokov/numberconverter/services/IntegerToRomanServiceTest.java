package dev.iablokov.numberconverter.services;

import dev.iablokov.numberconverter.services.output.IntegerToRomanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {IntegerToRomanService.class})
class IntegerToRomanServiceTest {

    //@Autowired
    private IntegerToRomanService integerToRomanService;

    @BeforeEach
    void setUp() {
        integerToRomanService = new IntegerToRomanService();
    }

    @Test
    void integerToRoman() {
        assertEquals("MXXIII",integerToRomanService.convert(1023));
    }

    @Test
    void minValidValue() {
        assertEquals("I",integerToRomanService.convert(1));
    }

    @Test
    void maxValidValue() {
        assertEquals("MMMCMXCIX",integerToRomanService.convert(3999));
    }

    @Test
    void minInvalidValue(){
        assertThrows(IllegalArgumentException.class, ()-> {integerToRomanService.convert(0);});
    }

    @Test
    void maxInvalidValue(){
        assertThrows(IllegalArgumentException.class, ()-> {integerToRomanService.convert(4000);});
    }
}