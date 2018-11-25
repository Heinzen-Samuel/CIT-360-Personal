package cit360acp;

import java.util.HashMap;

public class ApplicationController {
    private HashMap<String,Handler> handlerMap = new HashMap();

    public void handleRequest(String command){
        Handler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null){
            aCommandHandler.handleIt();
        }
    }

    public void mapCommand(String aCommand, Handler acHandler){
        handlerMap.put(aCommand,acHandler);
    }
}
