package org.designpatterns.factorymethod;

public class CatFactory implements Factory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
