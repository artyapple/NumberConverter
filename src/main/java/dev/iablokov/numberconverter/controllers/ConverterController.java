package dev.iablokov.numberconverter.controllers;

import dev.iablokov.numberconverter.models.ConvertRequest;
import dev.iablokov.numberconverter.models.ConvertResponse;
import dev.iablokov.numberconverter.services.audit.AuditLogService;
import dev.iablokov.numberconverter.services.convert.ConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class ConverterController {
    private final AuditLogService auditLogService;
    private final ConverterService convertService;

    public ConverterController(AuditLogService auditLogServiceImpl, ConverterService convertService) {
        this.auditLogService = auditLogServiceImpl;
        this.convertService = convertService;
    }

    @PostMapping("/convert")
    public ConvertResponse convert(@Valid @RequestBody ConvertRequest request){
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleIllegalArgumentException(MethodArgumentNotValidException ex){
        Map<String, List<String>> errors = new HashMap<>();
        errors.put("message", ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
