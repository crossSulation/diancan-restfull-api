package com.diancan.domain.resto.mongo;

import com.mongodb.DBObject;
import org.apache.tomcat.util.buf.ByteChunk;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.text.html.HTMLDocument;

@Document(collection = "fs.files")
public class DocFile {

    @Id
    private String id;

    private String fileName;

    private String contentType;

    private Long size;

    private byte[] data;

    private String path;

    private Long uploadDate;

    private String modifiedBy;

    private DBObject metaData;

    public DocFile() {
    }

    public DBObject getMetaData() {
        return metaData;
    }

    public void setMetaData(DBObject metaData) {
        this.metaData = metaData;
    }

    public String   getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Long uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] contents) {
        this.data = contents;
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
