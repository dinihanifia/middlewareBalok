package com.svc.mw.config.Enum;

import java.util.Arrays;
import java.util.List;

public class SegiConstant {
    public static final String MESSAGE_CHECK_REQUEST = "Invalid Request ";
    public static final String PANJANG = "Panjang";
    public static final String LEBAR  = "Lebar";
    public static final String TINGGI = "Tinggi";

    public static final String EMPTY_PANJANG = "Panjangnya Kosong";
    public static final String EMPTY_LEBAR = "Lebarnya Kosong";
    public static final String EMPTY_TINGGI = "Tingginya Kosong";

    public static final List<String> SEGI_PANJANG            = Arrays.asList(PANJANG,">");
    public static final List<String> SEGI_LEBAR              = Arrays.asList(LEBAR,">");
    public static final List<String> SEGI_TINGGI             = Arrays.asList(TINGGI,">");
}
