package com.cbseassignment;

import junit.framework.TestCase;

public class Phase1InheritanceTest extends TestCase {
    public void testDogStoresAttributes() {
        Dog dog = new Dog("Milo", 3);

        assertEquals("Milo", dog.getName());
        assertEquals(3, dog.getAge());
    }

    public void testShibaInuInheritsDogBehavior() {
        ShibaInu shiba = new ShibaInu("Hana", 2);

        assertEquals("Hana", shiba.getName());
        assertEquals(2, shiba.getAge());
        assertEquals("Dog is eating", shiba.eat());
        assertEquals("Dog is sleeping", shiba.sleep());
    }
}
