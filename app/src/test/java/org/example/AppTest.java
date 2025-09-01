package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GroceryCounterTest {

    @Test
    void testInitialState() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("$0.00", counter.total(), "Initial total should be $0.00");
        assertEquals(0, counter.overflows(), "Initial overflow count should be 0");
    }

    @Test
    void testSingleIncrements() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens();
        assertEquals("$10.00", counter.total());
        counter.ones();
        assertEquals("$11.00", counter.total());
        counter.tenths();
        assertEquals("$11.10", counter.total());
        counter.hundreths();
        assertEquals("$11.11", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testMultipleIncrementsWithoutOverflow() {
        GroceryCounter counter = new GroceryCounter();
        for (int i = 0; i < 35; i++) counter.ones();
        assertEquals("$35.00", counter.total());
        assertEquals(0, counter.overflows());
    }

   @Test
   void testOverflow() {
    GroceryCounter counter = new GroceryCounter();
    for (int i = 0; i < 10; i++) counter.tens(); // 10 × 1000 = 10000 → 1 overflow
    assertEquals("$0.00", counter.total());
    assertEquals(1, counter.overflows());
   }


    @Test
    void testClearMethod() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens();
        counter.ones();
        counter.tenths();
        counter.hundreths();
        counter.clear();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

  @Test
void testMultipleOverflows() {
    GroceryCounter counter = new GroceryCounter();
    for (int i = 0; i < 20000; i++) counter.hundreths(); // 20000 × 1 = 20000 → 2 overflows
    assertEquals("$0.00", counter.total());
    assertEquals(2, counter.overflows());
}
}
