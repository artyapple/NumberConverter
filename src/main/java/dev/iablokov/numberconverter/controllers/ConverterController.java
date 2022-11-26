package dev.iablokov.numberconverter.controllers;

import dev.iablokov.numberconverter.models.ConvertRequest;
import dev.iablokov.numberconverter.models.ConvertResponse;
import dev.iablokov.numberconverter.services.audit.AuditLogService;
import dev.iablokov.numberconverter.services.convert.ConvertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@Slf4j
public class ConverterController {
    private final AuditLogService auditLogService;
    private final ConvertService convertService;

    public ConverterController(AuditLogService auditLogServiceImpl, ConvertService convertService) {
        this.auditLogService = auditLogServiceImpl;
        this.convertService = convertService;
    }

    @PostMapping("/convert")
    public ConvertResponse convert(@RequestBody ConvertRequest request){
        String result = null;
        try {
            result = convertService.convert(request.getInputType(), request.getOutputType(), request.getValue());
        } catch (IllegalArgumentException e){
            result = e.getMessage();
            throw e;
        } finally {
            auditLogService.addAuditLogEntry(request.getInputType(), request.getValue(), request.getOutputType(), result);
        }
        return new ConvertResponse(result);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
