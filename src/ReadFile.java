import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFile<E> {
    public static ArrayList<SanPham> read() {
        ArrayList<SanPham> dssp = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {

            fis = new FileInputStream("text.txt");
            ois = new ObjectInputStream(fis);
            dssp = (ArrayList<SanPham>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return dssp;
    }
}
