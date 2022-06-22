package com.pizzaapi.pizzaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty STARTED("started"),@JsonProperty COOKING("cooking"),@JsonProperty READY("ready");

    private final String status;

    Status(final String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
