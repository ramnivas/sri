package sri.web

import org.scalajs.dom
import org.scalajs.dom.raw.Element
import sri.core._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
object ReactDOM extends js.Object {

  // i know what i am doing! okay go a head ..
  @JSName("render") def renderJS(elm: js.Any, dom: js.Any, callback: js.Function = ???): js.Any = js.native

  def render[P,S](elm: ReactElementU[P,S], dom: Element, callback: js.Function = ???): ReactElementM[P,S] = js.native

  def unmountComponentAtNode(container: js.Any): Boolean = js.native

  def findDOMNode(component: ReactComponent[_, _]): dom.Node = js.native

  def renderToString(element: ReactElement): String = js.native

  def renderToStaticMarkup(element: ReactElement): String = js.native

  def initializeTouchEvents(shouldUseTouch: Boolean): Unit = js.native
}

@js.native
object ReactDOMServer extends js.Object {

  def renderToString(element: ReactElement): String = js.native

  def renderToStaticMarkup(element: ReactElement): String = js.native


}