package org.example;
public class App {
    public static void main(String[] args) {
        GroceryCounter counter = new GroceryCounter();

        System.out.println(counter.total()); // $0.00

        counter.tens();
        counter.tens();
        counter.hundreths();

        System.out.println(counter.total()); // $20.01
        System.out.println(counter.overflows()); // 0

        for(int i = 0; i < 35; i++) counter.ones();
        System.out.println(counter.total()); // $55.01
        System.out.println(counter.overflows()); // 0

        for(int i = 0; i < 100; i++) counter.ones();
        System.out.println(counter.total()); // $55.01
        System.out.println(counter.overflows()); // 1

        counter.clear();
        System.out.println(counter.total()); // $0.00
        System.out.println(counter.overflows()); // 0
    }
}
