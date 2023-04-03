package com.ahmet.constants;

public class EndPointList {
    public static final String PREF = "/dev";
    public static final String VERSIONS = "/v1";
    public static final String CAR = PREF+VERSIONS+"/car";
    public static final String BRAND = PREF+VERSIONS+"/brand";
    public static final String COLOR = PREF+VERSIONS+"/color";
    public static final String CUSTOMER = PREF+VERSIONS+"/customer";
    public static final String RENTAL = "/rental";
    public static final String SAVE = "/save";
    public static final String FIND_ALL = "/findall";
    public static final String FIND_ALL_BY_CAR_WITH_COLOR_ID = "/findallbycarwithcolorid";
    public static final String FIND_BY_CARNAME = "/findbycarname";
    public static final String FIND_BY_CAR_WITH_BRAND_ID = "/findbycarwithbrandid";
    public static final String FIND_ALL_BY_DAILY_PRICE_LESS_THAN_EQUAL = "/findallbydailypricelessthanequal";
    public static final String FIND_CAR_COLOR_BRAND = "/findCarColorBrand";
    public static final String FIND_CAR_AND_DAILY_PRICE = "/findCarAndDailyPrice";
    public static final String RENTAL_DATE_CAR_NAME_BRAN_COMPANY_NAME = "/rentaldatecarnamebrandcompanyname";
}
