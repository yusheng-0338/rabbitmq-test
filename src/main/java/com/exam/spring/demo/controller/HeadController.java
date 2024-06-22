package com.exam.spring.demo.controller;

//import com.exam.spring.demo.entity.HeadEntity;
//import com.exam.spring.demo.service.HeadService;
import com.exam.spring.project.in.DCashRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @date: 2023-08-07
 */
@RestController
@RequestMapping(value = "head")
public class HeadController {

//    @Autowired
//    private HeadService headService;
//
//    @PostMapping("save")
//    public String save(@RequestBody HeadEntity entity) {
//        headService.save(entity);
//        return "保存成功";
//    }
//
//    @GetMapping("detail/{uid}")
//    public HeadEntity detail(@PathVariable("uid")String uid){
//        return headService.getById(uid);
//    }

    /**
     * 模擬收銀接口
     * @return
     */
    public Boolean addDCashRegister(@RequestBody DCashRegister dCashRegister){
        //业务流程,存储成功时返回ture,失败时返回false
        return true;
    }


}
