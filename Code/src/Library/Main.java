package Library;

import Library.model.LibraryItemsManager;
import Library.view.ViewHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application
{
    private LibraryItemsManager model;

    public static void main (String[] args) throws RuntimeException{
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("resources/mainView.fxml"));
        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        model = new LibraryItemsManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);

        File file = new File ("Code/test.txt");
        Scanner in = new Scanner (file);
        in.nextLine();
        in.close();
    }
}
