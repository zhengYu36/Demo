package com.entityChangeZero.com;

/**
 * 这个是自定义的泛型类
 * @author zhengYu
 *
 */
public class GenericTest {

     public static void main(String[] args) {

    	 //哈哈，我知道了后面这个()是表示给的值
       Box<String> name = new Box<String>("cornxxx");
         System.out.println("name:" + name.getData());
     }

 }
 
 class Box<T> {
 
     private T data;
 
    public Box() {
 
    }

     public Box(T data) {
        this.data = data;
     }
 
     public T getData() {
         return data;
     }
 } 