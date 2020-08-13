package Library.view;

import Library.model.LibraryModelManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {
  private LibraryModelManager model;
  private MainViewController mainViewController;
  private BorrowViewController borrowViewController;
  private AddBookViewController addBookViewController;
  private AddArticleViewController addArticleViewController;
  private AddCDViewController addCDViewController;
  private MainArticleViewController mainArticleViewController;
  private MainCDViewController mainCDViewController;
  private Scene currentScene;
  private Stage primaryStage;

  public ViewHandler(LibraryModelManager model) {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    openView("main");
  }

  public void openView(String id) {
    Region root = null;
    switch (id) {
      case "main":
        root = loadMainView("mainView.fxml");
        break;
      case "borrow":
        root = loadBorrowView("borrowView.fxml");
        break;
      case "addBook":
        root = loadAddBookView("addBookView.fxml");
        break;
      case "addArticle":
        root = loadAddArticleView("addArticleView.fxml");
        break;
      case "addCD":
        root = loadAddCDView("addCDView.fxml");
        break;
      case "mainArticle":
        root = loadMainArticleView("mainArticleView.fxml");
        break;
      case "mainCD":
        root = loadMainCDView("mainCDView.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "Library";
    if (root.getUserData() != null) {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.show();
  }

  public void closeView() {
    primaryStage.close();
  }

  private Region loadMainView(String fxmlFile) {
    Region root = null;
    if (mainViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library/resources/"+fxmlFile));
        root = loader.load();
        mainViewController = loader.getController();
        mainViewController.init(this, model, root);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      mainViewController.reset();
    }
    return mainViewController.getRoot();
  }

  private Region loadBorrowView(String fxmlFile) {
    Region root = null;
    if (borrowViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library/resources/"+fxmlFile));
        root = loader.load();
        borrowViewController = loader.getController();
        borrowViewController.init(this, model, root);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    else  {
      borrowViewController.reset();
    }
    return borrowViewController.getRoot();
  }

  private Region loadAddBookView(String fxmlFile) {
    Region root = null;
    if (addBookViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library/resources/"+fxmlFile));
        root = loader.load();
        addBookViewController = loader.getController();
        addBookViewController.init(this, model, root);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    else  {
      addBookViewController.reset();
    }
    return addBookViewController.getRoot();
  }

  private Region loadAddArticleView(String fxmlFile) {
    Region root = null;
    if (addArticleViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library/resources/"+fxmlFile));
        root = loader.load();
        addArticleViewController = loader.getController();
        addArticleViewController.init(this, model, root);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    else  {
      addArticleViewController.reset();
    }
    return addArticleViewController.getRoot();
  }

  private Region loadAddCDView(String fxmlFile) {
    Region root = null;
    if (addCDViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library/resources/"+fxmlFile));
        root = loader.load();
        addCDViewController = loader.getController();
        addCDViewController.init(this, model, root);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    else  {
      addCDViewController.reset();
    }
    return addCDViewController.getRoot();
  }

  private Region loadMainArticleView(String fxmlFile) {
    Region root = null;
    if (mainArticleViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library/resources/"+fxmlFile));
        root = loader.load();
        mainArticleViewController = loader.getController();
        mainArticleViewController.init(this, model, root);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      mainArticleViewController.reset();
    }
    return mainArticleViewController.getRoot();
  }

  private Region loadMainCDView(String fxmlFile) {
    Region root = null;
    if (mainCDViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library/resources/"+fxmlFile));
        root = loader.load();
        mainCDViewController = loader.getController();
        mainCDViewController.init(this, model, root);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      mainCDViewController.reset();
    }
    return mainCDViewController.getRoot();
  }
}
