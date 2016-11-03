package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);//创建一个扫描器用于获取系统输入
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 初始化，并对日期字符串进行解析和格式化为yyyy-MM-dd HH:mm:ss
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//初始化，并对日期字符串进行解析和格式化为yyyy/MM/dd HH:mm:ss
		//不停读入每行输入
		while (scanner.hasNext()){
			String line = scanner.nextLine();//捕获每行输入的数据并赋值给变量line
			Date lineDate = null;//初始化日期类型的变量lineDate的值为空
			long lineTimestamp; //定义一个长整形的变量lineTimestamp
			try {
				lineDate = inputFormat.parse(line);//解析line中的日期字符串成日期并赋值给lineDate
				lineTimestamp = lineDate.getTime();//将lineDate中的日期转换为毫秒级的时间戳
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//拼接字符串并输出
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
