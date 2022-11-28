package com.svc.mw.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalokResponse {
    private int panjang;
    private int lebar;
    private int tinggi;
    private int hasil;
}
