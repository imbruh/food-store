package br.edu.ifpb.padroes.service.log;

import br.edu.ifpb.padroes.service.mail.NotificationListener;

public class LogHandler implements NotificationListener{

    public LogHandler(LogHandlerType type) {
        this.type = type;
    }

    public enum LogHandlerType { DATABASE, FILE}

    private LogHandlerType type;

    @Override
    public void update(String message) {
        if (type.equals(LogHandlerType.DATABASE)) {
            System.out.println("save data to database");
        } else if (type.equals(LogHandlerType.FILE)) {
            System.out.println("save data to a file");
        }
    }

}
