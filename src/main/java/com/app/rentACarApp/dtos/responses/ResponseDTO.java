package com.app.rentACarApp.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO {
    private String status;
    private String message;

    public static ResponseDTO success(String message) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("success");
        response.setMessage(message);
        return response;
    }

    public static ResponseDTO error(String message) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("error");
        response.setMessage(message);
        return response;
    }
}
