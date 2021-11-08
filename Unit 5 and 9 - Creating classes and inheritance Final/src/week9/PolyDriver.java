package week9;

public class PolyDriver {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        a1.makeSound();
        ((Dog) a1).chaseTail();
        a1 = new Cat();
        a1.makeSound();
    }
}
