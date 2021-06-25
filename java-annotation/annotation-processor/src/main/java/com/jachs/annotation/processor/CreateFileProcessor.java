package com.jachs.annotation.processor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.Set;
import static java.lang.reflect.Modifier.FINAL;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import com.google.auto.service.AutoService;
import com.jachs.annotation.part3.CreateClass;
import com.jachs.annotation.part3.CreateFile;
import com.jachs.annotation.processor.utill.CodeGen;
import com.jachs.annotation.processor.utill.JavaWriter;

/***
 * ProcessingEnvironment:是一个注解处理工具的集合</br>
 * Element,是一个接口，表示一个程序元素，它可以是包、类、方法或者一个变量。Element已知的子接口有：</br>
 * PackageElement:表示一个包程序元素。提供对有关包及其成员的信息的访问。 </br>
 * ExecutableElement:表示某个类或接口的方法、构造方法或初始化程序（静态或实例），包括注释类型元素。 </br>
 * TypeElement:表示一个类或接口程序元素。提供对有关类型及其成员的信息的访问。注意，枚举类型是一种类，而注解类型是一种接口。</br>
 * VariableElement:表示一个字段、enum 常量、方法或构造方法参数、局部变量或异常参数。</br>
 * 
 * @author zhanchaohan
 *
 */
@AutoService(Processor.class)
public class CreateFileProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("ok im in CreateFileProcessor");
		for (TypeElement annotatedElement : annotations) {
			try {
				Name qualifiedName = annotatedElement.getQualifiedName();
				
				if (qualifiedName.contentEquals("com.jachs.annotation.part3.CreateFile")) {
					System.out.println("AAAAAA");
					CreateFile cf = annotatedElement.getAnnotation(CreateFile.class);
					System.out.println(cf.filePath() + "\t\t" + cf.fileName() + "\t\t" + cf.message());
					Writer wr = new FileWriter(cf.filePath() + cf.fileName());
					wr.write(cf.message());
					wr.close();

				}
				if (qualifiedName.contentEquals("com.jachs.annotation.part3.CreateClass")) {
					System.out.println("BBBBB");
					// 生成个java文件
					writeAdapter((TypeElement) annotatedElement);
					// 生成个java文件，并编译
//					StringBuffer sb = new StringBuffer();
//					sb.append("package com.jachs.annotation.processor;").append("\n");
//					sb.append("public class ").append(cc.className()).append("{").append("\n");
//					sb.append("public static void main(String[] args) {").append("\n");
//					sb.append("System.out.println(\"").append(cc.message()).append("\");").append("\n");
//					sb.append("}  ").append("\n");
//					sb.append("}  ");
//					JavaFileObject source = processingEnv.getFiler()
//							.createSourceFile("com.jachs.annotation." + cc.className());
//					Writer writer = source.openWriter();
//					writer.write(sb.toString());
//					writer.flush();
//					writer.close();
				}
			} catch (IOException e) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getMessage());
			}
		}

		// 返回ture表示该注解已经被处理, 后续不会再有其他处理器处理; 返回false表示仍可被其他处理器处理.
		return true;
	}

	private void writeAdapter(TypeElement type) throws IOException {
		String typeAdapterName = CodeGen.adapterName(type, "$TypeAdapter");
		JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(typeAdapterName, type);
		System.out.println("Generating type adapter: " + typeAdapterName + " in " + sourceFile.getName());

		JavaWriter writer = new JavaWriter(sourceFile.openWriter());
		writer.addPackage(CodeGen.getPackage(type).getQualifiedName().toString());
		writer.beginType(typeAdapterName, "class", FINAL, null);
		writer.endType();
		writer.close();
	}

	// 集合中指定支持的注解类型的名称（这里必须时完整的包名+类名)
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> annotataions = new LinkedHashSet<String>();
		annotataions.add(CreateFile.class.getCanonicalName());
		annotataions.add(CreateClass.class.getCanonicalName());
		return annotataions;
	}

	// 指定当前正在使用的Java版本
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	// 初始化处理器
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
	}
}
