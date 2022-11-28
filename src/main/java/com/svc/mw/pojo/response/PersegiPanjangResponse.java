package com.svc.mw.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersegiPanjangResponse {
//    private String message;
    private HttpStatus code;
    private Boolean retrunCode;
    private int responseCode;
    private String responseMessage;
    private int panjang;
    private int lebar;
    private int tinggi;
    private int hasil;

    public Boolean getRetrunCode() {
        return retrunCode;
    }
    public void setRetrunCode(Boolean retrunCode) {
        this.retrunCode = retrunCode;
    }
}
