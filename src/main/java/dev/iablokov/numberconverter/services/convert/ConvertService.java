package dev.iablokov.numberconverter.services.convert;

import dev.iablokov.numberconverter.models.DataFormat;

public interface ConvertService<T, R> {
    /**
     * gets result with type outType for value with inpType
     * @param inpType input type
     * @param outType output type
     * @param value
     * @return result as String
     */
    public String convert(DataFormat inpType, DataFormat outType, String value);
}
