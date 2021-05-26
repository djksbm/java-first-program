package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits(){
        float sum = 0.0f;
        for (float c : credits)
            sum+= c;
        return sum;
    }
    private float sumOfDebits(){
        float sum = 0.0f;
        for (float c : debits)
            sum+= c;
        return sum;
    }
    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth =  yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate(){
        return sumOfCredits() - sumOfDebits();
    }

    public static void main(String[] args) {
        String [] creditsAsString = args[0].split(",");
        String [] debitsAsString = args[1].split(",");
        float credits[] = new float[creditsAsString.length];
        for (int c = 0; c < creditsAsString.length; c++){
            credits[c] = Utilities.getFloatValue(creditsAsString[c]);
        }
        float debits[] = new float[debitsAsString.length];
        for (int c = 0; c < debitsAsString.length; c++){
            debits[c] = Utilities.getFloatValue(debitsAsString[c]);
        }
        SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}
