import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class DomaciZadatak1 {
    public static int[] niz(int[] niz2){
        int count = 0;
        for (int i = 0; i < niz2.length; i++) {
            if (niz2[i] != 0){
                niz2[count++] = niz2[i];
            }
        }
        while (count < niz2.length){
            niz2[count++] = 0;
    }
        return niz2;
    }

    public static void main(String[] args) {
        Random r = new Random();

        try {
            FileWriter fileWriter =
                    new FileWriter("test.txt");

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);
            int[] integers = new int[20];
            int[] integersCopy = new int[20];
            for (int i = 0; i < 1000; i++){
                for (int j = 0; j < integers.length; j++) {
                    integers[j] = r.nextInt(10);
                    integersCopy[j] = integers[j];
                }

                bufferedWriter.write("assertEquals(new int[]{");
                bufferedWriter.write(Arrays.toString(niz(integers)));
                bufferedWriter.write("}, niz(new int[]{");
                bufferedWriter.write(Arrays.toString(integersCopy));
                bufferedWriter.write("});\n");
            }

            bufferedWriter.close();
        }
        catch(IOException ex) {
             ex.printStackTrace();
        }
    }
}
