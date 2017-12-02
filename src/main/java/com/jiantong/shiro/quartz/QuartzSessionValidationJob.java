package com.jiantong.shiro.quartz;

import org.apache.shiro.session.mgt.ValidatingSessionManager;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于Quartz 2.* 版本的实现 
 * <p>Title:QuartzSessionValidationJob</p>
 * <p>Company: jiantong</p>
 * @author sunbing
 * @date 2017年10月30日 下午2:00:48
 */
public class QuartzSessionValidationJob implements Job {
	
    public static final String SESSION_MANAGER_KEY = "sessionManager";
    
    private static final Logger log = LoggerFactory.getLogger(QuartzSessionValidationJob.class);
    
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap jobDataMap = context.getMergedJobDataMap();  
        ValidatingSessionManager sessionManager = (ValidatingSessionManager) jobDataMap.get(SESSION_MANAGER_KEY);  
        if (log.isDebugEnabled()) {  
            log.debug("Executing session validation Quartz job...");  
        }  
        sessionManager.validateSessions();  
        if (log.isDebugEnabled()) {  
            log.debug("Session validation Quartz job complete.");  
        }  
	}
}
