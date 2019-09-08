package springguide.securing.webapps.task;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

	private static final Logger log=LoggerFactory.getLogger(ScheduleTask.class);
	private static final SimpleDateFormat date=new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("The time is {}", date.format(new Date()));
	}
}
