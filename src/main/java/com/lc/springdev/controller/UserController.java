package com.lc.springdev.controller;

import com.lc.springdev.data.JsonResult;
import com.lc.springdev.data.JsonResultCode;
import com.lc.springdev.entity.LcUser;
import com.lc.springdev.mapper.LcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

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

    @PostMapping("/user/add/one")
    public JsonResult addOne(@RequestBody LcUser lcUser){
        Boolean result = service().lcUserService.addOneUser(lcUser);
        if (result){
            return success();
        }else {
            return fail();
        }
    }
}
