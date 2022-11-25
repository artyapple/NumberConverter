package dev.iablokov.numberconverter.models;

import lombok.Data;

/**
 * request
 */
@Data
public class ConvertRequest {
    private DataFormat inputType;
    private String value;
    private DataFormat outputType;
}
