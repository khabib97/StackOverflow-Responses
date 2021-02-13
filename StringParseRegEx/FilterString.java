import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterString {

	public static void main(String[] args) {
		FilterString fs = new FilterString();
		fs.filter();

	}

	public List filter() {
		List<String> originalList = Arrays.asList("A=1000,B=2,C=3", "A=11,B=12,C=13,D=15", "A=5,B=4,C=9,D=10,E=13",
				"A=19,B=20,C=91,D=40,E=33", "A=77,B=27,C=37");
		List<Integer> parsedData = new ArrayList();
		
		for(String str: originalList) {
			String[] strParsed = str.split("[A-Z=,]+");
			//for debugging
			//int index = 0;
			//for(String s : strParsed) System.out.print(index++ +":"+ s +" ");
			//System.out.println();
			//after parsing 0:A 1:1000 2:B 3:2 4:C 5:3 
			
			Integer data = Integer.parseInt(strParsed[1]);
			//System.out.println(data);
			parsedData.add(data);
			
		}
		return parsedData;
		
	}

}
