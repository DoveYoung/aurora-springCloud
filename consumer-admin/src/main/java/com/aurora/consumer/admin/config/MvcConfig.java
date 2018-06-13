package com.aurora.consumer.admin.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.aurora.consumer.admin.bean.Interceptor;
import com.aurora.consumer.admin.util.Const;


/**
 * @Title: MvcConfig 
 * @Package com.aurora.consumer.admin.config
 * @Description:web相关配置
 * @author BYG
 * @date 2018年4月24日 上午11:45:01 
 * @version V1.0
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Autowired Interceptor Interceptor;

	/**
	 * @Title: addInterceptors 
	 * @Description: 注册拦截器
	 * 		addPathPatterns()添加拦截路径
	 * 		excludePathPatterns（）排除不需要拦截路径
	 * @param  InterceptorRegistry registry； 
	 * @return void  
	 * @author BYG
	 * @date 2018年4月24日 上午11:49:08
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(Interceptor).addPathPatterns("/**").excludePathPatterns(Const.NO_INTERCEPTOR_PATH);
        super.addInterceptors(registry);
    }
    
    /**
     * @Description:配置Thymeleaf全局变量
	 * 		在任何html中均可使用此变量<a href="#" th:if="${basePath} != null" ></a>
	 * @param  ThymeleafViewResolver viewResolver； 
	 * @return void  
	 * @author BYG
	 * @date 2018年4月24日 上午11:49:08
	 */
	@Resource
	private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {		
	    if(viewResolver != null) {
	    	Environment environment = viewResolver.getApplicationContext().getEnvironment();
	    	String env = environment.getActiveProfiles()[0];
	    	String basePath = "";
	    	if (env.equals("pro")) {
	    		basePath = "https://aurorascm.com/";
			}else{
				basePath = "http://localhost:8802/";
			}
//	        Map<String, Object> vars = new HashMap<>();
//	        vars.put("basePath", "basePath");
//	        viewResolver.setStaticVariables(vars);
	        viewResolver.addStaticVariable("basePath", basePath);
	    }
	}
	
}
