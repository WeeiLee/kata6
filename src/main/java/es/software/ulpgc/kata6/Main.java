package es.software.ulpgc.kata6;

import es.software.ulpgc.kata6.control.*;
import es.software.ulpgc.kata6.control.command.BMICalculatorCommand;
import es.software.ulpgc.kata6.control.command.ZodiacCommand;
import es.software.ulpgc.kata6.view.adapter.BMICalculatorRequestAdapter;
import es.software.ulpgc.kata6.view.WebService;
import es.software.ulpgc.kata6.view.adapter.ZodiacRequestAdapter;


public class Main {
    public static void main(String[] args) {
        CommandFactory factory = new HTTPCommandFactory();
        factory.register("calculate-BMI", BMICommandBuilder());
        factory.register("calculate-zodiac", zodiacCommandBuilder());
        WebService.execute(8080, factory);
    }

    private static CommandFactory.Builder zodiacCommandBuilder() {
        return (req, res) -> {
            ZodiacRequestAdapter adapter = new ZodiacRequestAdapter();
            ZodiacCommand.Input input = adapter.inputFor(req);
            ZodiacCommand.Output output = adapter.outputFor(res);
            return new ZodiacCommand(input, output);
        };
    }

    private static CommandFactory.Builder BMICommandBuilder() {
        return (req, res) -> {
            BMICalculatorRequestAdapter adapter = new BMICalculatorRequestAdapter();
            BMICalculatorCommand.Input input = adapter.inputFor(req);
            BMICalculatorCommand.Output output = adapter.outputFor(res);
            return new BMICalculatorCommand(input, output);
        };
    }
}
