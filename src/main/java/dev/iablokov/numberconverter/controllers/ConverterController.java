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

import javax.transaction.Transactional;
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
    @Transactional
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
}
