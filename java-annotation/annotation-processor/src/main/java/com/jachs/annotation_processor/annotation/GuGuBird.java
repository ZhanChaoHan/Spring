package com.jachs.annotation_processor.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE,ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface GuGuBird {
	String song();
	long spendTime();
}
