package com.example.media.media.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {

   private LocalDateTime timestamp;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    private String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    private  String details;

}
