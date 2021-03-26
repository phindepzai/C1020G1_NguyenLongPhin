package bai15_io_textfile;

import java.io.*;

public class WritterReader {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(new File("src\\bai15_io_textfile\\data\\data.txt")));

            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(new File("src\\bai15_io_textfile\\data\\dich.txt")));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line + "\n");
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
