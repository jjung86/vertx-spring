package test;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;

public class Sockjs extends AbstractVerticle{

	@Override
	public void start() {
		Router router = Router.router(vertx);

		SockJSHandlerOptions options = new SockJSHandlerOptions().setHeartbeatInterval(2000);

		SockJSHandler sockJSHandler = SockJSHandler.create(vertx, options);

		sockJSHandler.socketHandler(sockJSSocket -> {
		  
		  sockJSSocket.write("<h1>SockJS!</h1>");
		  sockJSSocket.end();
		});

		router.route("/myapp/*").handler(sockJSHandler);
	}
}
