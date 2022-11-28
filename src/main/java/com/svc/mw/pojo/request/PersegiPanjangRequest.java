package com.svc.mw.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersegiPanjangRequest {
    private int panjang;
    private int lebar;
    private int tinggi;
}
