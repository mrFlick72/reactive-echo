package it.valeriovaudi.spike.reactiveecho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@SpringBootApplication
public class ReactiveEchoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveEchoApplication.class, args);
    }

}


@Configuration
class RouteConfig {

    @Bean
    public RouterFunction routes() {
        return RouterFunctions.route()
                .GET("/echo/{text}", serverRequest -> ok().body(fromValue(serverRequest.pathVariable("text"))))
                .build();
    }
}