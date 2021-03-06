package com.example.demo.controller
import org.springframework.boot.Banner
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SpringBootGroovyController {
    @RequestMapping("/")
    def home() {
        new ModelAndView("views/home",[bootVersion: Banner.package.implementationVersion, groovyVersion: GroovySystem.version])
    }
}
