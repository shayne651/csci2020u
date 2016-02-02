package csci2020u.lab02;
import java.io.*;
import org.apache.commons.csv.*;

public class CSVDemo
{
	public static void main(String[] args) 
	{
		try{
			Reader in = new FileReader("data.csv");
			Iterable<CSVRecord> records =CSVFormat.DEFAULT.withHeader("First Name","Last Name", "SID","Grade").parse(in);
			for(CSVRecord record:records)
			{
				String lastName = records.get("Last Name");
				String firstName = records.get("First Name");
				String grade = records.get("Grade");
				System.out.println(firstName+ " "+lastName+ " ("+grade+")");
			}
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}