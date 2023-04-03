package com.ahmet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    BRAND_EXIST(2003,"Marka zaten mevcut", HttpStatus.NOT_FOUND),
    COLOR_EXIST(2003,"Renk zaten mevcut", HttpStatus.NOT_FOUND),
    COMPANY_EXIST(2003,"Şirket zaten mevcut", HttpStatus.NOT_FOUND),
    BRAND_NOT_FOUND_LIST(2003,"Marka Bulunamadı", HttpStatus.BAD_REQUEST),
    CAR_NOT_FOUND(2004,"Araç  bulunamadı", HttpStatus.NOT_FOUND),
    BAD_REQUEST(4000,"Geçersiz istek ya da parametre", HttpStatus.BAD_REQUEST),
    ERROR(9000, "Beklenmeyen bir hata oluştur. Lütfen tekrar deneyiniz.", HttpStatus.INTERNAL_SERVER_ERROR)  ;

    int code;
    String message;
    HttpStatus httpStatus;

}
