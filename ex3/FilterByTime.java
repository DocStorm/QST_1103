package No3;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class DifferentFormat {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		Locale locale = Locale.US;
		SimpleDateFormat regularFormat = new SimpleDateFormat("dd/MMM/yy:HH:mm:ss", locale);
		Date beginDate = regularFormat.parse("31/Dec/2015:18:00:00");
		Date endDate = regularFormat.parse("31/Dec/2015:19:00:00");
		long bd = beginDate.getTime();//将起始时间转换为时间戳
		long ed = endDate.getTime();//将终止时间装换为时间戳
		String filePath = "C:\\Users\\炫\\Desktop\\data.txt";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]* [^ ]* \\[([^ ]* [^ ]*)\\] .*";
		Pattern r = Pattern.compile(pattern);
		while (scanner.hasNext()){
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
			String strIp = null;
			String strTime = null;
			// 对在时间区间内的数据进行输出
			Matcher m = r.matcher(line);
			if (m.find()){
				strIp = m.group(1);
				strTime = m.group(2);
			}
			long time = regularFormat.parse(strTime).getTime();//将文件中提取的日期型字符串解析为日期并转换为时间戳
			//判断时间戳是否在起止时间戳区间内，如果在，输出IP和Time，以tab分割
			if(bd <= time && time <= ed){
				System.out.println(strIp + "\t" + strTime);
			}
		}
	}
	
}
