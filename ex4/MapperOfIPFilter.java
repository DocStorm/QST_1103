package No4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		Locale locale = Locale.US;
		SimpleDateFormat regularFormat = new SimpleDateFormat("dd/MMM/yy:HH:mm:ss", locale);
		//获取命令行输入，第一个为起始时间，第二个为终止时间
		Date beginDate = regularFormat.parse(args[0]);
		Date endDate = regularFormat.parse(args[1]);
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
