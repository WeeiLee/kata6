package es.software.ulpgc.kata6.view.adapter;

import es.software.ulpgc.kata6.control.command.BMICalculatorCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BMICalculatorRequestAdapter {
    public BMICalculatorCommand.Input inputFor(HttpServletRequest req){
        return new BMICalculatorCommand.Input() {
            @Override
            public double height() {
                return Double.parseDouble(req.getParameter("height"));
            }

            @Override
            public double weight() {
                return Double.parseDouble(req.getParameter("weight"));
            }
        };
    }

    public BMICalculatorCommand.Output outputFor(HttpServletResponse res){
        return result -> {
            try {
                res.getWriter().write(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
