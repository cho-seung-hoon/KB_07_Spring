package org.scoula.beans;

public class Person {
    private String name;
    private Parrot parrot; // 의존성 필드

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}