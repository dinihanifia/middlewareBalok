package com.svc.mw.controller;

import com.svc.mw.pojo.request.PersegiPanjangRequest;
import com.svc.mw.pojo.response.PersegiPanjangResponse;
import com.svc.mw.service.MwService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private MwService mwService;

    @PostMapping("/volume-balok")
    public ResponseEntity<?> getVolumeBalok(@RequestBody PersegiPanjangRequest persegiPanjangRequest,HttpServletRequest httpServletRequest){
        return mwService.getVolumeBalok(persegiPanjangRequest,httpServletRequest);
    }

    @PostMapping("/luas-balok")
    public ResponseEntity<?> getLuasBalok(@RequestBody PersegiPanjangRequest persegiPanjangRequest){
        return mwService.getLuasBalok(persegiPanjangRequest);
    }
    @PostMapping("/keliling-balok")
    public ResponseEntity<?> getKelilingBalok(@RequestBody PersegiPanjangRequest persegiPanjangRequest){
        return mwService.getKelilingBalok(persegiPanjangRequest);
    }
}
