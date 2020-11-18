package org.spoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//redis启动的时候,加异步功能,把主线程的任务分配给子线程;
//主线程响应用户请求,子线程把用户数据保存;
//@EnableAsync
//EnableScheduling定时任务,相当于闹钟
//@EnableScheduling
@SpringBootApplication
public class BooKApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooKApplication.class, args);
	}

}
