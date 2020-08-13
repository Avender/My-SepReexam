package Library.model;

import java.io.File;
import java.io.PrintWriter;

public interface CSVSave {
static void CSVSave (String pathname, String[] text) throws Exception{
    File file = new File (pathname);
    PrintWriter out = new PrintWriter (file);
    for (int i = 0; i< text.length; i++){
        out.println (text[i]);
        out.flush ();
    }
    out.close ();
}
    void saveToCSV ();

}
