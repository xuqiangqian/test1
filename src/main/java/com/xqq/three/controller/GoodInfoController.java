package com.xqq.three.controller;

import com.xqq.three.annotation.LogRecord;
import com.xqq.three.entity.GoodInfoEntity;
import com.xqq.three.service.GoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xuqiangqiang
 * @Date: 2018/6/25 10:15
 * @Description:
 */
@RestController
@RequestMapping(value = "good")
public class GoodInfoController {
    /**
     * 商品业务逻辑实现
     */
    @Autowired
    private GoodInfoService goodInfoService;
    /**
     * 添加商品
     * @return
     */

    @RequestMapping(value = "/save")
    public Long save(GoodInfoEntity good) throws Exception
    {
        return goodInfoService.saveGood(good);
    }
}
