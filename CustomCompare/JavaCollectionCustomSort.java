import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class JavaCollectionCustomSort {

	public static void main(String[] args) {
		fileDbCustomSort();
	}

	@SuppressWarnings("unchecked")
	private static void fileDbCustomSort() {
		FileWriter writer = null;
		ArrayList<Data> dataList = null;
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("Database.txt"));
			dataList = new ArrayList<>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				dataList.add(parse(line));
			}
			reader.close();

			Collections.sort(dataList);

			writer = new FileWriter("finals.txt");
			for (Data d : dataList) {
				writer.write(d.toString());
				writer.write("\r\n");
			}

			writer.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {

		}

	}

	private static Data parse(String line) {
		String[] sArray = line.split(",");
		return new Data(Integer.valueOf(sArray[1]), sArray[0], sArray[2], sArray[3]);

	}

}

class Data implements Comparable{
	int val;// 1
	String name;// Daddy
	String status;// Good
	String mode; //bad
	Data(int val, String name, String status, String mode){
		this.val = val;
		this.name = name;
		this.status = status;
		this.mode = mode;
	}
	
	@Override
	public String toString() {
		return name+","+ val + ","+ status+","+ mode;
	}
	
	@Override
	public int compareTo(Object data) {
		 int compareVal=((Data)data).val;
	        
	    return this.val-compareVal;

	        /* For Descending order do like this */
	        //return compareVal-this.val;
	  }
}
