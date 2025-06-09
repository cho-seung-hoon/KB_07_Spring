package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        // 같은 타입의 Bean이 여러 개 등록되어 있을 때 타입으로만 조회하면 예외 발생
        // NoUniqueBeanDefinitionException: 어떤 Bean을 선택해야 할지 Spring이 결정할 수 없음
//    Parrot p = context.getBean(Parrot.class); // 예외 발생 !!!

        // 해결방법 : Bean 이름을 명시적으로 지정하여 조회
        Parrot p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());

    }
}