package es.software.ulpgc.kata6.model;

public class BMICalculator {
    public static String classify(PersonStature stature){
        double BMI = calculateBMI(stature);
        String res = "Your BMI is : " + BMI + "\nClassification : ";
        if (BMI < 16) {
            return res + "Severe Thinness";
        } else if (BMI >= 16 && BMI < 17) {
            return res + "Moderate Thinness";
        } else if (BMI >= 17 && BMI < 18.5) {
            return res + "Mild Thinness";
        } else if (BMI >= 18.5 && BMI < 25) {
            return res + "Normal";
        } else if (BMI >= 25 && BMI < 30) {
            return res + "Overweight";
        } else if (BMI >= 30 && BMI < 35) {
            return res + "Obese Class I";
        } else if (BMI >= 35 && BMI < 40) {
            return res + "Obese Class II";
        } else {
            return res + "Obese Class III";
        }
    }

    private static double calculateBMI(PersonStature stature) {
        return stature.weight() / Math.pow(stature.height(), 2);
    }
}
