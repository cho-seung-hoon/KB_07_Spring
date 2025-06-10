package org.scoula.config;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

@Log4j2
@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }
    // 스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴, / : 모든 요청에 대해 매핑
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }

    // 파일 업로드 제한 설정
    final String LOCATION = "c:/upload";              // 임시 파일 저장 위치
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L;     // 개별 파일 최대 크기: 10MB
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L;  // 전체 요청 최대 크기: 20MB
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;  // 메모리 임계값: 5MB (이상 시 디스크 저장)

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // 멀티파트 설정을 DispatcherServlet에 적용
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD
        );
        registration.setMultipartConfig(multipartConfig);
    }


}