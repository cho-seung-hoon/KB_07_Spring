package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
    private String name = "Ella";

    // Spring Container에 등록된 Bean 중 Parrot2 타입 Bean을 찾아 필드에 주입
    @Autowired // 직접 new 연산자로 객체를 만들지 않고 Container에서 주입 -> 의존성 주입
    private Parrot2 parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }

    public void setParrot(Parrot2 parrot) {
        this.parrot = parrot;
    }
}