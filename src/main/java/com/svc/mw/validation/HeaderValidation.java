package com.svc.mw.validation;

import com.svc.mw.config.Enum.ErrorConstant;
import com.svc.mw.config.Enum.ErrorMessageConstant;
import com.svc.mw.config.Enum.HeaderConstant;
import com.svc.mw.controller.Controller;
import com.svc.mw.pojo.response.PersegiPanjangResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HeaderValidation {

    @Autowired
    private DataValidation dataValidation;

    private static org.slf4j.Logger log = LoggerFactory.getLogger(HeaderValidation.class);

    public PersegiPanjangResponse siPalingValid(HttpServletRequest httpServletRequest){
        PersegiPanjangResponse persegiPanjangResponse = new PersegiPanjangResponse();
        persegiPanjangResponse.setCode(HttpStatus.OK);
        persegiPanjangResponse.setResponseCode(ErrorConstant.SUCCESSFUL);
        persegiPanjangResponse.setResponseMessage(ErrorMessageConstant.SUCCESS);
        try{
            if(dataValidation.checkOperasi(httpServletRequest.getHeader(HeaderConstant.OPERASI))){
                persegiPanjangResponse.setCode(HttpStatus.BAD_REQUEST);
                persegiPanjangResponse.setRetrunCode(false);
                persegiPanjangResponse.setResponseCode(ErrorConstant.BAD_REQUEST);
                persegiPanjangResponse.setResponseMessage(ErrorMessageConstant.BAD_REQUEST);
            }
            return persegiPanjangResponse;
        }
        catch (Exception e){
            persegiPanjangResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            persegiPanjangResponse.setRetrunCode(false);
            persegiPanjangResponse.setResponseCode(ErrorConstant.SYSTEM_ERROR);
            persegiPanjangResponse.setResponseMessage(ErrorMessageConstant.ISE);
            return persegiPanjangResponse;
        }
    }
}
