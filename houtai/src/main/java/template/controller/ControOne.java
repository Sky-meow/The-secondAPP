package template.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import template.entity.PetCategory;
import template.mapper.PetCategoryMapper;

import java.nio.charset.Charset;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value="/bbb", produces="application/json; charset=UTF-8")
public class ControOne {
    @Autowired
    PetCategoryMapper petCategoryMapper;


//    private RequestMappingHandlerAdapter handlerAdapter;
    @GetMapping()
    public List getOne(){
        return petCategoryMapper.selectAll();
    }

    @PostMapping()
    public PetCategory postOne(@RequestBody PetCategory petCategory){
        //List<PetCategory> list = new ArrayList<>();
        //list.add(petCategory);
        petCategoryMapper.insert(petCategory);
        return petCategory;
       // return list;

//        ResponseEntity.ok()
    }

    @GetMapping("/code")
    public String code(){
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setDefaultCharset(Charset.forName("utf-8"));
//        handlerAdapter.getMessageConverters().add(0,stringHttpMessageConverter);
        return "msg:这是测试";
    }
}
