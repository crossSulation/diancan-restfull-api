package com.diancan.domain.resto.mongo;

import org.apache.tomcat.util.buf.ByteChunk;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fs.files")
public class ImageFile {

    @Id
    private ObjectId id;

    private String fileName;

    private String contentType;

    private Long size;

    private ByteChunk[] contents;

    private String path;

    private String uploadDate;

    private String modifiedBy;

    public ImageFile() {
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public ByteChunk[] getContents() {
        return contents;
    }

    public void setContents(ByteChunk[] contents) {
        this.contents = contents;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        StringBuffer sbstr =new StringBuffer();
        sbstr.append("{");
        sbstr.append("id:"+this.id);
        sbstr.append("filename:"+this.fileName);
        sbstr.append("contentType:"+this.getContentType());
        sbstr.append("size:"+this.size);
        sbstr.append("path:"+this.path);
        sbstr.append("upload:"+this.uploadDate);
        sbstr.append("modified:"+this.modifiedBy);
        sbstr.append("}");
        return  sbstr.toString();
    }
}
