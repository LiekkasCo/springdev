package com.lc.springdev.controller;

import com.lc.springdev.entity.LcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liangchen
 */
@Controller
public class JspController extends BaseController{

    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request){
        List<LcUser> userInfo = service().lcUserService.getAll();
        LcUser oneUser = service().lcUserService.getOne(1);
//        model.addAttribute("userInfo",oneUser);
        request.setAttribute("userInfo",userInfo);
        return "index";
    }
}
