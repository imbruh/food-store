package br.edu.ifpb.padroes.service.log;

public class LogService {

    public LogService(LogHandler logHandler) {
        this.logHandler = logHandler;
    }

    private LogHandler logHandler;

    public void debug(String message) {
        logHandler.update("stack trace");
        logHandler.update(message);
    }

    public void info(String message) {
        logHandler.update(message);
    }
    public void error(String message) {
        logHandler.update("error");
        logHandler.update(message);
    }
}
