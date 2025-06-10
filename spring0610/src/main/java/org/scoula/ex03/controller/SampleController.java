package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller // 컨트롤러임을 명시 + Bean 등록
@Log4j2 // log 필드 생성 (롬복)
@RequestMapping("/sample") // "/sample"로 시작하는 요청을 현채 컨트롤러로 매핑
public class SampleController {

    // 클래스 레벨 "/sample" + 메서드 레벨 "" -> "/sample" URL 요청 매핑
    @RequestMapping(value="", method={RequestMethod.GET, RequestMethod.POST})
    public void basic(){
        log.info("[GET] /sample 요청 처리됨");
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET})
    public void basic2(){
        log.info("[GET] /sample/basic2 요청 처리됨");
    }

    // - "/sample/board/{id}" 요청 매핑, method 관계 없음

    // - {id} : 해당 위치에 존재하는 URL 값을 "id"라고 인식
    // - @PathVariable("id") long id :
    //  요청 주소에서 {id} 값을 얻어와 매개 변수 long id에 주입
    @RequestMapping("/board/{id:[0-9]+}") // id 자리가 정수인 경우만 매핑
    public void selectBoard(@PathVariable("id") long id){
        log.info("입력된 id : " + id);
    }

    // HTTP 메서드를 명시적으로 지정하는 방식 - 다중 메서드 허용
    @RequestMapping(value="/basic", method={RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get............");
        // GET과 POST 요청 모두 처리 가능
    }

    // [POST]
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {  // HandlerAdapter가 자동으로 객체 생성 및 프로퍼티 바인딩
        log.info("" + dto);   // 바인딩된 데이터 로그 출력으로 확인
        return "sample/ex01"; // ViewResolver에 의해 /WEB-INF/views/sample/ex01.jsp로 forward
    }

    // @RequestParam 옵션 활용 - 파라미터 누락 및 기본값 처리
    @GetMapping("/ex02-advanced")
    public String ex02Advanced(
            @RequestParam(value="name", required=false, defaultValue="익명") String name,
            @RequestParam(value="age", required=false, defaultValue="10") int age) {
        // required=false: 파라미터가 없어도 에러 발생하지 않음
        // defaultValue: 파라미터가 없을 때 사용할 기본값 (문자열로 지정, 자동 형변환)
        return "sample/ex02";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "sample/ex04";
        // @ModelAttribute로 기본 자료형도 Model에 추가하여 뷰에서 접근 가능
    }

    @GetMapping("/exUpload")
    public String exUpload() {
        log.info("/exUpload..........");
        return "sample/exUpload"; // forward
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        // MultipartFile: Spring이 제공하는 업로드 파일 래퍼 클래스
        for(MultipartFile file : files) {
            log.info("----------------------------------");
            log.info("name:" + file.getOriginalFilename());  // 원본 파일명
            log.info("size:" + file.getSize());              // 파일 크기 (바이트)
            log.info("contentType:" + file.getContentType()); // MIME 타입

            // 파일이 실제로 선택되었는지 확인
            if (!file.isEmpty()) {
                try {
                    // 파일을 지정된 위치에 저장
                    File saveFile = new File("c:/upload/" + file.getOriginalFilename());
                    file.transferTo(saveFile);  // 임시 파일을 최종 위치로 이동
                } catch (IOException e) {
                    log.error("파일 저장 실패", e);
                }
            }
        }
    }
}
