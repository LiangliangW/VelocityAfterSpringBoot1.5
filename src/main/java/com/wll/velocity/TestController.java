package com.wll.velocity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/index")
    public ModelAndView velocityTest(Map map){
        map.put("name", "沈则");
        map.put("message", "velocity测试");
        return new ModelAndView("index", map);
    }
}
