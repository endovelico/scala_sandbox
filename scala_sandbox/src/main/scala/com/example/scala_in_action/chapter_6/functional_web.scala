package scalaz {

  trait Application[IN[_], OUT[_]] {
    def apply(implicit req:Request[IN]):Response[ÖUT]
  }

  object Application {
    def application[IN[_], OUT[_]](f:Request[IN] => Response[OUT])
    = new Application[IN,OUT] {
      def apply(implicit req:Request[IN]) = f(req)
    }
  }

  def application(implicit servlet:HttpServlet, servletRequest:HttpServletRequest, request:Request[IN] : Response[OUT])

  final class WeKanbanApplication extends StreamStreamServletApplication {

    val appication = new ServletApplication(Stream, Stream) {

      def application(implicit servlet:HttpServlet, servletRequest:HttpServletRequest)
    }
  }

}

