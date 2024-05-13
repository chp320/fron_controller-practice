package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HandlerKey;

public interface Handlermapping {
    Object findHandler(HandlerKey handlerKey);
}
