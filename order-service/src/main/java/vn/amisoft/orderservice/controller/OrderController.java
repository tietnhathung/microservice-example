package vn.amisoft.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.amisoft.orderservice.dto.OrderRequest;
import vn.amisoft.orderservice.service.OrderService;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    @CircuitBreaker(name = "inventory",fallbackMethod = "fallbackMethod")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest){
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest,RuntimeException runtimeException){
        return CompletableFuture.supplyAsync( () -> "Oops! Something went wrong, please order some time!" );
    }
}
