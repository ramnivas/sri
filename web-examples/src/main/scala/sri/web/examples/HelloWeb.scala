package sri.web.examples

import sri.core._
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet
import sri.web.all._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.{UndefOr => U}

object HelloWeb {


  @ScalaJSDefined
  class Component extends ReactComponent[Unit, Unit] {
    def render() = {
      View(style = styles.container)(
        Text(style = styles.text)(s"Welcome to Sri Web"),
        Image(style = styles.image, source = ImageSource(uri = "http://www.scala-js.org/images/scala-js-logo-256.png"))(),
        Text(style = styles.text)("Scala.js - Future of app development!")
      )
    }

  }

  object styles extends UniversalStyleSheet {

    val container = style(flexOne,
      backgroundColor := "rgb(175, 9, 119)",
      justifyContent.center,
      alignItems.center)

    val image = style(width := 256, height := 256, margin := 20)

    val text = style(fontWeight._500,
      fontSize := 18,
      color := "white")

  }


  val ctor = getTypedConstructor(js.constructorOf[Component], classOf[Component])

//  val tctor = getTypedConstructor(js.constructorOf[Component],classOf[Component])

  def apply(key: js.UndefOr[String] = js.undefined, ref: js.Function1[Component, _] = null) = createElementNoProps(ctor, key = key, ref = ref)
}


@ScalaJSDefined
trait Test extends js.Object {

  val x: Int

  val y: js.UndefOr[js.Function]

}

@ScalaJSDefined
abstract class TestA extends Test {
  override val x: Int
  override val y: U[js.Function] = js.undefined
}