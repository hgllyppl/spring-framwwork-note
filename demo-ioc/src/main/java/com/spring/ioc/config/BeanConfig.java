package com.spring.ioc.config;

import com.spring.ioc.bean.BeanLifeCycle;
import com.spring.ioc.bean.CircularReferenceA;
import com.spring.ioc.bean.CircularReferenceB;
import com.spring.ioc.bean.CustomSmartLifeCycle;
import com.spring.ioc.bean.StartListener;
import com.spring.ioc.bean.Student;
import com.spring.ioc.bean.StudentFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

/**
 * Created by xin on 2019/4/22.
 */
@Configuration
@Import(StartListener.class)
//@ImportResource({"application.properties"})
public class BeanConfig {

    //-------------------------作用域---------------------------------------
    @Bean
    @Scope(SCOPE_SINGLETON)
    public Student studentSingleton() {
        return new Student()
                .setName("zhang3")
                .setScope(SCOPE_SINGLETON);
    }

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public Student studentPrototype() {
        return new Student()
                .setName("li4")
                .setScope(SCOPE_PROTOTYPE);
    }
    //-------------------------工厂bean---------------------------------------
    @Bean
    public StudentFactory studentFactory() {
        return new StudentFactory();
    }
    //-------------------------循环引用---------------------------------------
    @Bean
    public CircularReferenceA circularReferenceA() {
        return new CircularReferenceA();
    }

    @Bean
    public CircularReferenceB circularReferenceB() {
        return new CircularReferenceB();
    }
    //-------------------------bean生命周期---------------------------------------
    @Bean
    public BeanLifeCycle beanLifeCycle() {
        return new BeanLifeCycle();
    }
    //-------------------------SmartLifeCycle---------------------------------------
    @Bean
    public CustomSmartLifeCycle customSmartLifeCycle() {
        return new CustomSmartLifeCycle();
    }
    //-------------------------同名同类bean---------------------------------------
    @Bean("sameBeanName-sameClass")
    public Student student1() {
        return new Student().setName("xiao2");
    }

    @Bean("sameBeanName-sameClass")
    public Student student2() {
        return new Student().setName("xiangxiang");
    }
    //-------------------------同名不同类bean---------------------------------------
    @Bean("sameBeanName-differenceClass")
    public Student student3() {
        return new Student().setName("qiangqiang");
    }

    @Bean("sameBeanName-differenceClass")
    public BeanLifeCycle student4() {
        return new BeanLifeCycle();
    }
}
