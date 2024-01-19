package com.example.kvnmapp.ebook;
public class EbookData {
    private String bcpPdfTitle;
    private String cbpPdfTitle;
    private String nccPdfTitle;
    private String jnmpPdfTitle;
    private String drbPdfTitle;
    private String pdfUrl;
    public EbookData(String bcpPdfTitle, String cbpPdfTitle, String nccPdfTitle, String jnmpPdfTitle, String drbPdfTitle,String pdfUrl) {
        this.bcpPdfTitle = bcpPdfTitle;
        this.cbpPdfTitle = cbpPdfTitle;
        this.nccPdfTitle = nccPdfTitle;
        this.jnmpPdfTitle = jnmpPdfTitle;
        this.drbPdfTitle = drbPdfTitle;
        this.pdfUrl = pdfUrl;
    }
    public String getBcpPdfTitle() {
        return bcpPdfTitle;
    }
    public void setBcpPdfTitle(String bcpPdfTitle) {
        this.bcpPdfTitle = bcpPdfTitle;
    }
    public String getCbpPdfTitle() {
        return cbpPdfTitle;
    }
    public void setCbpPdfTitle(String cbpPdfTitle) {
        this.cbpPdfTitle = cbpPdfTitle;
    }
    public String getNccPdfTitle() {
        return nccPdfTitle;
    }
    public void setNccPdfTitle(String nccPdfTitle) {
        this.nccPdfTitle = nccPdfTitle;
    }
    public String getJnmpPdfTitle() {
        return jnmpPdfTitle;
    }
    public void setJnmpPdfTitle(String jnmpPdfTitle) {
        this.jnmpPdfTitle = jnmpPdfTitle;
    }
    public String getDrbPdfTitle() {
        return drbPdfTitle;
    }
    public void setDrbPdfTitle(String drbPdfTitle) {
        this.drbPdfTitle = drbPdfTitle;
    }
    public EbookData() {
    }
    public String getPdfUrl() {
        return pdfUrl;
    }
    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}