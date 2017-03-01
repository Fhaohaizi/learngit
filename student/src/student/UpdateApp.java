package student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UpdateApp {
	public static void main(String[] args) {
		String packagename="", filename="";
		for (int i = 0; i < args.length; i++) {
			if(args[i].equals("--jar_name")){packagename=args[i+1];}
			if(args[i].equals("--test_class")){filename=args[i+1];}
		}
		new UpdateApp(packagename, filename, false);

	}
	//通过key控制卸载安装还是直接安装
	public UpdateApp(String classname, String filename, boolean key) {
		if (key) {
			uninstall(classname);
			install(filename);
		}else{
			uninstall(classname);
		}
		
	}
	//安装
	public void install(String filename) {
		execCmd("cmd /c adb install c:\\users\\user\\Desktop\\"+filename+".apk");
		System.out.println("安装成功！");
	}
	//卸载
	public void uninstall(String classname) {
		execCmd("cmd /c adb uninstall "+classname);
		System.out.println("卸载成功！");
	}
	public void execCmd(String cmd) {
		System.out.println("----execCmd:  " + cmd);
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			// 正确输出流
			InputStream input = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = "";
			while ((line = reader.readLine()) != null) {
				//因为安装过程中，会不断输出发送百分比，这里就只输出“Success”
				if(line.equalsIgnoreCase("Success")){
					System.out.println(line);
				}
				//虽然上一部屏蔽了一些信息，但还是会写入log文件中
				saveToFile(line, "runlog.log", false);
			}
			// 错误输出流，这里就不屏蔽任何错误信息了
			InputStream errorInput = p.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorInput));
			String eline = "";
			while ((eline = errorReader.readLine()) != null) {
				System.out.println(eline);
				saveToFile(eline, "runlog.log", false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//将文本写入文件中
	public void saveToFile(String text, String path, boolean isClose) {
		File file = new File("runlog.log");
		BufferedWriter bf = null;
		try {
			FileOutputStream outputStream = new FileOutputStream(file, true);
			OutputStreamWriter outWriter = new OutputStreamWriter(outputStream);
			bf = new BufferedWriter(outWriter);
			bf.append(text);
			bf.newLine();
			bf.flush();
			if (isClose) {
				bf.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
