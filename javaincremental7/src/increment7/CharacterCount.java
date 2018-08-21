package increment7;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Using TextFile and a Map<Character,Integer>, create a program that takes the file
 * name as a command line argument and counts the occurrence of all the different characters.
 * Save the results in a text file.
 */

public class CharacterCount {

    public static void main(String[] filename) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        try {
            //reading of the file
            FileInputStream inputStream = new FileInputStream("input.txt");
            InputStreamReader reader = new InputStreamReader(inputStream);
            FileOutputStream outputStream = new FileOutputStream("output.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            int character;
            while ((character = reader.read()) != -1) {
                int val;
                if(m.containsKey((char)character)==true)
                    val=m.get((char)character);
                else
                    val=0;
                m.put((char)character, val + 1);
            }
            reader.close();
            //Save the result in a text file
            for (Map.Entry<Character, Integer> e : m.entrySet()) {
                bufferedWriter.write((char)e.getKey() + " -> " + e.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}