package com.example.user_management.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Alert {

    private String title;
    private String description;
    private String severity;

    @JsonProperty("effective_utc")
    private String effectiveUtc;

    @JsonProperty("effective_local")
    private String effectiveLocal;

    @JsonProperty("expires_utc")
    private String expiresUtc;

    @JsonProperty("expires_local")
    private String expiresLocal;

    @JsonProperty("onset_utc")
    private String onsetUtc;

    @JsonProperty("onset_local")
    private String onsetLocal;

    @JsonProperty("ends_utc")
    private String endsUtc;

    @JsonProperty("ends_local")
    private String endsLocal;

    private String uri;
    private List<String> regions;

}
