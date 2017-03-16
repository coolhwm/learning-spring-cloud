package com.hwm.controller;

import com.hwm.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConsumerController
 *
 * @author hwm
 * @since 2017/3/16
 **/
@RestController
public class ConsumerController {

    @Autowired
    ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.addService();
    }

}
