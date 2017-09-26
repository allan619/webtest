package com.gdglc.spring.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class FirstJob extends QuartzJobBean{
	private static final Logger log = Logger.getLogger(FirstJob.class);
	private String name;
	public static boolean isRun;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext context)throws JobExecutionException {
		//System.out.println("hello:"+name);
		log.info("准备开始任务");
		if(!isRun){
			log.info("开始任务");
			isRun = true;
			//System.out.println(this);
			log.info("hello:"+name);
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("任务完成");
			isRun = false;
		}else{
			log.info("不满足运行条件");
		}
		
	}

}
