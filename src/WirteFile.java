import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WirteFile<E> {
    public static void WriteFile(ArrayList<SanPham> dssp) {
        File file = new File("text.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dssp);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}}
