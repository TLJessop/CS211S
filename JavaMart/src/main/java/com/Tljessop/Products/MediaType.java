package com.Tljessop.Products;

public enum  MediaType {
    DOWNLOADABLE("DL"), COMPACT_DISK("CD"), DIGITAL_VIDEO_DISK("DVD"),
    PRELOADED_DRIVE("PD"), BLUERAY_DISK("BD"), CUSTOM_FORMAT_DISK("CFD");

    private String mediaCode;

    private MediaType(String mediaCode){
        this.mediaCode = mediaCode;
    }

    public String getMediaCode() {
        return mediaCode;
    }
}
