import java.io.*;
import org.apache.commons.csv.*;
public class CSVDemo {
public static void main(String[] args) {
try {
Reader in = new FileReader("data.csv");
Iterable<CSVRecord> records = 
CS
VFormat.DEFAULT.
withHeader(
"
First Name
"
, 
"
Last Name
"
, 
"
SID
"
, 
"
Grade
"
).
parse(in);
for (CSVRecord record: records) {
String lastName = record.get("Last Name");
String firstName = record.get("First Name");
String grad
e = record.get("
Grade
");
System.out.println(firstName + " " + lastName
+ 
"
(
"
+ 
grade + 
"
)
"
);
}
} catch (IOException e) {
e.printStackTrace();
}
}
}