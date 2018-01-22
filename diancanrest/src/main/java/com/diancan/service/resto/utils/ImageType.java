package com.diancan.service.resto.utils;

public enum ImageType {

    JEPG(1,"jpeg"),
    BMP(2,"bmp"),
    SVG(3,"svg"),
    PCX(4,"pcx"),
    PSD(5,"psd"),
    HDRI(6,"hdri"),
    TIFF(7,"tiff"),
    CDR(8,"cdr"),
    RAW(9,"raw"),
    GIF(10,"gif"),
    PCD(11,"pcd"),
    WMF(12,"wmf"),
    DXF(13,"dxf"),
    LIC(14,"lic"),
    TGA(15,"tga"),
    UFO(16,"ufo"),
    EMF(17,"emf"),
    EXIF(18,"exif"),
    EPS(19,"EPS"),
    FPX(20,"fpx"),
    AI(21,"ai"),
    JPG(22,"jpg"),
    PNG(23,"png");

    private int value;

    private String desc;

    ImageType(int value,String desc) {
      this.value =value;
      this.desc =desc;
    }

    public int value() {
        return  this.value;
    }

    public static ImageType valueOf(int code) {
        ImageType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ImageType status = var1[var3];
            if (status.value == code) {
                return status;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

}
