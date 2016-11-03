package No4;

import java.util.HashSet;
import java.util.Scanner;

public class ReducerOfIPFilter {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		HashSet<String> setVisitPaths = new HashSet<String>();
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			String[] tokens = line.split("\t");
			setVisitPaths.add(tokens[0]);
		}
		System.out.println(setVisitPaths.size());
	}
}
