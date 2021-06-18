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
import javax.tools.JavaFileObject;

import com.google.auto.service.AutoService;
import com.jachs.annotation.part3.CreateClass;
import com.jachs.annotation.part3.CreateFile;

/***
 * 
 * @author zhanchaohan
 *
 */
//@AutoService(Processor.class)
public class CreateFileProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("ok im in CreateFileProcessor");
		for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(CreateFile.class)) {
			CreateFile cf = annotatedElement.getAnnotation(CreateFile.class);

			try {
				System.out.println(cf.filePath() + "\t\t" + cf.fileName() + "\t\t" + cf.message());
				Writer wr = new FileWriter(cf.filePath() + cf.fileName());
				wr.write(cf.message());
				wr.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//生成个java文件，并编译
		for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(CreateClass.class)) {
			CreateClass cc = annotatedElement.getAnnotation(CreateClass.class);
			try {
				StringBuffer sb=new StringBuffer();
				sb.append("package com.jachs.annotation.processor;").append("\n");
				sb.append("public class ").append(cc.className()).append("{").append("\n");
				sb.append("public static void main(String[] args) {").append("\n");
				sb.append("System.out.println(\"").append(cc.message()).append("\");").append("\n");
				sb.append("}  ").append("\n");
				sb.append("}  ");
				JavaFileObject source = processingEnv.getFiler().createSourceFile("com.jachs.annotation."+cc.className());
				Writer writer = source.openWriter();
				writer.write(sb.toString());
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 返回ture表示该注解已经被处理, 后续不会再有其他处理器处理; 返回false表示仍可被其他处理器处理.
		return true;
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> annotataions = new LinkedHashSet<String>();
		annotataions.add(CreateFile.class.getCanonicalName());
		annotataions.add(CreateClass.class.getCanonicalName());
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
