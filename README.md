# Learn Design Pattern: Composition Over Inheritance

A hands-on TDD exercise teaching the Strategy Pattern through four progressive phases.

## Running Tests

Run a specific phase:
```bash
mvn -Dtest=Phase1InheritanceTest test
mvn -Dtest=Phase2CouplingTest test
mvn -Dtest=Phase3InterfaceDecouplingTest test
mvn -Dtest=Phase4CompositionStrategyTest test
```

Run all tests:
```bash
mvn test
```

---

## Phase 1: Inheritance Basics

**Background:** Create a `Dog` class with common attributes and a `ShibaInu` subclass that inherits from it.

**Objective:** Revise Abstraction, Encapsulation, and Polymorphism.

**How the exercise supports this:**
- **Abstraction** — The `Dog` class generalizes common dog features (`name`, `age`, `eat()`, `sleep()`), hiding irrelevant details.
- **Encapsulation** — Private fields with getters protect internal state. The test calls `getName()` and `getAge()` instead of accessing fields directly.
- **Polymorphism** — `ShibaInu` is-a `Dog`. The test treats a `ShibaInu` as a `Dog` and expects inherited methods to work identically.

---

## Phase 2: Subtype Differences

**Background:** Add `ToyDog`, `Pomeranian`, and `ShibaInu` with different `bark()` and `display()` implementations.

**Objective:** Understand tight coupling—changing behavior requires editing every subclass.

**How the exercise supports this:**
- Each subclass must override `bark()` and `display()` with different logic.
- Adding a new dog type means writing yet another subclass and duplicating the pattern.
- Changing how barking works globally requires touching every subclass—this is **coupling**.

---

## Phase 3: Interface Decoupling

**Background:** Introduce a `Barkable` interface. Only barking dogs implement it; `ToyDog` does not.

**Objective:** Learn decoupling, easier testing, and runtime flexibility.

**How the exercise supports this:**
- `Barkable` separates "can bark" from "is a dog." `ToyDog` no longer pretends to bark.
- Tests check `instanceof Barkable` to verify capability without knowing the concrete class.
- Decoupling makes unit tests simpler: you can mock or swap a `Barkable` implementation without changing the dog hierarchy.

---

## Phase 4: Composition (Strategy Pattern)

**Background:** Make `Dog` abstract with a `BarkBehavior` field. Delegate `performBark()` to the behavior object.

**Objective:** Favor composition over inheritance—swap behaviors at runtime without changing class hierarchies.

**How the exercise supports this:**
- `Dog` holds a `BarkBehavior` field instead of implementing `bark()` directly. Behavior is **injected**, not inherited.
- `performBark()` delegates to the behavior object. The dog doesn't know *how* to bark—only *who* to ask.
- `setBarkBehavior(...)` allows changing behavior at runtime.
- Adding a new bark style requires only a new class implementing `BarkBehavior`—no subclass explosion.
