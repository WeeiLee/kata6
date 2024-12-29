package es.software.ulpgc.kata6.view.adapter;

import es.software.ulpgc.kata6.control.command.ZodiacCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ZodiacRequestAdapter {
    public ZodiacCommand.Input inputFor(HttpServletRequest req){
        return () -> req.getParameter("year");
    }

    public ZodiacCommand.Output outputFor(HttpServletResponse res){
        return result -> {
            try {
                res.getWriter().write(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
