package com.reflect.test;

import java.lang.reflect.Field;

/**
 * 反射工具类
 * @author zhengYu
 *
 */
public class FieldUtil {
	
	 /** 
	76.     * 循环向上转型, 获取对象的 DeclaredField 
	77.     * @param object : 子类对象 
	78.     * @param fieldName : 父类中的属性名 
	79.     * @return 父类中的属性对象 
	80.     */  
      
  public static Field getDeclaredField(Object object, String fieldName){  
       Field field = null ;  
       Class<?> clazz = object.getClass() ;      
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
           try {  
               field = clazz.getDeclaredField(fieldName) ;  
                return field ;  
        } catch (Exception e) {  
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。  
              //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了  
                
            }   
        }  
      
        return null;  
    }     
  

  /** 
   * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter 
   * @param object : 子类对象 
   * @param fieldName : 父类中的属性名 
 * @param value : 将要设置的值 
   */  
    
 public static void setFieldValue(Object object, String fieldName, Object value){  
   
      //根据 对象和属性名通过反射 调用上面的方法获取 Field对象  
      Field field = getDeclaredField(object, fieldName) ;  
       
      //抑制Java对其的检查  
      field.setAccessible(true) ;  
        
     try {  
          //将 object 中 field 所代表的值 设置为 value  
          field.set(object, value) ;  
     } catch (IllegalArgumentException e) {  
         e.printStackTrace();  
     } catch (IllegalAccessException e) {  
          e.printStackTrace();  
      }  
        
  }  
 
 /** 
  * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter 
  * @param object : 子类对象 
   * @param fieldName : 父类中的属性名 
   * @return : 父类中的属性值 
   */  
    
 public static Object getFieldValue(Object object, String fieldName){  
        
    //根据 对象和属性名通过反射 调用上面的方法获取 Field对象  
      Field field = getDeclaredField(object, fieldName) ;  
       
     //抑制Java对其的检查  
      field.setAccessible(true) ;  
       
     try {  
         //获取 object 中 field 所代表的属性值  
          return field.get(object) ;  
          
     } catch(Exception e) {  
          e.printStackTrace() ;  
      }  
      
      return null;  
 }  



}
