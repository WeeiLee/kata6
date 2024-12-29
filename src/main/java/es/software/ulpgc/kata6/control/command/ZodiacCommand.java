package es.software.ulpgc.kata6.control.command;
import es.software.ulpgc.kata6.model.ChineseZodiac;

public class ZodiacCommand implements Command {
    private final Input input;
    private final Output output;

    public ZodiacCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        output.zodiac(getZodiac());
    }

    private String getZodiac() {
        return ChineseZodiac.calculateZodiac(input.year());
    }

    public interface Input{
        String year();
    }

    public interface Output{
        void zodiac(String result);
    }
}
