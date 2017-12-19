package com.diancan.domain.resto.constants;

//饮料口味
public enum DrinkTeste {
    SOFT(1,"soft"),
    HARD(2,"hard");
    private  final Integer value;
    private  final String desc;
    DrinkTeste(Integer value ,String desc) {
        this.value =value;
        this.desc =desc;
    }

    public  int value() {
        return  this.value;
    }

    public static DrinkTeste valueOf(int code) {
        DrinkTeste[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            DrinkTeste status = var1[var3];
            if (status.value == code) {
                return status;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
