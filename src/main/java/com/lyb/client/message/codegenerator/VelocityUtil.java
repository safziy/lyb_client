package com.lyb.client.message.codegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

/**
 * 根据模板自动生成java类
 * 
 */
public class VelocityUtil {

	/**
	 * 生成java类
	 * 
	 * @param templateFile
	 * @param context
	 * @param path
	 * @param className
	 * @param configPath
	 */
	public static void generateClass(String templateFile, VelocityContext context, String path, String className,
			String configPath) {
		try {
			String rootPath = System.getProperty("user.dir");
			Velocity.init(rootPath + "/src/main/resources/config/velocity/velocity.properties");
			Template template = null;
			try {
				template = Velocity.getTemplate(templateFile, "UTF-8");
			} catch (ResourceNotFoundException rnfe) {
				System.out.println("Example : error : cannot find template " + templateFile + " :" + rnfe);
				rnfe.printStackTrace();
				return;
			} catch (ParseErrorException pee) {
				System.out.println("Example : Syntax error in template " + templateFile + " :" + pee);
				pee.printStackTrace();
				return;
			}
			path = rootPath + "/" + path;
			File f = new File(path, className + ".java");
			if (f.exists()) {
				return;
			}
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(fw);

			if (template != null)
				template.merge(context, writer);

			/*
			 * flush and cleanup
			 */

			writer.flush();
			writer.close();
			System.out.println(className + ".java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
