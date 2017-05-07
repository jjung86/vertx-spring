package vertx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

@Component
public class VertxServerVerticle extends AbstractVerticle{
	
	@Autowired
	private ApplicationConfiguration applicationConfiguration;
	
	@Override
	public void start()throws Exception{
		super.start();//에러가 발생할수있는 메서드 이기때문에 throws exception이필요.
		vertx.createHttpServer().requestHandler(router()::accept).listen(applicationConfiguration.httpPort());
	}
	private Router router(){
		Router router = Router.router(vertx);
		router.route("/info").handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response.putHeader("Content-Type", "text/html");
			response.end("<h1>hello</h1>");
		});
		return router ;
	}

}
