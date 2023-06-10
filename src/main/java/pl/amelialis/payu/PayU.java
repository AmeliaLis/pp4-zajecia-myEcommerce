package pl.amelialis.payu;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.amelialis.payu.OrderCreateRequest;
import pl.amelialis.payu.OrderCreateResponse;

//wysyłanie żądania http
public class PayU {
    RestTemplate http;

    public PayU(RestTemplate http) {
        this.http = http;
    }
    public OrderCreateResponse handle(OrderCreateRequest orderCreateRequest) {
        //wykonanie curl
        String url = "https://secure.snd.payu.com/api/v2_1/orders";

        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        headers.add("Authorization", String.format("Bearer %s", getToken()));

        HttpEntity<OrderCreateRequest> request = new HttpEntity<>(orderCreateRequest, headers);

        ResponseEntity<OrderCreateResponse> response = http.postForEntity(url, request, OrderCreateResponse.class);

        return response.getBody();

    }

    private Object getToken() {
        return "d9a4536e-62ba-4f60-8017-6053211d3f47";
    }
}