package Library.model;

import java.io.*;

public interface BySave extends Serializable {
    default void save (String filename){
        try{
            FileOutputStream fos = new FileOutputStream (filename);
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject (this);
            oos.flush ();
            oos.flush ();
        }catch (FileNotFoundException e){
            System.out.println ("ERROR FILE NOT FOUND");
        }
        catch (IOException e){
            System.out.println ("ERROR FILE CANNOT BE ACCESSIBLE");
        }
    }
    static Object load (String filename){
        Object obj = null;
        try{
            File file = new File (filename);
            FileInputStream fis = new FileInputStream (file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject ();
        }
        catch (FileNotFoundException e){
            System.out.println ("ERROR FILE NOT FOUND");
        }
        catch (IOException e){
            System.out.println ("ERROR FILE CANNOT BE ACCESSIBLE");
        }
        catch (ClassNotFoundException e){
            System.out.println ("ERROR CLASS NOT FOUND");
        }
        finally {
            return obj;
        }
    }
}
