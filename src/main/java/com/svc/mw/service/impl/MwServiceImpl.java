package com.svc.mw.service.impl;

import com.svc.mw.config.Enum.HeaderConstant;
import com.svc.mw.pojo.request.PersegiPanjangRequest;
import com.svc.mw.pojo.response.BalokResponse;
import com.svc.mw.pojo.response.ErrorCodeResponse;
import com.svc.mw.pojo.response.PersegiPanjangResponse;
import com.svc.mw.service.MwService;
import com.svc.mw.service.RequestValidService;
import com.svc.mw.service.SesiService;
import com.svc.mw.validation.HeaderValidation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class MwServiceImpl implements MwService {
    private static Log log = LogFactory.getLog(MwServiceImpl.class);

    @Autowired
    private HeaderValidation headerValidation;

    @Autowired
    private RequestValidService requestValidService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private SesiService sesiService;

    @Override
    public ResponseEntity<?> getVolumeBalok(PersegiPanjangRequest persegiPanjangRequest, HttpServletRequest httpServletRequest) {
        PersegiPanjangResponse persegiPanjangResponse = new PersegiPanjangResponse();
        httpServletResponse.addHeader(HeaderConstant.OPERASI, HeaderConstant.OPERASI_VALUE);
        //request sesi service
        BalokResponse responseSesiSvc = sesiService.getVolumeBalok(persegiPanjangRequest);
        persegiPanjangResponse.setPanjang(responseSesiSvc.getPanjang());
        persegiPanjangResponse.setLebar(responseSesiSvc.getLebar());
        persegiPanjangResponse.setTinggi(responseSesiSvc.getTinggi());
        persegiPanjangResponse.setHasil(responseSesiSvc.getHasil());
        // validasi request
        PersegiPanjangResponse siPalingValid = requestValidService.siPalingValid(persegiPanjangRequest);
        siPalingValid.setPanjang(persegiPanjangRequest.getPanjang());
        siPalingValid.setLebar(persegiPanjangRequest.getLebar());
        siPalingValid.setTinggi(persegiPanjangRequest.getTinggi());
//        if(siPalingValid!=null){
        if(siPalingValid.getRetrunCode()==false){
            ErrorCodeResponse errorCodeResponse = new ErrorCodeResponse();
            errorCodeResponse.setResponseCode(siPalingValid.getResponseCode());
            errorCodeResponse.setResponseMessage(siPalingValid.getResponseMessage());
            return new ResponseEntity<>(siPalingValid,siPalingValid.getCode());
        }
        log.info("isi response [ "+siPalingValid+" ]");
        persegiPanjangResponse.setResponseCode(200);
        persegiPanjangResponse.setResponseMessage("sukses");
        return new ResponseEntity<>(persegiPanjangResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getLuasBalok(PersegiPanjangRequest persegiPanjangRequest) {
        PersegiPanjangResponse persegiPanjangResponse = new PersegiPanjangResponse();
        httpServletResponse.addHeader(HeaderConstant.OPERASI, HeaderConstant.OPERASI_VALUE);
        //request sesi service
        BalokResponse responseSesiSvc = sesiService.getLuasBalok(persegiPanjangRequest);
        persegiPanjangResponse.setPanjang(responseSesiSvc.getPanjang());
        persegiPanjangResponse.setLebar(responseSesiSvc.getLebar());
        persegiPanjangResponse.setTinggi(responseSesiSvc.getTinggi());
        persegiPanjangResponse.setHasil(responseSesiSvc.getHasil());
        // validasi request
        PersegiPanjangResponse siPalingValid = requestValidService.siPalingValid(persegiPanjangRequest);
        siPalingValid.setPanjang(persegiPanjangRequest.getPanjang());
        siPalingValid.setLebar(persegiPanjangRequest.getLebar());
        siPalingValid.setTinggi(persegiPanjangRequest.getTinggi());
//        if(siPalingValid!=null){
        if(siPalingValid.getRetrunCode()==false){
            ErrorCodeResponse errorCodeResponse = new ErrorCodeResponse();
            errorCodeResponse.setResponseCode(siPalingValid.getResponseCode());
            errorCodeResponse.setResponseMessage(siPalingValid.getResponseMessage());
            return new ResponseEntity<>(siPalingValid,siPalingValid.getCode());
        }
        log.info("isi response [ "+siPalingValid+" ]");
        persegiPanjangResponse.setResponseCode(200);
        persegiPanjangResponse.setResponseMessage("sukses");
        return new ResponseEntity<>(persegiPanjangResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getKelilingBalok(PersegiPanjangRequest persegiPanjangRequest) {
        PersegiPanjangResponse persegiPanjangResponse = new PersegiPanjangResponse();
        httpServletResponse.addHeader(HeaderConstant.OPERASI, HeaderConstant.OPERASI_VALUE);
        //request sesi service
        BalokResponse responseSesiSvc = sesiService.getKelilingBalok(persegiPanjangRequest);
        persegiPanjangResponse.setPanjang(responseSesiSvc.getPanjang());
        persegiPanjangResponse.setLebar(responseSesiSvc.getLebar());
        persegiPanjangResponse.setTinggi(responseSesiSvc.getTinggi());
        persegiPanjangResponse.setHasil(responseSesiSvc.getHasil());
        // validasi request
        PersegiPanjangResponse siPalingValid = requestValidService.siPalingValid(persegiPanjangRequest);
        siPalingValid.setPanjang(persegiPanjangRequest.getPanjang());
        siPalingValid.setLebar(persegiPanjangRequest.getLebar());
        siPalingValid.setTinggi(persegiPanjangRequest.getTinggi());
//        if(siPalingValid!=null){
        if(siPalingValid.getRetrunCode()==false){
            ErrorCodeResponse errorCodeResponse = new ErrorCodeResponse();
            errorCodeResponse.setResponseCode(siPalingValid.getResponseCode());
            errorCodeResponse.setResponseMessage(siPalingValid.getResponseMessage());
            return new ResponseEntity<>(siPalingValid,siPalingValid.getCode());
        }
        log.info("isi response [ "+siPalingValid+" ]");
        persegiPanjangResponse.setResponseCode(200);
        persegiPanjangResponse.setResponseMessage("sukses");
        return new ResponseEntity<>(persegiPanjangResponse, HttpStatus.OK);
    }
}
