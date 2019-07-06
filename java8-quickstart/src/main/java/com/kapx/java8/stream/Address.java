package com.kapx.java8.stream;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Address {
    private String address1;
    private String address2;
    private String city;
    private String county;
}
