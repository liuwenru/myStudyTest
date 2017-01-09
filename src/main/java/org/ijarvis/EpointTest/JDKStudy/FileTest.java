package org.ijarvis.EpointTest.JDKStudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;

public class FileTest {
	private static Logger logger = Logger.getLogger(FileTest.class);
	
	//文件字节读取
	public static void readFile_as_byte(String filePath) {
		FileInputStream inputStream=null;
		try {
			inputStream=new FileInputStream(filePath);
			byte[] buffer=new byte[1];
			int hasRead=0;
			while(inputStream.read(buffer)>0){
				logger.debug(new String(buffer));
			}
		} catch (FileNotFoundException e) {
			//当读取出现错误时需要去处理
			e.printStackTrace();
			
		} catch (IOException e) {
			//当读取出现错误时需要去处理
			e.printStackTrace();
		}finally {
			
		}
	}
	//文件字符读取
	public static void readFile_as_char(String filePath) {
		FileReader reader=null;
		try {
			reader=new FileReader(filePath);
			char[] buffer=new char[1024];
			int hasRead=0;
			while(reader.read(buffer)>0){
				logger.debug(new String(buffer));
			}
		} catch (FileNotFoundException e) {
			//当读取出现错误时需要去处理
			e.printStackTrace();
			
		} catch (IOException e) {
			//当读取出现错误时需要去处理
			e.printStackTrace();
		}finally {
			
		}
	}
	public static void ListFile_UseFilenameFilter() throws IOException{
		File file=new File("/home/ijarvis/Downloads");
		logger.debug(file.getName());
		String[] files= file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.endsWith(".json")) {
					logger.debug(name);
					return true;
				}
				return false;
			}
		});
	}
	//将输出流从定向
	public static void StandOUtRedirect(String filepath) throws FileNotFoundException{
		FileOutputStream fileOutputStream=new FileOutputStream(filepath);
		PrintStream printStream=new PrintStream(fileOutputStream);
		System.setOut(printStream);
		System.out.println("this is a print");
		
	}
	//将输入流重定向
	public static void StandInRedirect(String filepath) throws FileNotFoundException{
		FileInputStream fileInputStream=new FileInputStream(filepath);
		System.setIn(fileInputStream);
		Scanner sc=new Scanner(System.in);
		sc.useDelimiter("\n");
		FileOutputStream fileOutputStream=new FileOutputStream(filepath);
		PrintStream printStream=new PrintStream(fileOutputStream);
		System.setOut(printStream);
		while(sc.hasNext()){
			System.out.println(sc.next());
		}
	}
	
	
	@Ignore
	@Test
	public void methodTest() throws IOException{
		new FileTest().ListFile_UseFilenameFilter();
	}
	@Test
	public void readFileasInputStream() throws FileNotFoundException{
//		FileTest.readFile_as_byte("/home/ijarvis/Downloads/shadowsocks.json");
//		logger.debug("----------------------");
//		FileTest.readFile_as_char("/home/ijarvis/Downloads/shadowsocks.json");
//		logger.debug("----------------------");
//		FileTest.StandOUtRedirect("/home/ijarvis/Downloads/shadowsocks2.json");
		StandInRedirect("/home/ijarvis/Downloads/shadowsocks2.json");
	}
}
