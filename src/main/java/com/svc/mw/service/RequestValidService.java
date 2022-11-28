package com.svc.mw.service;

import com.svc.mw.pojo.request.PersegiPanjangRequest;
import com.svc.mw.pojo.response.PersegiPanjangResponse;

public interface RequestValidService {
    public PersegiPanjangResponse siPalingValid(PersegiPanjangRequest persegiPanjangRequest);
}
