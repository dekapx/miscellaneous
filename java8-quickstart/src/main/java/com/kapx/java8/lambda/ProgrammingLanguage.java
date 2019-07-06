package com.kapx.java8.lambda;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
class ProgrammingLanguage {
    private String language ;
    private String type;
}
