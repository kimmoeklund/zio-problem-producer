import zio.*
import zio.http.*
object Main extends ZIOAppDefault:
  def run =
    trait One
    trait Two
    case class OneLive() extends One
    case class TwoLive() extends Two
    val routes = Routes(
      Method.GET / "one" -> handler(ZIO.serviceAt[One]("one").map(_ => Response.ok)),
      Method.GET / "two" -> handler(ZIO.serviceAt[Two]("two").map(_ => Response.ok))
    ) 
    val layerOne = ZLayer.succeed(Map[String, One]("one" -> OneLive()))
    val layerTwo = ZLayer.succeed(Map[String, Two]("two" -> TwoLive()))
    val combined = layerOne ++ layerTwo
    Server.serve(routes).provide(Server.default, combined)
