package com.cbseassignment;

import junit.framework.TestCase;

public class Phase4CompositionStrategyTest extends TestCase {
    public void testPerformBarkDelegatesToBehavior() {
        Dog shiba = new ShibaInu("Hana", 2, new LoudBark());

        assertEquals("Woof", shiba.performBark());
    }

    public void testCanSwitchBarkBehaviorAtRuntime() {
        Dog pom = new Pomeranian("Puff", 4, new SoftBark());

        assertEquals("Yip yip", pom.performBark());

        pom.setBarkBehavior(new SilentBark());
        assertEquals("...", pom.performBark());
    }

    public void testToyDogUsesSilentBehavior() {
        Dog toy = new ToyDog("Tiny", 1, new SilentBark());

        assertEquals("...", toy.performBark());
        assertEquals("ToyDog: Tiny", toy.display());
    }
}
