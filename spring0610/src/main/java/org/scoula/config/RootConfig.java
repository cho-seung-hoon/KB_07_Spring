package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.scoula"}) // 지정된 패키지에서 @Component 어노테이션이 있는 클래스를 자동으로 빈으로 등록
public class RootConfig {
}
