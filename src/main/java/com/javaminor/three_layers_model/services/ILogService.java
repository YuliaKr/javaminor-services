package com.javaminor.three_layers_model.services;

public interface ILogService {
    void Log(long startTime, long endTime, String className, String methodName);
}
