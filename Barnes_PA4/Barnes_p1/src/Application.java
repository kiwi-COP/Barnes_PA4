public class Application {
   public static void main(String[] args) {
      
       DuplicateRemover DP = new DuplicateRemover();
      
       DP.remove("problem1.txt");
       DP.write("unique_words.txt");
      
   }
}
