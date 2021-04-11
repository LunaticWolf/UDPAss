import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.util.ArrayList;

public class ReadData 
{
		public static void main(String[] args) throws IOException 
		{
		
			String filename = "src/member.txt";
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr); 
			
			String line = null;
			ArrayList<String> memberdata = new ArrayList<>();
			while((line=br.readLine())!=null)
			memberdata.add(line);
			
			
			ArrayList<Customer> customerData = new ArrayList<>();
			for(int i=0;i<memberdata.size();i++)
			{
				String values[] = memberdata.get(i).split(" ");
				customerData.add(new Customer(values[0], Integer.parseInt(values[1])));
			}
			
		
		}
	
	
	
}
