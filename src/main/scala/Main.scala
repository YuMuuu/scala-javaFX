import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

class Main extends Application {
  override def start(stage: Stage) {
    val root:Parent = FXMLLoader.load(getClass.getResource("fxml_example.fxml"))
    val scene = new Scene(root, 300, 275)
    stage.setTitle("FXML Welcome")
    stage.setScene(scene)
    stage.show
  }

}