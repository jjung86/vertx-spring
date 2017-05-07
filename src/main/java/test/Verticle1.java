package test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class Verticle1 extends AbstractVerticle{
	
	@Override
	public void start(){
		HttpServer server = vertx.createHttpServer();

		Router router = Router.router(vertx);

		router.route("/momo").handler(routingContext -> {

		  // This handler will be called for every request
		  HttpServerResponse response = routingContext.response();
		  response.putHeader("content-type", "text/plain");

		  // Write to the response and end it
		  response.end("momo");
		});

		server.requestHandler(router::accept).listen(8777);
	}

}
