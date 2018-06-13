package com.aurora.consumer.admin.config;
  
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component; 

/**
 * 普通类获取bean工具
 * @author BYG 2018.2.26
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
	
	//普通类调用bean
    private static ApplicationContext applicationContext = null;
	/**
	 * Spring容器会检测容器中的所有Bean，如果发现某个Bean实现了ApplicationContextAware接口，
	 * Spring容器会在创建该Bean之后，自动调用该Bean的setApplicationContext()方法，
	 * 调用该方法时，会将容器本身作为参数传给该方法    
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		  if(ApplicationContextUtil.applicationContext == null){
			   ApplicationContextUtil.applicationContext  = applicationContext;
	       }
	}
	
    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
       return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
       return getApplicationContext().getBean(name);

    }


    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
    	
        return getApplicationContext().getBean(clazz);
       
    }

	
}  