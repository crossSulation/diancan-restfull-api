package com.diancan.service.resto.utils;

import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;

public interface ImageMetadataService {

    /**
     *  获取图片的所有的Metadata
     * @param file
     * @return
     */
    public HashMap<String,HashMap<String,Tag>> getAllMetadatasFromImageFile(MultipartFile file) throws Exception;

    /**
     * 反转图片
     * @param imageFile
     */
    public  void transformOritentionOfImageFile(MultipartFile imageFile) throws Exception;

    /**
     * 得到图片文件的base Exif 信息
     * @param imageFile
     * @return
     */
    public HashMap<String,Tag> getExifBaseMetadatasFromImageFile(MultipartFile imageFile) throws Exception;

    public HashMap<String,Tag> getExifThunbnaiInfoFromImageFile(MultipartFile imageFile) throws Exception;

    public HashMap<String,Tag> getExifIFD0InfoFromImageFile(MultipartFile imageFile) throws Exception;

    public  HashMap<String,Tag> getExifSubIFDInfoFromImageFile(MultipartFile imageFile) throws Exception;
    /**
     * 缩放图片
     * @param imageFile
     * @return
     */
    public File  scaleImageFile(MultipartFile imageFile,float sacle) throws Exception;


    public boolean isJpegImageFile(MultipartFile file);

    public boolean isPngImageFile(MultipartFile file);
}
