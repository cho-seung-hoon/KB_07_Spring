package org.scoula.ex03.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j2;
@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    @RequestMapping("") // url : /sample
    public void basic() {
        log.info("basic............");
    }
}