package ConstructorPractice;

public class Axe extends weapon {
    public void use() {
        System.out.println("Using axe");
    }

    public void test(){
        System.out.println(this);
    }

    public String toString() {
        return "I am an axe!";
    }
}
