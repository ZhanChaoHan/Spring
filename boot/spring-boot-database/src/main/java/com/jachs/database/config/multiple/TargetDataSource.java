package com.jachs.database.config.multiple;

import java.lang.annotation.*;

/***
 * 目标数据源注解，注解在方法上指定数据源的名称
 * 设置拦截数据源的注解，可以设置在具体的类上，或者在具体的方法上，dataSource是当前数据源的一个别名用于标识我们的数据源的信息。
 * @author zhanchaohan
 */
@Target( { ElementType.METHOD, ElementType.TYPE } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface TargetDataSource {
    String dataSource() default DataSourceType.MASTER;
}
