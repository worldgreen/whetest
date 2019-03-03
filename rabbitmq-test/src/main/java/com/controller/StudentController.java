package com.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(description = "对学生资源的操作")
@RequestMapping("/student")
@RestController
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("Returns list of all students")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success")
    })
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setName("whe");
        student.setAge(12);
        student.setBirthday(new Date());
        list.add(student);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}")
    @ApiOperation("Returns a student by name")
    @ApiResponses({
            @ApiResponse(code = 200, message = "当姓名为 whe, 结果...... /r/n" +
                    "当姓名为whl，结果.....")
    })
    public ResponseEntity<Student> getStudentByName(@ApiParam(value = "姓名")
                                @PathVariable String name, @RequestParam(required = false) Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setBirthday(new Date());
        return ResponseEntity.ok(student);
    }

}

@ApiModel(description = "学生")
class Student {

    @ApiModelProperty(value = "姓名:", allowableValues = "whe, whl", required = true, position = 0)
    private String name;

    @ApiModelProperty(value = "年龄:", allowableValues = "range[1,100]", required = true, position = 1)
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出生日期:", position = 2, example = "1992-10-20 11:11:11")
    private Date birthday;

    @ApiModelProperty(value = "类型 1:小学生 2:大学生 3:研究生", required = true, allowableValues = "range[1,4)", position = 3)
    private Integer type;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @ApiModelProperty(value = "地址:", position = 4)
    private List<Address> addresses;

    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

class Address {
    @ApiModelProperty(value = "省:", required = true, position = 0)
    private String sheng;

    @ApiModelProperty(value = "市:", required = true, position = 1)
    private String shi;

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }
}