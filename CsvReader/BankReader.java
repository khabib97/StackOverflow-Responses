import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BankReader {

	public static void main(String[] args) {
		BankReader bankReader = new BankReader();
		bankReader.readCSV(new File("data.csv"));

	}
	
	
	public List<BankAccount> readCSV(File f){
        List<BankAccount> accounts = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null){
                String[] atrib = line.split(",");

                int id = Integer.parseInt(atrib[0]);
                String n = atrib[1];
                double b = Double.parseDouble(atrib[2]);

                BankAccount newAcc = new BankAccount(id,n,b);
                System.out.println(newAcc);
                accounts.add(newAcc);
                
                
                line = br.readLine();
            }

            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return accounts;
    }

}

class BankAccount{
	

	int id;
	String name;
	double balance;
	
	public BankAccount(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
}
