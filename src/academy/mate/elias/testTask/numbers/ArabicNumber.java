package academy.mate.elias.testTask.numbers;

import academy.mate.elias.testTask.exceptions.CalculatorInputException;

public class ArabicNumber extends AllowedNumber {
    private String numberString;

    public ArabicNumber (String numberString) {
        this.numberString = numberString;
    }

    @Override
    public int toInteger() {
        /**
         * Returns decimal representation of Arabic Number,
         * if its' value is less than or equal 10.
         */
        int number = Integer.parseInt(this.numberString);
        if (number > 10) throw new CalculatorInputException("Numbers with value more than 10 doesn't support.");
        return number;
    }
}