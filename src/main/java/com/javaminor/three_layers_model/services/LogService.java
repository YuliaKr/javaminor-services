package com.javaminor.three_layers_model.services;

import com.javaminor.three_layers_model.repositories.LogRepository;
import com.javaminor.three_layers_model.repositories.entities.PerformanceLog;
import org.springframework.stereotype.Service;

@Service
public class LogService implements ILogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void Log(long startTime, long endTime, String className, String methodName) {
        long duration = startTime - endTime;
        var log = new PerformanceLog();
        log.setDurationMs(duration);
        log.setCallingClass(className);
        log.setCallingMethod(methodName);
        logRepository.save(log);
    }
}
