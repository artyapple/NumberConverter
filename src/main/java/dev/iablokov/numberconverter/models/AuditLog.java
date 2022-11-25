package dev.iablokov.numberconverter.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

/**
 * audit record
 */
@Entity
@Data
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private java.util.Date timestamp;
    /** input data type */
    @Enumerated(value = EnumType.STRING)
    private DataFormat inputType;
    /** output value */
    private String inputValue;
    /** output data type */
    @Enumerated(value = EnumType.STRING)
    private DataFormat outputType;
    /** output value */
    private String outputValue;
}
