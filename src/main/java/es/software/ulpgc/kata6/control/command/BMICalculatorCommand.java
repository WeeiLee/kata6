package es.software.ulpgc.kata6.control.command;

import es.software.ulpgc.kata6.model.BMICalculator;
import es.software.ulpgc.kata6.model.PersonStature;

public class BMICalculatorCommand implements Command{
    private final Input input;
    private final Output output;

    public BMICalculatorCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        output.classification(getClassification());
    }

    private String getClassification() {
        return BMICalculator.classify(new PersonStature(input.height(), input.weight()));
    }

    public interface Input{
        double height();
        double weight();
    }

    public interface Output{
        void classification(String result);
    }

}
