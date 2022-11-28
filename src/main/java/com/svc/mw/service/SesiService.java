package com.svc.mw.service;

import com.svc.mw.config.OpenFeignConfig;
import com.svc.mw.pojo.request.PersegiPanjangRequest;
import com.svc.mw.pojo.response.BalokResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${app.svc-sesi.name}", url = "${app.svc-sesi.url}", configuration = OpenFeignConfig.class)
public interface SesiService {
    @RequestMapping(method = RequestMethod.POST, value = "/volume-balok")
    public BalokResponse getVolumeBalok(@RequestBody PersegiPanjangRequest persegiPanjangRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/luas-balok")
    public BalokResponse getLuasBalok(@RequestBody PersegiPanjangRequest persegiPanjangRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/keliling-balok")
    public BalokResponse getKelilingBalok(PersegiPanjangRequest persegiPanjangRequest);
}
