package com.diancan.domain.resto.constants;

import antlr.StringUtils;

public enum DrinkCategory {

    COCO(1,"coco"),
    ALCOHOLIC(2,"alcoholic"),
    NON_ALCOHOLIC(3,"no_alcoholic");

    private  final Integer value;
    private  final String desc;
    DrinkCategory(Integer value ,String desc) {
        this.value =value;
        this.desc =desc;
    }

    public  int value() {
        return  this.value;
    }

    public static DrinkCategory valueOf(int code) {
        DrinkCategory[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            DrinkCategory status = var1[var3];
            if (status.value == code) {
                return status;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
