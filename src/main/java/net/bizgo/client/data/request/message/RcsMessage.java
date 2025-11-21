package net.bizgo.client.data.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bizgo.client.core.exception.MissingFieldException;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class RcsMessage{

    final RcsData rcs;

    @JsonProperty("rcs")
    public RcsData getRcs() {
        return rcs;
    }

    RcsMessage(Builder builder) {
        rcs = new RcsData(builder);        
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private class RcsData {

        private String from;
        private Object body;
        private Object buttons;
        private String formatId;
        private String brandKey;
        private String brandId;
        private String groupId;
        private String expiryOption;
        private String copyAllowed;
        private String header;
        private String footer;
        private String agencyId;
        private String agencyKey;
        private String ttl;

        RcsData(Builder b) {
            this.body = b.body;
            this.from = b.from;
            this.formatId = b.formatId;
            this.brandKey = b.brandKey;
            this.brandId = b.brandId;
            this.groupId = b.groupId;
            this.expiryOption = b.expiryOption;
            this.copyAllowed = b.copyAllowed;
            this.header = b.header;
            this.footer = b.footer;
            this.agencyId = b.agencyId;
            this.agencyKey = b.agencyKey;
            this.ttl = b.ttl;
        }


        @JsonProperty("from")
        public String getFrom() { return from; }

        @JsonProperty("body")
        public Object getBody() { return body; }

        @JsonProperty("formatId")
        public String getFormatId() { return formatId; }

        @JsonProperty("brandKey")
        public String getBrandKey() { return brandKey; }

        @JsonProperty("brandId")
        public String getBrandId() { return brandId; }

        @JsonProperty("groupId")
        public String getGroupId() { return groupId; }

        @JsonProperty("expiryOption")
        public String getExpiryOption() { return expiryOption; }

        @JsonProperty("copyAllowed")
        public String getCopyAllowed() { return copyAllowed; }

        @JsonProperty("header")
        public String getHeader() { return header; }

        @JsonProperty("footer")
        public String getFooter() { return footer; }

        @JsonProperty("agencyId")
        public String getAgencyId() { return agencyId; }

        @JsonProperty("agencyKey")
        public String getAgencyKey() { return agencyKey; }

        @JsonProperty("ttl")
        public String getTtl() { return ttl; }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String from;
        private Object body;
        private Object suggestions;
        private Object buttons;

        private String formatId;
        private String brandKey;
        private String brandId;
        private String groupId;
        private String expiryOption;
        private String copyAllowed;
        private String header;
        private String footer;
        private String agencyId;
        private String agencyKey;
        private String ttl;

        //===== JSON Object 입력 필드 =====
        public Builder body(Object body) {
            this.body = body;
            return this;
        }

        public Builder suggestions(Object suggestions) {
            this.suggestions = suggestions;
            return this;
        }

        public Builder buttons(Object buttons) {
            this.buttons = buttons;
            return this;
        }

        //===== 일반 필드 =====

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder formatId(String formatId) {
            this.formatId = formatId;
            return this;
        }

        public Builder brandKey(String brandKey) {
            this.brandKey = brandKey;
            return this;
        }

        public Builder brandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder expiryOption(String expiryOption) {
            this.expiryOption = expiryOption;
            return this;
        }

        public Builder copyAllowed(String copyAllowed) {
            this.copyAllowed = copyAllowed;
            return this;
        }

        public Builder header(String header) {
            this.header = header;
            return this;
        }

        public Builder footer(String footer) {
            this.footer = footer;
            return this;
        }

        public Builder agencyId(String agencyId) {
            this.agencyId = agencyId;
            return this;
        }

        public Builder agencyKey(String agencyKey) {
            this.agencyKey = agencyKey;
            return this;
        }

        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        public RcsMessage build() {

            if (from == null)
                throw new MissingFieldException("from must not be null");

            if (formatId == null)
                throw new MissingFieldException("formatId must not be null");

            if (brandKey == null)
                throw new MissingFieldException("brandKey must not be null");

            if (body == null)
                throw new MissingFieldException("body must not be null");

            return new RcsMessage(this);
        }
    }

}