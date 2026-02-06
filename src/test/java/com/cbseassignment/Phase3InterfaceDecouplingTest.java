package com.cbseassignment;

import junit.framework.TestCase;

public class Phase3InterfaceDecouplingTest extends TestCase {
    public void testOnlySomeDogsAreBarkable() {
        Dog toy = new ToyDog("Tiny", 1);
        Dog pom = new Pomeranian("Puff", 4);
        Dog shiba = new ShibaInu("Hana", 2);

        assertFalse(toy instanceof Barkable);
        assertTrue(pom instanceof Barkable);
        assertTrue(shiba instanceof Barkable);
    }

    public void testBarkableDogsBark() {
        Barkable pom = new Pomeranian("Puff", 4);
        Barkable shiba = new ShibaInu("Hana", 2);

        assertEquals("Yip yip", pom.bark());
        assertEquals("Woof", shiba.bark());
    }

    public void testDisplayIsRequiredOnAllDogs() {
        Dog toy = new ToyDog("Tiny", 1);
        Dog pom = new Pomeranian("Puff", 4);
        Dog shiba = new ShibaInu("Hana", 2);

        assertEquals("ToyDog: Tiny", toy.display());
        assertEquals("Pomeranian: Puff", pom.display());
        assertEquals("ShibaInu: Hana", shiba.display());
    }
}
