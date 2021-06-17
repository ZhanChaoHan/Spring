package com.jachs.annotation.processor;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;
import com.jachs.annotation.part4.ExportExcel;

/***
 * 
 * @author zhanchaohan
 *
 */
@AutoService(Processor.class)
public class CreateExcelProcessor extends AbstractProcessor{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("ok im in CreateExcelProcessor");

		for (TypeElement typeElement : annotations) {
			
		}
		//如果在以前的处理 round 中发生错误，则返回 true；否则返回 false。
		boolean errorRaised=roundEnv.errorRaised();
		// 如果此 round 生成的类型不是以注释处理的后续 round 为准，则返回 true；否则返回 false。
		boolean processingOver=roundEnv.processingOver();
		
		System.out.println(errorRaised);
		System.out.println(processingOver);
		
		Set<? extends Element>elRoot=roundEnv.getRootElements();
		for (Element element : elRoot) {
			System.out.println(element.toString());
		}
		return true;
	}
	@Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new LinkedHashSet<String>();
        annotataions.add(ExportExcel.class.getCanonicalName());
        return annotataions;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }
}
