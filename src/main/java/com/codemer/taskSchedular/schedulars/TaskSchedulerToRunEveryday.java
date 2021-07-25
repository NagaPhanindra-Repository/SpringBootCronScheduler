package com.codemer.taskSchedular.schedulars;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.core.SchedulerLock;
@Component
public class TaskSchedulerToRunEveryday {
	
	 @Scheduled(cron = "0 0/12 16 * * ?", zone="America/New_York")
	    @SchedulerLock(name = "TaskScheduler_scheduledTask", lockAtLeastForString = "PT10M", lockAtMostForString = "PT14M")
	   public void fixedRateSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      
	      
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Task Completed scheduler:: " + strDate);
	      
	   }

}
