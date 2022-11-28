package com.svc.mw.service.impl;

import com.svc.mw.config.Enum.ErrorConstant;
import com.svc.mw.config.Enum.ErrorMessageConstant;
import com.svc.mw.config.Enum.SegiConstant;
import com.svc.mw.pojo.request.PersegiPanjangRequest;
import com.svc.mw.pojo.response.ErrorCodeResponse;
import com.svc.mw.pojo.response.PersegiPanjangResponse;
import com.svc.mw.service.RequestValidService;
import com.svc.mw.validation.DataValidation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RequestValidServiceImpl implements RequestValidService {

    private static Log log = LogFactory.getLog(RequestValidServiceImpl.class);
    @Override
    public PersegiPanjangResponse siPalingValid(PersegiPanjangRequest persegiPanjangRequest) {
        DataValidation dataValidation = new DataValidation();
//        if(persegiPanjangRequest.getPanjang()==0 || persegiPanjangRequest.getLebar()==0 || persegiPanjangRequest.getTinggi()==0){
////            siPalingRequest.setCode(HttpStatus.BAD_REQUEST);
//            ErrorCodeResponse errorCodeResponse = new ErrorCodeResponse();
//            errorCodeResponse.setResponseCode(400);
//            errorCodeResponse.setResponseMessage("Request gaboleh kosong");
//            return errorCodeResponse;
//        }
        //panjang
        ErrorCodeResponse panjang = dataValidation.checkEmptyInteger(SegiConstant.SEGI_PANJANG, persegiPanjangRequest.getPanjang(),9999999);
        if(panjang!=null){
            return dataValidation.convertMessage(panjang);
        }
        //lebar
        ErrorCodeResponse lebar = dataValidation.checkEmptyInteger(SegiConstant.SEGI_LEBAR, persegiPanjangRequest.getLebar(),9999999);
        if(lebar!=null){
            return dataValidation.convertMessage(lebar);
        }
        //tinggi
        ErrorCodeResponse tinggi = dataValidation.checkEmptyInteger(SegiConstant.SEGI_TINGGI, persegiPanjangRequest.getTinggi(),9999999);
        if(tinggi!=null){
            return dataValidation.convertMessage(tinggi);
        }
        PersegiPanjangResponse persegiPanjangResponse = new PersegiPanjangResponse();
        persegiPanjangResponse.setCode(HttpStatus.OK);
        persegiPanjangResponse.setRetrunCode(true);
        persegiPanjangResponse.setResponseCode(ErrorConstant.SUCCESSFUL);
        persegiPanjangResponse.setResponseMessage(ErrorMessageConstant.SUCCESS);
        return persegiPanjangResponse;
    }
}
