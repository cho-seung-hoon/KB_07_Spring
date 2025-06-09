package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

// 지정된 패키지에서 @Component 계열 어노테이션 클래스를 찾아 Bean 등록
@ComponentScan(basePackages = "org.scoula.beans")
public class ProjectConfig2 {
    // 별도의 @Bean 메서드 불필요
}
