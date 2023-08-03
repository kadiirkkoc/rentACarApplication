package com.app.rentACarApp.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class ErrorDetails {
    private final String message;
    private final String details;

}
