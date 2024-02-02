package com.hostel.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;


@SpringBootApplication
public class VertxApplication {

	public static void main(String[] args) {
		SpringApplication.run(VertxApplication.class, args);
		
		
		Vertx vertx = Vertx.vertx();
		
		HttpServer server = vertx.createHttpServer();
		
		Router router = Router.router(vertx);
		
		Route handler = router.route().handler(routingContext->
				{
			HttpServerResponse serverResponce = routingContext.response();
			serverResponce.setChunked(true).write("Hello world");
			
			serverResponce.end();
				});
		
		server.requestHandler(router).listen(1045);
		
	
		
		}

}
