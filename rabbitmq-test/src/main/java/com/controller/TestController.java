package com.controller;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api(value = "/test")
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "one")
    public String one(@RequestBody Teacher teacher, @RequestHeader int headers){
        return "success param:";
    }

    @RequestMapping(value = "/three", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "测试3", notes = "输入学生类，改正一些字段")
    @ApiResponses({
            @ApiResponse(code = 300, message = "返回学生类", response = Student.class),
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Student> three(@RequestBody @ApiParam(required = true) Student student){

        return ResponseEntity.ok(student);
    }



}
