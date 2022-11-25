package dev.iablokov.numberconverter.services.output;

/**
 * output service interface
 */
public interface OutputService {

    /**
     * converts value to String
     * @param value integer value
     * @return string value
     */
    String convert(Integer value);
}
