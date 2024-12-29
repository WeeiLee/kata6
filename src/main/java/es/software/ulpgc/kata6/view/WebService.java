package es.software.ulpgc.kata6.view;

import es.software.ulpgc.kata6.control.CommandFactory;
import io.javalin.Javalin;

public class WebService {
    public static void execute(int port, CommandFactory factory){
        Javalin.create()
                .get("/calculate-BMI", context -> factory.build("calculate-BMI", context.req(), context.res()).execute())
                .get("/calculate-zodiac", context -> factory.build("calculate-zodiac", context.req(), context.res()).execute())
                .start(port);
    }
}
