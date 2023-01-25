package dev.iablokov.numberconverter.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * request
 */
@Data
@AllArgsConstructor
public class ConvertRequest {
    @NotNull(message="Please provide a valid inputType")
    private DataFormat inputType;
    @NotNull(message="Please provide a valid value")
    private String value;
    @NotNull(message="Please provide a valid outputType")
    private DataFormat outputType;
}
