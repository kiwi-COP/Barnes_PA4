import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter
{
   private Map<String, Integer> wordCounter;
  
   public DuplicateCounter(){
       wordCounter = new HashMap<String,Integer>();
   }
  
   public void count(String filename){
      
       Scanner infile = null;
       try {
           infile = new Scanner(new File(filename));
       } catch (FileNotFoundException a) {
           System.out.println(a.getMessage());
           return;
       }
       
       while(infile.hasNext()) {
           String word = infile.next().toLowerCase();
           Integer count = wordCounter.get(word);
           if(count == null)
               count = 1;
           else
               count = count + 1;
           wordCounter.put(word, count);
       }
       infile.close();
   }
  
   public void write(String filename){
       
       try {
           PrintWriter outfile = new PrintWriter(new File(filename));
           for(String s : wordCounter.keySet()) {
               outfile.println(s + " " + wordCounter.get(s));
           }
           outfile.close();
           
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       }
   }
}
  