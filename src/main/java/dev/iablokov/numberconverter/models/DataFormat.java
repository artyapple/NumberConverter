package dev.iablokov.numberconverter.models;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * data formats
 */
public enum DataFormat {
    DECIMAL, BINARY, ROMAN;

    @JsonCreator
    public static DataFormat getDepartmentFromCode(String value) {
        for (DataFormat df : DataFormat.values()) {

            if (df.name().equalsIgnoreCase(value)) {
                return df;
            }
        }
        return null;
    }
}
