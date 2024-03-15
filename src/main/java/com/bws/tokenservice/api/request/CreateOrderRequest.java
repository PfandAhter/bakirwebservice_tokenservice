package com.bws.tokenservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateOrderRequest extends BaseRequest {

    private String username;

    private Long productCode;

    private int orderQuantity;
}

