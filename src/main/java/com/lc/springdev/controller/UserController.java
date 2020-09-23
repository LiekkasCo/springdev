package com.lc.springdev.controller;

import com.lc.springdev.data.JsonResult;
import com.lc.springdev.entity.LcUser;
import com.lc.springdev.mapper.LcUserMapper;
import com.lc.springdev.service.LcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * user controller
 * @author laingchen
 * @date 2020.09.23
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    public LcUserMapper lcUserMapper;
    @GetMapping("/user/all")
    public JsonResult getAll(){
        List<LcUser> allUser = service().lcUserService.getAll();
        return success(allUser);
    }

    @GetMapping("/user/one/{id}")
    public JsonResult getOne(@PathVariable long id){
        LcUser oneUser = service().lcUserService.getOne(id);
        return success(oneUser);
    }
}
