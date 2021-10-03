import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;;
import java.util.Random;


public class DomaciTest {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(">]aOZXWm[Wm\\OmaZOQYm^`WdOb\\cm^]`cYc(m8OdO\":gTS");
//       String s = ">]aOZXWm[Wm\\OmaZOQYm^`WdOb\\cm^]`cYc(m8OdO\":gTS";
//       s = s.replaceAll("[^a-zA-Z]", "");
//       sb.append(s);
        try {
            FileWriter fileWriter = new FileWriter("zadatak2.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < 100; i++) {
                shuffle(sb);
                bufferedWriter.write(String.valueOf(sb));
                bufferedWriter.write("\n");
                System.out.println(sb);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void shuffle(StringBuilder sb) {
        Random rand = new Random();
        for (int i = sb.length() - 1; i > 1; i--) {
            int swapWith = rand.nextInt(i);
            char tmp = sb.charAt(swapWith);
            sb.setCharAt(swapWith, sb.charAt(i));
            sb.setCharAt(i, tmp);
        }
    }
}