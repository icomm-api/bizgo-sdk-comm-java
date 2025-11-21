package net.bizgo.client.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmniResponse {

    private String code;
    private String result;
    private OmniResponseData data;
    private String ref;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public OmniResponseData getData() { return data; }
    public void setData(OmniResponseData data) { this.data = data; }

    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }

    @Override
    public String toString() {
        return "OmniResponse{" +
                "code='" + code + '\'' +
                ", result='" + result + '\'' +
                ", ref='" + ref + '\'' +
                ", data=" + data +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OmniResponseData {

        // 메시지 접수 응답
        private List<DestinationResponse> destinations;

        // 파일 응답
        private String fileKey;
        private String media;
        private String expired;
        private String imgUrl;

        // 리포트 응답
        private String reportId;
        private List<ReportData> report;

        // 인사이트 응답
        private List<StatisticsData> statistics;
        private List<MessageData> message;



        public List<DestinationResponse> getDestinations() { return destinations; }
        public void setDestinations(List<DestinationResponse> destinations) { this.destinations = destinations; }

        public String getFileKey() { return fileKey; }
        public void setFileKey(String fileKey) { this.fileKey = fileKey; }

        public String getMedia() { return media; }
        public void setMedia(String media) { this.media = media; }

        public String getExpired() { return expired; }
        public void setExpired(String expired) { this.expired = expired; }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getReportId() { return reportId; }
        public void setReportId(String reportId) { this.reportId = reportId; }

        public List<ReportData> getReport() { return report; }
        public void setReport(List<ReportData> report) { this.report = report; }

        public List<StatisticsData> getStatistics() {
            return statistics;
        }

        public void setStatistics(List<StatisticsData> statistics) {
            this.statistics = statistics;
        }

        public List<MessageData> getMessage() {
            return message;
        }

        public void setMessage(List<MessageData> message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "OmniResponseData{" +
                    "destinations=" + destinations +
                    ", fileKey='" + fileKey + '\'' +
                    ", media='" + media + '\'' +
                    ", expired='" + expired + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", reportId='" + reportId + '\'' +
                    ", report=" + report +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReportData {

        public ReportData() {}

        String msgKey;
        String ServiceType;
        String msgType;
        String reportType;
        String reportCode;
        String reportText;
        String reportTime;
        String carrier;
        String res;
        String ref;

        public String getMsgKey() {
            return msgKey;
        }
        public void setMsgKey(String msgKey) {
            this.msgKey = msgKey;
        }
        public String getServiceType() {
            return ServiceType;
        }
        public void setServiceType(String serviceType) {
            ServiceType = serviceType;
        }
        public String getMsgType() {
            return msgType;
        }
        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }
        public String getReportType() {
            return reportType;
        }
        public void setReportType(String reportType) {
            this.reportType = reportType;
        }
        public String getReportCode() {
            return reportCode;
        }
        public void setReportCode(String reportCode) {
            this.reportCode = reportCode;
        }
        public String getReportText() {
            return reportText;
        }
        public void setReportText(String reportText) {
            this.reportText = reportText;
        }
        public String getReportTime() {
            return reportTime;
        }
        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }
        public String getCarrier() {
            return carrier;
        }
        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }
        public String getRes() {
            return res;
        }
        public void setRes(String res) {
            this.res = res;
        }
        public String getRef() {
            return ref;
        }
        public void setRef(String ref) {
            this.ref = ref;
        }

        @Override
        public String toString() {

            return "msgKey='" + msgKey + "\'" +
                    ", ServiceType='" + ServiceType + "\'" +
                    ", msgType='" + msgType + "\'" +
                    ", reportType='" + reportType + "\'" +
                    ", reportCode='" + reportCode + "\'" +
                    ", reportText='" + reportText + "\'" +
                    ", reportTime='" + reportTime + "\'" +
                    ", carrier='" + carrier + "\'" +
                    ", res='" + res + "\'" +
                    ", ref='" + ref + "\'";
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DestinationResponse {
        private String to;
        private String msgKey;
        private String code;
        private String result;

        public String getTo() { return to; }
        public void setTo(String to) { this.to = to; }

        public String getMsgKey() { return msgKey; }
        public void setMsgKey(String msgKey) { this.msgKey = msgKey; }

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }

        public String getResult() { return result; }
        public void setResult(String result) { this.result = result; }

        @Override
        public String toString() {
            return "DestinationResponse{" +
                    "to='" + to + '\'' +
                    ", msgKey='" + msgKey + '\'' +
                    ", code='" + code + '\'' +
                    ", result='" + result + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MessageData {
        private List<MessageHistory> messages;

        @JsonProperty("messages")
        public List<MessageHistory> getMessages() {
            return messages;
        }

        public void setMessages(List<MessageHistory> messages) {
            this.messages = messages;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MessageHistory {
        private String msgKey;
        private String serviceType;
        private String msgType;
        private String to;
        private String fallback;
        private String responseCode;
        private String responseText;
        private String requestTime;
        private String sendTime;
        private String reportTime;
        private String reportType;
        private String reportCode;
        private String reportText;
        private String carrier;
        private String userType;
        private String ref;

        @JsonProperty("msgKey")
        public String getMsgKey() {
            return msgKey;
        }

        public void setMsgKey(String msgKey) {
            this.msgKey = msgKey;
        }

        @JsonProperty("serviceType")
        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        @JsonProperty("msgType")
        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        @JsonProperty("to")
        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        @JsonProperty("fallback")
        public String getFallback() {
            return fallback;
        }

        public void setFallback(String fallback) {
            this.fallback = fallback;
        }

        @JsonProperty("responseCode")
        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        @JsonProperty("responseText")
        public String getResponseText() {
            return responseText;
        }

        public void setResponseText(String responseText) {
            this.responseText = responseText;
        }

        @JsonProperty("requestTime")
        public String getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(String requestTime) {
            this.requestTime = requestTime;
        }

        @JsonProperty("sendTime")
        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        @JsonProperty("reportTime")
        public String getReportTime() {
            return reportTime;
        }

        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }

        @JsonProperty("reportType")
        public String getReportType() {
            return reportType;
        }

        public void setReportType(String reportType) {
            this.reportType = reportType;
        }

        @JsonProperty("reportCode")
        public String getReportCode() {
            return reportCode;
        }

        public void setReportCode(String reportCode) {
            this.reportCode = reportCode;
        }

        @JsonProperty("reportText")
        public String getReportText() {
            return reportText;
        }

        public void setReportText(String reportText) {
            this.reportText = reportText;
        }

        @JsonProperty("carrier")
        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        @JsonProperty("userType")
        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        @JsonProperty("ref")
        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StatisticsData {
        private List<Statistics> statistics;

        @JsonProperty("statistics")
        public List<Statistics> getStatistics() {
            return statistics;
        }

        public void setStatistics(List<Statistics> statistics) {
            this.statistics = statistics;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Statistics {
        private String statDate;
        private Integer recvTotalCnt;
        private Integer recvSuccCnt;
        private Integer recvFailCnt;
        private Integer reportTotalCnt;
        private Integer reportSuccCnt;
        private Integer reportFailCnt;

        @JsonProperty("statDate")
        public String getStatDate() {
            return statDate;
        }

        public void setStatDate(String statDate) {
            this.statDate = statDate;
        }

        @JsonProperty("recvTotalCnt")
        public Integer getRecvTotalCnt() {
            return recvTotalCnt;
        }

        public void setRecvTotalCnt(Integer recvTotalCnt) {
            this.recvTotalCnt = recvTotalCnt;
        }

        @JsonProperty("recvSuccCnt")
        public Integer getRecvSuccCnt() {
            return recvSuccCnt;
        }

        public void setRecvSuccCnt(Integer recvSuccCnt) {
            this.recvSuccCnt = recvSuccCnt;
        }

        @JsonProperty("recvFailCnt")
        public Integer getRecvFailCnt() {
            return recvFailCnt;
        }

        public void setRecvFailCnt(Integer recvFailCnt) {
            this.recvFailCnt = recvFailCnt;
        }

        @JsonProperty("reportTotalCnt")
        public Integer getReportTotalCnt() {
            return reportTotalCnt;
        }

        public void setReportTotalCnt(Integer reportTotalCnt) {
            this.reportTotalCnt = reportTotalCnt;
        }

        @JsonProperty("reportSuccCnt")
        public Integer getReportSuccCnt() {
            return reportSuccCnt;
        }

        public void setReportSuccCnt(Integer reportSuccCnt) {
            this.reportSuccCnt = reportSuccCnt;
        }

        @JsonProperty("reportFailCnt")
        public Integer getReportFailCnt() {
            return reportFailCnt;
        }

        public void setReportFailCnt(Integer reportFailCnt) {
            this.reportFailCnt = reportFailCnt;
        }
    }
}
