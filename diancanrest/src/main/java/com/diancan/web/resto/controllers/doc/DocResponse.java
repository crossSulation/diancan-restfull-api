package com.diancan.web.resto.controllers.doc;

import java.util.Date;

public class DocResponse {

    private int status;

    private String message;

    private String fileName;
    private Long fileSize;
    private String fileType;
    private Date fileCreated;
    private String fileModifiedBy;
    private String fileId;

    public DocResponse() {
    }

    public DocResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getFileCreated() {
        return fileCreated;
    }

    public void setFileCreated(Date fileCreated) {
        this.fileCreated = fileCreated;
    }

    public String getFileModifiedBy() {
        return fileModifiedBy;
    }

    public void setFileModifiedBy(String fileModifiedBy) {
        this.fileModifiedBy = fileModifiedBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
