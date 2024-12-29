package es.software.ulpgc.kata6.control;

import es.software.ulpgc.kata6.control.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CommandFactory {
    Command build(String name, HttpServletRequest req, HttpServletResponse res);
    void register(String name, Builder builder);

    interface Builder{
        Command build(HttpServletRequest req, HttpServletResponse res);
    }
}
