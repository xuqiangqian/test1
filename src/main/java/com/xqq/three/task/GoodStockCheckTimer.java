package com.xqq.three.task;

import com.xqq.three.JPA.GoodInfoRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;

/**
 * 商品库存检查定时任务
 *
 * @author xuqiangqiang
 * @Date: 2018/6/25 10:27
 * @Description:
 */
public class GoodStockCheckTimer extends QuartzJobBean {
    static Logger logger = LoggerFactory.getLogger(GoodStockCheckTimer.class);
    @Autowired
    private GoodInfoRepository goodInfoRepository;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("执行库存检查定时任务，执行时间：{}", new Date());
        List list=goodInfoRepository.findAll();
        System.out.println(list);
    }
}
