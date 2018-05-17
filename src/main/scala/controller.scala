import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.text.Text


class controller() {
  @FXML
  private[this] var actiontarget:Text =_

  @FXML
  private[this] def handleSubmitButtonAction(event: ActionEvent){
    actiontarget.setText("Sign in button pressed")
  }
}
