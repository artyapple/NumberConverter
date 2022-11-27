package dev.iablokov.numberconverter.models;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * data formats
 */
public enum DataFormat {
    DECIMAL, BINARY, ROMAN;

    @JsonCreator
    public static DataFormat getDataFormat(String value) {
        for (DataFormat df : DataFormat.values()) {

            if (df.name().equalsIgnoreCase(value)) {
                return df;
            }
        }
        throw new IllegalArgumentException(value + " isn't supported data format.");
    }
}
