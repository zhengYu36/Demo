package com.timer.test;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 关于java定时器的简单例子
 * 这个是通过ActionListener的方式来实现的
 * @author zhengYu
 *
 */

public class TestTimer {
	public static void main(String[] args) {
		//B b = new B();
		//b.sayHello();
		
		//调取定时器
		ActionListener listener = new TimerPrinter();
		Timer timer = new Timer(10000,listener);
		timer.start();  //启动定时器
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);   //退出程序
	}
}


class TimerPrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Date now=new Date();
		System.out.println("At the tone, the time is "+now);
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}

//定义的其他的类
class B{
	public void sayHello(){
		System.out.println("hello,b");
	}
}
