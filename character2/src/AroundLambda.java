import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AroundLambda {
    public static String processFile() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("data.txt"));

        return br.readLine();
    }
}
