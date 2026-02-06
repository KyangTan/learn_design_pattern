# Design Pattern Teaching Phases

This sequence uses a "Dog" example to move from inheritance to composition. Each phase has a short problem statement and a matching unit test class. Run phases one at a time.

## Phase 1: Inheritance Refresher

Problem statement:
- Create a `Dog` class that stores common dog attributes and behaviors.
- Create a `ShibaInu` class that inherits from `Dog` to avoid code duplication.
- `Dog` must store `name` and `age` and provide getters.
- `Dog` must provide common behaviors `eat()` and `sleep()`.
- `ShibaInu` should inherit these behaviors without re-implementing them.

Objective:
- Revise OOP concepts: Abstraction (generalize dog features), Encapsulation (private fields with getters), and Polymorphism (subclasses behaving like `Dog`).

Tests:
- Phase1InheritanceTest

Run:
- mvn -Dtest=Phase1InheritanceTest test

## Phase 2: Subtype Differences and Coupling

Problem statement:
- Different dog subtypes should behave differently.
- Implement `ToyDog`, `Pomeranian`, and `ShibaInu` as subclasses of `Dog`.
- Each subtype must implement `display()` returning:
  - "ToyDog: <name>"
  - "Pomeranian: <name>"
  - "ShibaInu: <name>"
- Each subtype must implement `bark()` with different results:
  - `ToyDog` returns "..." because it cannot bark.
  - `Pomeranian` returns "Yip yip".
  - `ShibaInu` returns "Woof".

Objective:
- Understand coupling: changes to behavior require touching every subtype and the base type design.

Tests:
- Phase2CouplingTest

Run:
- mvn -Dtest=Phase2CouplingTest test

## Phase 3: Decouple with an Interface

Problem statement:
- Introduce a `Barkable` interface with a `bark()` method.
- Only `Pomeranian` and `ShibaInu` should implement `Barkable`.
- `ToyDog` should not be barkable.
- All dog subtypes must still implement `display()`.

Objective:
- Learn decoupling, how it helps unit tests, and how it allows switching implementations at runtime.

Tests:
- Phase3InterfaceDecouplingTest

Run:
- mvn -Dtest=Phase3InterfaceDecouplingTest test

## Phase 4: Composition (Strategy Pattern)

Problem statement:
- Make `Dog` an abstract class that holds a `BarkBehavior` field.
- Create a `BarkBehavior` interface with `bark()`.
- Add `performBark()` in `Dog` that delegates to `barkBehavior.bark()`.
- Add `setBarkBehavior(...)` to allow runtime changes.
- `display()` must be abstract and implemented by each subtype.
- Provide `LoudBark`, `SoftBark`, and `SilentBark` implementations.

Expected bark outputs:
- `LoudBark` returns "Woof".
- `SoftBark` returns "Yip yip".
- `SilentBark` returns "...".

Objective:
- Understand composition over inheritance and programming to an interface.

Tests:
- Phase4CompositionStrategyTest

Run:
- mvn -Dtest=Phase4CompositionStrategyTest test
