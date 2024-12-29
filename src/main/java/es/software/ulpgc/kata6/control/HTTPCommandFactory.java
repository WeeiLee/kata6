package es.software.ulpgc.kata6.control;

import es.software.ulpgc.kata6.control.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class HTTPCommandFactory implements CommandFactory{
    private final Map<String, Builder> builders;

    public HTTPCommandFactory() {
        builders = new HashMap<>();
    }

    @Override
    public Command build(String name, HttpServletRequest req, HttpServletResponse res) {
        return builders.get(name).build(req, res);
    }

    @Override
    public void register(String name, Builder builder) {
        builders.put(name, builder);
    }
}
