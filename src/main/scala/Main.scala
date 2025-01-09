import zio.*
import zio.http.*
object Main extends ZIOAppDefault:
  def run =
    trait One
    trait Two
    case class OneLive() extends One
    case class TwoLive() extends Two
    val routes = Routes(
      Method.GET / "one" -> handler {
        for {
          one <- ZIO.serviceAt[One]("one")
        } yield (Response.ok)
      },
      Method.GET / "two" -> handler {
        for {
          two <- ZIO.serviceAt[Two]("two")
        } yield (Response.ok)
      }
    )
    val layerOne = ZLayer.succeed(Map[String, One]("one" -> OneLive()))
    val layerTwo = ZLayer.succeed(Map[String, Two]("two" -> TwoLive()))
    val combined = layerOne ++ layerTwo
    Server.serve(routes).provide(Server.default, combined)
