package org.basis.designpatterns.factorymethod;

public class DogFactory implements Factory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
