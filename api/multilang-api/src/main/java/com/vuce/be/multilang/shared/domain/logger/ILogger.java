package com.vuce.be.multilang.shared.domain.logger;

public interface ILogger {
    void trace(String message);
    void debug(String message);
    void info(String message);
    void warn(String message);
    void trace(String message, Class<?> type);
    void debug(String message, Class<?> type);
    void info(String message, Class<?> type);
    void warn(String message, Class<?> type);
}
