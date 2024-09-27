package com.example.user_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record AlertDto(
        String title,
        String description,
        String severity,

        @JsonProperty("effective_utc") String effectiveUtc,
        @JsonProperty("effective_local") String effectiveLocal,
        @JsonProperty("expires_utc") String expiresUtc,
        @JsonProperty("expires_local") String expiresLocal,
        @JsonProperty("onset_utc") String onsetUtc,
        @JsonProperty("onset_local") String onsetLocal,
        @JsonProperty("ends_utc") String endsUtc,
        @JsonProperty("ends_local") String endsLocal,

        String uri,
        List<String> regions
) {}

