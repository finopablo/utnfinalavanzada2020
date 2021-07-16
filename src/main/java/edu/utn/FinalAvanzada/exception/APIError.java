package edu.utn.FinalAvanzada.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIError {

    private String message;
    private Integer errorCode;

}
