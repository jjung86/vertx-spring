package test;

import io.vertx.core.Vertx;

public class VerticleRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vertx vertx = Vertx.vertx();//vertx객체를 만들어준다.
		vertx.deployVerticle(new MyVerticle());
		vertx.deployVerticle(new Verticle1());
		vertx.deployVerticle(new Sockjs());
	}

}
