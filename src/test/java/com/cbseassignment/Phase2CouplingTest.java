package com.cbseassignment;

import junit.framework.TestCase;

public class Phase2CouplingTest extends TestCase {
    public void testToyDogCannotBark() {
        Dog dog = new ToyDog("Tiny", 1);

        assertEquals("...", dog.bark());
    }

    public void testDifferentBarkImplementations() {
        Dog pom = new Pomeranian("Puff", 4);
        Dog shiba = new ShibaInu("Hana", 2);

        assertEquals("Yip yip", pom.bark());
        assertEquals("Woof", shiba.bark());
    }

    public void testDifferentDisplayImplementations() {
        Dog toy = new ToyDog("Tiny", 1);
        Dog pom = new Pomeranian("Puff", 4);
        Dog shiba = new ShibaInu("Hana", 2);

        assertEquals("ToyDog: Tiny", toy.display());
        assertEquals("Pomeranian: Puff", pom.display());
        assertEquals("ShibaInu: Hana", shiba.display());
    }
}
