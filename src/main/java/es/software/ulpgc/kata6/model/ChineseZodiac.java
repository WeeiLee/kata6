package es.software.ulpgc.kata6.model;

public class ChineseZodiac {
    public enum signs{
        RAT, OX, TIGER, RABBIT, DRAGON, SNAKE, HORSE, GOAT, MONKEY, ROOSTER, DOG, PIG
    }

    public static String calculateZodiac(String year){
        if (year == null) return null;
        int index = (Integer.parseInt(year) - 1900) % 12;
        if (index < 0) index += 12;
        return signs.values()[index].name();
    }
}
