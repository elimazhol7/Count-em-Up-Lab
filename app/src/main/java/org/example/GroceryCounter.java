package org.example;
public class GroceryCounter {
    private int counter;       // 0 to 9999
    private int overflowCount; // number of times counter exceeded 9999

    // Constructor
    public GroceryCounter() {
        counter = 0;
        overflowCount = 0;
    }

    // Increment methods
    public void tens() {
        addToCounter(1000);
    }

    public void ones() {
        addToCounter(100);
    }

    public void tenths() {
        addToCounter(10);
    }

    public void hundreths() {
        addToCounter(1);
    }

    // Helper to handle increment and overflow
   private void addToCounter(int value) {
    counter += value;
    if (counter >= 10000) {
        int overflowsThisStep = counter / 10000; // calculate number of overflows
        overflowCount += overflowsThisStep;
        counter %= 10000; // reset counter to remainder
    }

    }

    // Showing total in $ format
    public String total() {
        int dollars = counter / 100;
        int cents = counter % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    // returning overflow count
    public int overflows() {
        return overflowCount;
    }

    // clearing the counter and overflow
    public void clear() {
        counter = 0;
        overflowCount = 0;
    }
}
