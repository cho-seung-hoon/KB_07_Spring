package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.scoula.domain")  // org.scoula.domain 패키지와 하위 패키지에서 @Component, @Service, @Repository 등을 찾아서 Bean으로 등록
public class ProjectConfig3 {

    // 별도의 @Bean 메소드 없이도 @ComponentScan이 자동으로 Bean들을 등록해줌
    // org.scoula.domain 패키지의 모든 @Component 계열 어노테이션이 붙은 클래스들이
    // Spring Container에 Bean으로 등록됨
}