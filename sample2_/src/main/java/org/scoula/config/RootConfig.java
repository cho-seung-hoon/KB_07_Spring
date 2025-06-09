package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 🌱 Root Application Context 설정 클래스
 * - Spring Framework의 최상위(Root) 애플리케이션 컨텍스트를 설정하는 클래스
 * - 웹 계층과 무관한 비즈니스 로직, 서비스, 데이터 액세스 계층의 Bean들을 관리
 */
@Configuration
@ComponentScan(basePackages = {"org.scoula"}) // 지정된 패키지에서 @Component 어노테이션이 있는 클래스를 자동으로 빈으로 등록
public class RootConfig {

    // 현재는 기본 설정만 있는 상태
    // 프로젝트 발전에 따라 다음과 같은 빈들을 추가할 수 있습니다:
    // - 데이터베이스 설정
    // - 트랜잭션 관리
    // - 보안 설정
    // - 외부 API 클라이언트
    // - 캐시 설정
    // - 스케줄링 설정
}
