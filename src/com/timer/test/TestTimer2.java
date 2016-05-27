package com.timer.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器的用法，该定时器是java里面的timer,但是
 * 不建议这样用，因为这个定时器是否启动，或多久调取一次应该要配置在外面才行，主要是在spring里面去配置
 * @author zhengYu
 *
 */

public class TestTimer2 {
	public static void main(String[] args) {
		//timer1();  //只会执行一次
		//timer2();   //多次执行
		//timer3();
		timer4();
	}
	
	public static void timer1(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {  //这个只会执行一次
			@Override
			public void run() {
				System.out.println("-----start 指定任务111-----");
				
			}
		}, 2000);
	}
	
	// 第二种方法：设定指定任务task在指定延迟delay后进行固定延迟peroid的执行
    // schedule(TimerTask task, long delay, long period)
    public static void timer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务222--------");
            }
        }, 1000, 1000);
    }
    
 // 第三种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
    // scheduleAtFixedRate(TimerTask task, long delay, long period)
    public static void timer3() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 1000, 2000);
    }

    // 第四种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
    // Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
    public static void timer4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
        calendar.set(Calendar.MINUTE, 0);       // 控制分
        calendar.set(Calendar.SECOND, 0);       // 控制秒
        Date time = calendar.getTime();         // 得出执行任务的时间,此处为今天的12：00：00
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
    }
}
