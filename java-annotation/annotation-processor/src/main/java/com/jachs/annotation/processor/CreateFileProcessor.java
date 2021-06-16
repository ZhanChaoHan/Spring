package com.jachs.annotation.processor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
import com.jachs.annotation.part3.CreateFile;


/***
 * 
 * @author zhanchaohan
 *
 */
@AutoService(Processor.class)
public class CreateFileProcessor extends AbstractProcessor{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(CreateFile.class)) {
			CreateFile cf=annotatedElement.getAnnotation(CreateFile.class);
			
			try {
				System.out.println(cf.filePath()+"\t\t"+cf.fileName()+"\t\t"+cf.message());
				Writer wr= new FileWriter(cf.filePath()+cf.fileName());
				wr.write(cf.message());
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(roundEnv.toString());
		return false;
	}
	@Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new LinkedHashSet<String>();
        annotataions.add(CreateFile.class.getCanonicalName());
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
