package com.svc.mw.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCodeResponse {
    private int responseCode;
    private String responseMessage;
}
