package academy.mate.elias.testTask.numbers;

import academy.mate.elias.testTask.exceptions.CalculatorInputException;

public class RomanNumber extends AllowedNumber {

    private String numberString;

    public RomanNumber(String numberString) {
        this.numberString = numberString;
    }

    @Override
    public int toInteger() {
        /**
         * Returns decimal representation of Roman Number,
         * if it has correct form and its' value is less than zero
         */
        switch(this.numberString) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: throw new CalculatorInputException("Incorrect or unsupported roman number");
        }
    }
}
