package com.hwm.controller;

import com.hwm.serivce.ComputeClient;
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
@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
public class ConsumerController {

    @Autowired
    private ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(1,100);
    }
}
