package com.diancan.service.resto.utils;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.*;
import org.springframework.ejb.config.JeeNamespaceHandler;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.persistence.Table;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ImageMetadataServiceImpl implements ImageMetadataService {

    @Override
    public HashMap<String, HashMap<String, Tag>> getAllMetadatasFromImageFile(MultipartFile file) throws Exception {
        Metadata metadata = JpegMetadataReader.readMetadata(file.getInputStream());

        HashMap<String,HashMap<String,Tag>> metadatas = new HashMap<>();
        for(Directory directory: metadata.getDirectories()) {
            HashMap<String,Tag> tmp = new HashMap<>();
            for(Tag tag : directory.getTags()) {
                tmp.put(directory.getName(),tag);
            }
        }
        return metadatas;
    }

    @Override
    public void transformOritentionOfImageFile(MultipartFile imageFile) throws Exception {
        Metadata metadata = JpegMetadataReader.readMetadata(imageFile.getInputStream());
        Directory exifDirectory = (ExifDirectoryBase)metadata.getFirstDirectoryOfType(ExifDirectoryBase.class);
        int orientation =1;
        orientation = exifDirectory.getInt(ExifDirectoryBase.TAG_ORIENTATION);

        if(orientation ==1) {
            return;
        }
        // 都是cw (顺时针方向)
        int degree =0;
        switch (orientation) {
            case 3:
                degree =180;
                break;
            case 6:
                degree =90;
                break;
            case 8:
                degree=270;
                break;
        }
        BufferedImage  src = ImageIO.read(imageFile.getInputStream());
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);

        // calculate the new image size
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(
                src_width, src_height)), degree);

        BufferedImage res = null;
        res = new BufferedImage(rect_des.width, rect_des.height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = res.createGraphics();
        // transform
        g2.translate((rect_des.width - src_width) / 2,
                (rect_des.height - src_height) / 2);
        g2.rotate(Math.toRadians(degree), src_width / 2, src_height / 2);

        g2.drawImage(src, null, null);

    }

    private  Rectangle CalcRotatedSize(Rectangle src, int angel) {
        // if angel is greater than 90 degree, we need to do some conversion
        if (angel >= 90) {
            if(angel / 90 % 2 == 1){
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }

        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new Rectangle(new Dimension(des_width, des_height));
    }
    @Override
    public HashMap<String, Tag> getExifBaseMetadatasFromImageFile(MultipartFile imageFile) throws Exception {
         HashMap<String,Tag> exifbaseinfo = new HashMap<>();
         Metadata metadata = JpegMetadataReader.readMetadata(imageFile.getInputStream());
         Directory exifDirectory = (ExifDirectoryBase)metadata.getFirstDirectoryOfType(ExifDirectoryBase.class);
         for(Tag tag:exifDirectory.getTags()) {
             exifbaseinfo.put(tag.getTagName(),tag);
         }
        return exifbaseinfo;
    }

    @Override
    public HashMap<String, Tag> getExifThunbnaiInfoFromImageFile(MultipartFile imageFile) throws Exception {

        HashMap<String,Tag> exifThunbnailInfo = new HashMap<>();
        Metadata metadata = JpegMetadataReader.readMetadata(imageFile.getInputStream());
        Directory exifThunbnailDirectory = (ExifThumbnailDirectory) metadata.getFirstDirectoryOfType(ExifThumbnailDirectory.class);
        for(Tag tag: exifThunbnailDirectory.getTags()) {
            exifThunbnailInfo.put(tag.getTagName(),tag);
        }
        return exifThunbnailInfo;
    }

    @Override
    public HashMap<String, Tag> getExifIFD0InfoFromImageFile(MultipartFile imageFile) throws Exception {
        HashMap<String,Tag> exifIFD0Info = new HashMap<>();
        Metadata metadata =JpegMetadataReader.readMetadata(imageFile.getInputStream());
        Directory exifIFD0Directory = (ExifIFD0Directory)metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        for(Tag tag: exifIFD0Directory.getTags()) {
            exifIFD0Info.put(tag.getTagName(), tag);
        }
        return exifIFD0Info;
    }

    @Override
    public HashMap<String, Tag> getExifSubIFDInfoFromImageFile(MultipartFile imageFile) throws Exception {
        HashMap<String,Tag> exifSubIFDInfo = new HashMap<>();
        Metadata metadata = JpegMetadataReader.readMetadata(imageFile.getInputStream());
        Directory exifSubIFDDirectory = (ExifSubIFDDirectory)metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        for(Tag tag: exifSubIFDDirectory.getTags()) {
            exifSubIFDInfo.put(tag.getTagName(),tag);
        }
        return exifSubIFDInfo;
    }

    @Override
    public File scaleImageFile(MultipartFile imageFile,float scale) {
        return null;
    }

    @Override
    public boolean isJpegImageFile(MultipartFile file) {
        String fileType = file.getContentType();
        if(fileType=="jpeg" || fileType =="jpg") {
            return  true;
        }
        return false;
    }

    @Override
    public boolean isPngImageFile(MultipartFile file) {
        String fileType =file.getContentType();
        if(fileType=="png") {
            return  true;
        }
        return false;
    }
}
