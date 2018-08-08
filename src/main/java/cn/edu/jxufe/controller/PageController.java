package cn.edu.jxufe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 74132 on 2018/8/6.
 */

@Controller
public class PageController {
@RequestMapping("page_{url}")
    public String toPage(@PathVariable("url") String url){
    System.out.println("通过控制端访问jsp==>"+url);
    return url;
}
}
