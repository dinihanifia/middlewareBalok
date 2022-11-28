package com.svc.mw.validation;

import com.svc.mw.config.Enum.ErrorConstant;
import com.svc.mw.config.Enum.ErrorMessageConstant;
import com.svc.mw.config.Enum.HeaderConstant;
import com.svc.mw.config.Enum.SegiConstant;
import com.svc.mw.controller.Controller;
import com.svc.mw.pojo.response.ErrorCodeResponse;
import com.svc.mw.pojo.response.PersegiPanjangResponse;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataValidation {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(DataValidation.class);

    public Boolean checkOperasi(String Operasi) {
        if(StringUtils.isBlank(Operasi) && (Operasi != HeaderConstant.OPERASI_VALUE)
        ){
            return true;
        }
        return false;
    }

    public ErrorCodeResponse checkEmptyInteger(List<String> segi, int value, int length){
        ErrorCodeResponse errorCodeResponse = new ErrorCodeResponse();
        if(value==0){
            errorCodeResponse.setResponseCode(ErrorConstant.BAD_REQUEST);
            errorCodeResponse.setResponseMessage(SegiConstant.MESSAGE_CHECK_REQUEST+segi.get(0));
            return errorCodeResponse;
        }
        return this.checkLength(segi,value,length);
    }

    public PersegiPanjangResponse convertMessage(ErrorCodeResponse errorCodeResponse){
        PersegiPanjangResponse persegiPanjangResponse = new PersegiPanjangResponse();
        persegiPanjangResponse.setCode(HttpStatus.BAD_REQUEST);
        persegiPanjangResponse.setRetrunCode(false);
        persegiPanjangResponse.setResponseCode(errorCodeResponse.getResponseCode());
        persegiPanjangResponse.setResponseMessage(errorCodeResponse.getResponseMessage());
        return persegiPanjangResponse;
    }

    public ErrorCodeResponse checkLength(List<String> segi, int value, int length){
        ErrorCodeResponse errorCodeResponse = new ErrorCodeResponse();
        switch (segi.get(1)){
            case ">":
            if(value>length){
                errorCodeResponse.setResponseCode(ErrorConstant.BAD_REQUEST);
                errorCodeResponse.setResponseMessage(ErrorMessageConstant.BAD_REQUEST);
                return errorCodeResponse;
            }
            break;
            case "!=":
            if(value!=length){
                errorCodeResponse.setResponseCode(ErrorConstant.BAD_REQUEST);
                errorCodeResponse.setResponseMessage(ErrorMessageConstant.BAD_REQUEST);
                return errorCodeResponse;
            }
            break;
        }
        return null;
    }

//    public PersegiPanjangResponse errorCodeResponse( int code, String message){
//        ErrorCodeResponse errorCodeResponse = new ErrorCodeResponse();
//        errorCodeResponse.setResponseCode(code);
//        errorCodeResponse.setResponseMessage(message);
//        return this.convertMessage(errorCodeResponse);
//    }
}
