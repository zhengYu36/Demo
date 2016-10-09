package com.linux.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 测试 可以用哈
 * */

public class WriteFileNew {

	private static Logger logger = Logger.getLogger(WriteFileNew.class);

	
	private static WriteFileNew uniqueInstance = null;
	
	/**
	 * 单例模式的调用直接通过类名.getInstance就可以了了
	 * eg:WriteFile w2 = WriteFile.getInstance();
	 * **/

	private WriteFileNew() {

	}

	// 首先实例化哈
	public static WriteFileNew getInstance() {
		logger.info("WriteFileNew getInstance");
		if (uniqueInstance == null) {
			uniqueInstance = new WriteFileNew();
		}
		return uniqueInstance;
	}
	
	public static void insertDateByPageHelper(List<String> list) {
		/***调用upload方法*/
		String ftpUserName = getProperValueByKeys("WRITE_USERNAME");  //远程文件名
		String ftpPassword = getProperValueByKeys("WRITE_PASSWORD");  //远程密码
		String ftpHost = getProperValueByKeys("WRITE_HOST");  //远程host
		int ftpPort = Integer.parseInt(getProperValueByKeys("WRITE_PORT"));  //远程端口
		upload(ftpUserName, ftpPassword, ftpHost, ftpPort, list);
	}
	
	/**
	 * 本地上传文件到FTP服务器
	 * 
	 * @param ftpPath
	 *            远程文件路径FTP
	 * @throws IOException
	 * list 是需要写入的数据
	 */
	public static void upload(String ftpUserName, String ftpPassword,
			String ftpHost, int ftpPort, List<String> list) {
		FTPClient ftpClient = null;
		logger.info("开始上传文件到FTP.");
		try {
			ftpClient = FTPUtil.getFTPClient(ftpHost, ftpPassword, ftpUserName,
					ftpPort);
			// 设置PassiveMode传输
			ftpClient.enterLocalPassiveMode();
			// 设置以二进制流的方式传输
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

			// ====================
			logger.info("将list数据 插入到指定的 文件路径下");
			// 判断list是否有数据哈
			if (list == null || list.size() < 1) {
				return;
			}
			int pageSize = 200; // 默认每页数据
			int totalSize = list.size();
			int totalPage = (totalSize - 1) / pageSize + 1;// 页码，逢1进1
			if (totalSize < pageSize) {
				pageSize = list.size();
			}

			for (int i = 0; i < totalPage; i++) {
				int pageNo = i + 1;
				List<String> sublist = list.subList((pageNo - 1) * pageSize,
						pageNo * pageSize > totalSize ? (totalSize) : pageNo
								* pageSize);
				/** 这里为了防止系统执行太快， 默认延迟一秒执行 **/
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String remoteFileName = "SMS_file_"+getCurrent()+".log";  // 得到系统时间当作方法名
				String path = getProperValueByKeys("WRITE_FILE");  //远程文件路径
				boolean writeResult = WriteStringBuffer(remoteFileName, sublist,  
						path);  
	            if (writeResult) {  	
	                File f = new File(path + "/" + remoteFileName);  
	                InputStream in = new FileInputStream(f);  
	                //ftpClient.storeFile(remoteFileName, in);  
	                ftpClient.storeFile(path + "/" + remoteFileName, in);    
	                boolean isok = ftpClient.sendSiteCommand("chmod 664 "+ path + "/" + remoteFileName);
	                in.close();  
	                logger.info("上传文件" + remoteFileName + "到FTP成功!");  
	                f.delete(); 
	            } else {  
	                logger.info("写文件失败!");  
	            } 
				

			}
			// =================
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 把配置文件先写到本地的一个文件中取
	 * 
	 * @param ftpPath
	 * @param str
	 * @return
	 */
	public boolean write(String fileName, String fileContext,
			String writeTempFielPath) {
		try {
			logger.info("开始写配置文件");
			File f = new File(writeTempFielPath + "/" + fileName);
			if (!f.exists()) {
				if (!f.createNewFile()) {
					logger.info("文件不存在，创建失败!");
				}
			}
			f.setExecutable(true);
			f.setWritable(true);
			f.setReadable(true);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			bw.write(fileContext.replaceAll("\n", "\r\n"));
			bw.flush();
			bw.close();
			return true;
		} catch (Exception e) {
			logger.error("写文件没有成功");
			e.printStackTrace();
			return false;
		}
	}

	/** 得到系统当前时间 **/
	public static String getCurrent() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}

	/***
	 * 读取配置文件
	 */
	public static String getProperValueByKeys(String key) {
		InputStream inputStream = WriteFileNew.class.getClassLoader()
				.getResourceAsStream("config.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
		}

		return properties.getProperty(key); // 返回阀值
	}

	/** 写入数据到指定的位置 **/
	public static boolean WriteStringBuffer(String fileName, List<String> list,
			String writeTempFielPath) {
		try {
			logger.info("#写入本地临时文件开始#");
			File file = new File(writeTempFielPath + File.separator + fileName);  
			file.exists();
			if (!file.exists())
				file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, false);
			for (int i = 0; i < list.size(); i++) {
				StringBuffer sb = new StringBuffer();
				sb.append(list.get(i));
				out.write(sb.toString().getBytes("utf-8"));
				// 使换行符转为字节数组
				byte[] newLine = "\n".getBytes(); // 还可以有另外一种方式（） 在unix下的是"\n"
													// win 下是"\r\n"
				// 写入换行
				out.write(newLine);
			}
			out.close();
			logger.info("写入文件成功");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("写入文件失败:消息为:" + e.getMessage());
			return false;
		}

	}
}
