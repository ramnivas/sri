package chandu0101.scalajs.sri.web.examples

import chandu0101.scalajs.sri.core._
import chandu0101.scalajs.sri.web.ReactDOM
import chandu0101.scalajs.sri.web.styles.WebStyleSheet
import org.scalajs.dom
import org.scalajs.dom.raw.HTMLDivElement
import scala.scalajs.js
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSName, JSExport, ScalaJSDefined}


object WebApp extends JSApp{

  case class SmallHelloProps(name : String)

  @ScalaJSDefined
  class SmallHello extends ReactComponent[SmallHelloProps,Any] {

    val displayName : String = "asdsadsa"


    def render() = {
      React.createElement("div",json(id = "huh",onClick = onClick _),"i am a small hello")
    }

    //    state = JSSt State()

    def onClick(e : js.Dynamic) = {
      println(s"small props ${props.name}")
    }


    override def componentDidMount() = {
      println(s"dude small hello")
    }
  }

  object SmallHello {
    def apply(props : SmallHelloProps) = createElement(props = props,instance = new SmallHello(),ref = "smallman")
  }

  case class HelloProps(name : String)

  case class State(count : Int = 0)

  @ScalaJSDefined
  class Hello extends ReactComponent[HelloProps,State] {

    val displayName : String = "asdsadsa"

    initialState(State())

    def render() = {
      React.createElement("div",json(key = "heh" ,onClick = onClick _ ,style = styles.div),SmallHello(SmallHelloProps("small")))
    }

    def onClick(e : js.Dynamic) = {
      setState(state.copy(count = state.count + 1))
      println(s"new count :  ${state.count}")
    }

    override def componentDidMount() = {
      println(s"component mounted ")
    }

    override def componentWillMount() = {
      println(s"mounting component")
    }

    override def componentWillUnmount(): Unit = {
      println(s"un mounting component")
    }

//    @JSName("sComponentWillUpdate") override def componentWillUpdate(nextProps : Unit,nextState : State) : Unit = {
//      println(s"ok whats going on ")
//    }



  }

  object  styles extends WebStyleSheet {

    val div = style(border := "1px solid grey",
    padding := "10px")
  }

  object Hello {

    def apply(props : HelloProps)(children: ReactElement*) =
      ElementFactory(new Hello).key("dude").props(props).children(children: _*).key("man").build
  }

  @JSExport
  override def main(): Unit = {
    println(s"dude 4 ${this.getClass.getName}")
    val dummyHello = new Hello
    val x = List(1,2,3)
    println(s" list x $x")
    val ctor = dummyHello.asInstanceOf[js.Dynamic].constructor
    js.Dynamic.global.Hello = ctor
    ReactDOM.render(Hello(props = HelloProps("dude2"))(), dom.document.getElementById("container"))
  }
}
