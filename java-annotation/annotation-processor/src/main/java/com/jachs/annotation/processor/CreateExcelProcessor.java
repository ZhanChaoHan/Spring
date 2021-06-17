package com.jachs.annotation.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;

/***
 * 
 * @author zhanchaohan
 *
 */
@AutoService(Processor.class)
public class CreateExcelProcessor extends AbstractProcessor{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement typeElement : annotations) {
			
		}
		return false;
	}

}
