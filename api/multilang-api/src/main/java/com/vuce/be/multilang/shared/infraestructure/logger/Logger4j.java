package com.vuce.be.multilang.shared.infraestructure.logger;

import com.vuce.be.multilang.MultilangApiApplication;
import com.vuce.be.multilang.shared.domain.logger.ILogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Logger4j implements ILogger {

    private static final Logger log = LogManager.getLogger(MultilangApiApplication.class);

    @Override
    public void trace(String message) {
        log.trace(message);
    }

    @Override
    public void debug(String message) {
        log.debug(message);
    }

    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void warn(String message) {
        log.warn(message);
    }

    @Override
    public void trace(String message, Class<?> type) {
        getLogger(type).trace(message);
    }

    @Override
    public void debug(String message, Class<?> type) {
        getLogger(type).debug(message);
    }

    @Override
    public void info(String message, Class<?> type) {
        getLogger(type).info(message);
    }

    @Override
    public void warn(String message, Class<?> type) {
        getLogger(type).warn(message);
    }

    private Logger getLogger(Class<?> type) {
        return LogManager.getLogger(type);
    }
}
