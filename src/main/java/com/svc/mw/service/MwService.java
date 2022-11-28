package com.svc.mw.service;

import com.svc.mw.pojo.request.PersegiPanjangRequest;
import com.svc.mw.pojo.response.PersegiPanjangResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface MwService {
    public ResponseEntity<?>getVolumeBalok(PersegiPanjangRequest persegiPanjangRequest, HttpServletRequest httpServletRequest);
    public ResponseEntity<?>getLuasBalok(PersegiPanjangRequest persegiPanjangRequest);
    public ResponseEntity<?>getKelilingBalok(PersegiPanjangRequest persegiPanjangRequest);
}
