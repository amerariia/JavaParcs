import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Gen {
    private static int I = 1;
    public static void main(String[] args) throws IOException {
        int number = 1000;
        BufferedWriter writer = new BufferedWriter(new FileWriter("input"));
        writer.append(String.valueOf(number));
        writer.append(' ');
        writer.append('\n');
        writer.append(String.valueOf(number));
        writer.append(' ');
        writer.append('\n');
        Random rand = new Random();
        for(int i = 1; i <= number; i++){
            writer.append(String.valueOf(i));
            writer.append(' ');
            int nodes = rand.nextInt(i);
            Set<Integer> nodesSet = new HashSet<>();
            for(int j = 0; j < nodes; j++){
                int q = rand.nextInt(nodes);
                if(q == 0){
                    nodesSet.add(1);
                }else{
                    nodesSet.add(q);
                }

            }
            writer.append(String.valueOf(nodesSet.size()));
            writer.append(' ');
            List<Integer> list = new ArrayList<>(nodesSet);
            for(Integer o : list){
                writer.append(String.valueOf(o));
                writer.append(' ');
            }
            writer.append('\n');
        }
        writer.close();
    }
}
