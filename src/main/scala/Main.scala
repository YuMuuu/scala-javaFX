import javafx.application.Application
import javafx.scene.effect.{BlendMode, BoxBlur}
import javafx.scene.paint.{Color, CycleMethod, LinearGradient, Stop}
import javafx.scene.{Group, Node, Parent, Scene}
import javafx.stage.Stage
import javafx.scene.shape.{Circle, Rectangle, StrokeType}
import javafx.util.Duration
import javafx.animation.{KeyFrame, KeyValue, Timeline}

import collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import javafx.collections.ObservableList
import scala.collection.JavaConversions._
//import static java.lang.Math.random

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}



class Main extends Application {
  override def start(stage: Stage) {

    val root = new Group
    val scene = new Scene(root, 800, 600, Color.BLACK)
    stage.setScene(scene)

    val circles = new Group
    for (i <- 0 to 29) {
      val circle = new Circle(150, Color.web("white", 0.05))
      circle.setStrokeType(StrokeType.OUTSIDE)
      circle.setStroke(Color.web("white", 0.16))
      circle.setStrokeWidth(4)
      circles.getChildren.add(circle)
    }

    val stops: java.util.List[Stop] = ArrayBuffer(
      new Stop(0, Color.web("#f8bd55")),
      new Stop(0.14, Color.web("#c0fe56")),
      new Stop(0.28, Color.web("#5dfbc1")),
      new Stop(0.43, Color.web("#64c2f8")),
      new Stop(0.57, Color.web("#be4af7")),
      new Stop(0.71, Color.web("#ed5fc2")),
      new Stop(0.85, Color.web("#ef504c")),
      new Stop(1, Color.web("#f2660f"))
    ).asJava
    val colors = new Rectangle(scene.getWidth, scene.getHeight, new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, stops))
    colors.widthProperty.bind(scene.widthProperty)
    colors.heightProperty.bind(scene.heightProperty)


    val blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth, scene.getHeight, Color.BLACK), circles), colors)
    colors.setBlendMode(BlendMode.OVERLAY)
    root.getChildren.add(blendModeGroup)

    circles.setEffect(new BoxBlur(10, 10, 3))

    val r = new Random

    //println(circles.getChildren)


    val timeline = new Timeline
     for (circle <- circles.getChildren) {
          timeline.getKeyFrames.addAll(
//            new KeyFrame(Duration.ZERO, // set start position at 0
//              new KeyValue(circle.translateXProperty, 800),
//              new KeyValue(circle.translateYProperty, 600)),
//            new KeyFrame(new Duration(40000), // set end position at 40s
//              new KeyValue(circle.translateXProperty, 800),
//              new KeyValue(circle.translateYProperty, 600))
       )
    }
     //play 40s of animation

    stage.show
  }

}