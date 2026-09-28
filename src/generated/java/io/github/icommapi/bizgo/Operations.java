// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import java.util.List;

/** Every operation of the spec with its {@code x-sdk-*} metadata. */
final class Operations {

    static final Operation SEND_OMNI = new Operation("sendOmni", "send", "omni",
            "POST", "/api/comm/v1/send/omni",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.SEND, null, "data.data");
    static final Operation UPLOAD_MMS_FILE = new Operation("uploadMmsFile", "files", "uploadMms",
            "POST", "/api/comm/v1/file/mms",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_RCS_FILE = new Operation("uploadRcsFile", "files", "uploadRcs",
            "POST", "/api/comm/v1/file/rcs",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_DEFAULT_IMAGE = new Operation("uploadBrandMessageDefaultImage", "files", "uploadBrandMessageDefault",
            "POST", "/api/comm/v1/file/brandmessage/default",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_WIDE_IMAGE = new Operation("uploadBrandMessageWideImage", "files", "uploadBrandMessageWide",
            "POST", "/api/comm/v1/file/brandmessage/wide",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_FIRST_IMAGE = new Operation("uploadBrandMessageWideItemListFirstImage", "files", "uploadBrandMessageWideItemListFirst",
            "POST", "/api/comm/v1/file/brandmessage/wideItemList/first",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_IMAGE = new Operation("uploadBrandMessageWideItemListImage", "files", "uploadBrandMessageWideItemList",
            "POST", "/api/comm/v1/file/brandmessage/wideItemList",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_CAROUSEL_FEED_IMAGE = new Operation("uploadBrandMessageCarouselFeedImage", "files", "uploadBrandMessageCarouselFeed",
            "POST", "/api/comm/v1/file/brandmessage/carouselFeed",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_CAROUSEL_COMMERCE_IMAGE = new Operation("uploadBrandMessageCarouselCommerceImage", "files", "uploadBrandMessageCarouselCommerce",
            "POST", "/api/comm/v1/file/brandmessage/carouselCommerce",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_REPORT_POLLING = new Operation("getReportPolling", "reports", "poll",
            "GET", "/api/comm/v1/report/polling",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation ACK_REPORT_POLLING = new Operation("ackReportPolling", "reports", "ack",
            "DELETE", "/api/comm/v1/report/polling/{reportId}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_REPORT_INQUIRY = new Operation("getReportInquiry", "reports", "inquiry",
            "GET", "/api/comm/v1/report/inquiry/{msgKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_MESSAGE_STATISTICS = new Operation("getMessageStatistics", "messages", "statistics",
            "GET", "/api/comm/v1/message/statistics",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_MESSAGE_HISTORY = new Operation("getMessageHistory", "messages", "history",
            "GET", "/api/comm/v1/message/history",
            Retry.SAFE, Operation.RateBucket.OTHER, "cursor", "data.data");
    static final Operation GET_MO_HISTORY = new Operation("getMoHistory", "messages", "moHistory",
            "GET", "/api/comm/v1/message/history/mo",
            Retry.SAFE, Operation.RateBucket.OTHER, "cursor", "data.data");
    static final Operation GET_MESSAGE_STATUS_BY_MSG_KEY = new Operation("getMessageStatusByMsgKey", "messages", "status",
            "GET", "/api/comm/v1/message/inquiry/msgKey/{msgKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_MESSAGE_STATUS_BY_REQUEST_ID = new Operation("getMessageStatusByRequestId", "messages", "statusByRequestId",
            "GET", "/api/comm/v1/message/inquiry/requestId/{requestId}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_MO_BY_MSG_KEY = new Operation("getMoByMsgKey", "messages", "mo",
            "GET", "/api/comm/v1/message/inquiry/mo/msgKey/{msgKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CREATE_RESERVATION = new Operation("createReservation", "reservations", "create",
            "POST", "/api/comm/v1/reservation",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.SEND, null, "data");
    static final Operation LIST_RESERVATIONS = new Operation("listReservations", "reservations", "list",
            "GET", "/api/comm/v1/reservation/list",
            Retry.SAFE, Operation.RateBucket.OTHER, "cursor", "data.data");
    static final Operation GET_RESERVATION = new Operation("getReservation", "reservations", "get",
            "GET", "/api/comm/v1/reservation/resvKey/{resvKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPDATE_RESERVATION = new Operation("updateReservation", "reservations", "update",
            "PUT", "/api/comm/v1/reservation/resvKey/{resvKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CANCEL_RESERVATION = new Operation("cancelReservation", "reservations", "cancel",
            "POST", "/api/comm/v1/reservation/resvKey/{resvKey}/cancel",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation STOP_RESERVATION = new Operation("stopReservation", "reservations", "pause",
            "POST", "/api/comm/v1/reservation/resvKey/{resvKey}/stop",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation RESUME_RESERVATION = new Operation("resumeReservation", "reservations", "resume",
            "POST", "/api/comm/v1/reservation/resvKey/{resvKey}/resume",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation ADD_RESERVATION_RECIPIENTS = new Operation("addReservationRecipients", "reservations.recipients", "create",
            "POST", "/api/comm/v1/reservation/resvKey/{resvKey}/destinations",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.SEND, null, "data.data");
    static final Operation LIST_RESERVATION_RECIPIENTS = new Operation("listReservationRecipients", "reservations.recipients", "list",
            "GET", "/api/comm/v1/reservation/resvKey/{resvKey}/destinations",
            Retry.SAFE, Operation.RateBucket.OTHER, "cursor", "data.data");
    static final Operation DELETE_RESERVATION_RECIPIENT = new Operation("deleteReservationRecipient", "reservations.recipients", "delete",
            "DELETE", "/api/comm/v1/reservation/resvKey/{resvKey}/destinations/msgKey/{msgKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_ALIMTALK_INSIGHT = new Operation("getAlimtalkInsight", "insights.alimtalk", "get",
            "GET", "/api/comm/v1/center/statistics/alimtalk",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_ALIMTALK_HOURLY_INSIGHT = new Operation("getAlimtalkHourlyInsight", "insights.alimtalk", "getHourly",
            "GET", "/api/comm/v1/center/statistics/alimtalk/reaction/hourly",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_ALIMTALK_TEMPLATE_INSIGHT = new Operation("getAlimtalkTemplateInsight", "insights.alimtalk", "getByTemplate",
            "GET", "/api/comm/v1/center/statistics/alimtalk/template",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_INSIGHT = new Operation("getBrandMessageInsight", "insights.brandMessage", "get",
            "GET", "/api/comm/v1/center/statistics/brandmessage",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_HOURLY_INSIGHT = new Operation("getBrandMessageHourlyInsight", "insights.brandMessage", "getHourly",
            "GET", "/api/comm/v1/center/statistics/brandmessage/reaction/hourly",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_TEMPLATE_INSIGHT = new Operation("getBrandMessageTemplateInsight", "insights.brandMessage", "getByTemplate",
            "GET", "/api/comm/v1/center/statistics/brandmessage/template",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_RCS_MESSAGE_INSIGHT = new Operation("getRcsMessageInsight", "insights.rcs", "getMessage",
            "GET", "/api/comm/v1/center/rcs/brandId/{brandId}/stat/message",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.rcs");
    static final Operation GET_RCS_MESSAGE_BUTTON_INSIGHT = new Operation("getRcsMessageButtonInsight", "insights.rcs", "getMessageButton",
            "GET", "/api/comm/v1/center/rcs/brandId/{brandId}/stat/messageButton",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.rcs");
    static final Operation GET_RCS_PERSISTENT_MENU_INSIGHT = new Operation("getRcsPersistentMenuInsight", "insights.rcs", "getPersistentMenu",
            "GET", "/api/comm/v1/center/rcs/brandId/{brandId}/stat/persistentMenu",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.rcs");
    static final Operation GET_RCS_BRAND_PROFILE_INSIGHT = new Operation("getRcsBrandProfileInsight", "insights.rcs", "getBrandProfile",
            "GET", "/api/comm/v1/center/rcs/brandId/{brandId}/stat/brandProfile",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.rcs");
    static final Operation REQUEST_KAKAO_SENDER_TOKEN = new Operation("requestKakaoSenderToken", "kakao.senders", "requestToken",
            "POST", "/api/comm/v1/account/kakao/sender/token",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data");
    static final Operation CREATE_KAKAO_SENDER = new Operation("createKakaoSender", "kakao.senders", "create",
            "POST", "/api/comm/v1/account/kakao/sender",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.kakao.senderProfile");
    static final Operation FIND_KAKAO_SENDER = new Operation("findKakaoSender", "kakao.senders", "find",
            "GET", "/api/comm/v1/account/kakao/sender",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.kakao.senderProfile");
    static final Operation LIST_KAKAO_SENDER_PROFILES = new Operation("listKakaoSenderProfiles", "kakao.senders", "list",
            "GET", "/api/comm/v1/account/kakao/sender/profiles",
            Retry.SAFE, Operation.RateBucket.OTHER, "page", "data");
    static final Operation GET_KAKAO_SENDER = new Operation("getKakaoSender", "kakao.senders", "get",
            "GET", "/api/comm/v1/center/kakao/sender",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.kakao.senderProfile");
    static final Operation RECOVER_KAKAO_SENDER = new Operation("recoverKakaoSender", "kakao.senders", "recover",
            "POST", "/api/comm/v1/center/kakao/sender/recover",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_KAKAO_SENDER_CATEGORIES = new Operation("listKakaoSenderCategories", "kakao.categories", "list",
            "GET", "/api/comm/v1/center/kakao/sender/category/list",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.kakao.categories");
    static final Operation GET_KAKAO_SENDER_CATEGORY = new Operation("getKakaoSenderCategory", "kakao.categories", "get",
            "GET", "/api/comm/v1/center/kakao/sender/category",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.kakao.category");
    static final Operation LIST_KAKAO_GROUPS = new Operation("listKakaoGroups", "kakao.groups", "list",
            "GET", "/api/comm/v1/center/kakao/group",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.kakao.groups");
    static final Operation ADD_KAKAO_GROUP_SENDER = new Operation("addKakaoGroupSender", "kakao.groups", "addSender",
            "POST", "/api/comm/v1/center/kakao/group",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation REMOVE_KAKAO_GROUP_SENDER = new Operation("removeKakaoGroupSender", "kakao.groups", "removeSender",
            "DELETE", "/api/comm/v1/center/kakao/group/groupKey/{groupKey}/senderKey/{senderKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_KAKAO_SENDER_SANCTION = new Operation("getKakaoSenderSanction", "kakao.sanctions", "getSender",
            "GET", "/api/comm/v1/center/kakao/abusing/block/sender",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.kakao.abusing");
    static final Operation GET_KAKAO_GROUP_TEMPLATE_SENDER_EXCLUSION = new Operation("getKakaoGroupTemplateSenderExclusion", "kakao.sanctions", "getGroupTemplateExclusion",
            "GET", "/api/comm/v1/center/kakao/abusing/block/senderGroup",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.kakao.abusing");
    static final Operation GET_KAKAO_TEMPLATE_SANCTION = new Operation("getKakaoTemplateSanction", "kakao.sanctions", "getTemplate",
            "GET", "/api/comm/v1/center/kakao/abusing/block/template",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.kakao.abusing");
    static final Operation GET_ALIMTALK_TEMPLATE = new Operation("getAlimtalkTemplate", "alimtalk.templates", "get",
            "GET", "/api/comm/v1/center/alimtalk/template",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.alimtalk");
    static final Operation CREATE_ALIMTALK_TEMPLATE = new Operation("createAlimtalkTemplate", "alimtalk.templates", "create",
            "POST", "/api/comm/v1/center/alimtalk/template",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data.alimtalk");
    static final Operation UPDATE_ALIMTALK_TEMPLATE = new Operation("updateAlimtalkTemplate", "alimtalk.templates", "update",
            "PUT", "/api/comm/v1/center/alimtalk/template",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data.alimtalk");
    static final Operation LIST_ALIMTALK_TEMPLATES = new Operation("listAlimtalkTemplates", "alimtalk.templates", "list",
            "GET", "/api/comm/v1/center/alimtalk/template/list",
            Retry.SAFE, Operation.RateBucket.OTHER, "offset", "data.data.alimtalk.templates");
    static final Operation LIST_MODIFIED_ALIMTALK_TEMPLATES = new Operation("listModifiedAlimtalkTemplates", "alimtalk.templates", "listModified",
            "GET", "/api/comm/v1/center/alimtalk/template/lastModified",
            Retry.SAFE, Operation.RateBucket.OTHER, "page", "data.data.alimtalk.templates");
    static final Operation DELETE_ALIMTALK_TEMPLATE = new Operation("deleteAlimtalkTemplate", "alimtalk.templates", "delete",
            "DELETE", "/api/comm/v1/center/alimtalk/template/senderKey/{senderKey}/templateCode/{templateCode}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_ALIMTALK_TEMPLATE_IMAGE = new Operation("uploadAlimtalkTemplateImage", "files", "uploadAlimtalkTemplateImage",
            "POST", "/api/comm/v1/file/alimtalk/template",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_ALIMTALK_ITEM_HIGHLIGHT_IMAGE = new Operation("uploadAlimtalkItemHighlightImage", "files", "uploadAlimtalkItemHighlightImage",
            "POST", "/api/comm/v1/file/alimtalk/itemHighlight",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_ALIMTALK_TEMPLATE_CATEGORIES = new Operation("listAlimtalkTemplateCategories", "alimtalk.templateCategories", "list",
            "GET", "/api/comm/v1/center/alimtalk/category",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation REQUEST_ALIMTALK_TEMPLATE_INSPECTION = new Operation("requestAlimtalkTemplateInspection", "alimtalk.templates", "requestInspection",
            "POST", "/api/comm/v1/center/alimtalk/template/request",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CANCEL_ALIMTALK_TEMPLATE_INSPECTION = new Operation("cancelAlimtalkTemplateInspection", "alimtalk.templates", "cancelInspection",
            "POST", "/api/comm/v1/center/alimtalk/template/request/cancel",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_ALIMTALK_PUBLIC_TEMPLATES = new Operation("listAlimtalkPublicTemplates", "alimtalk.publicTemplates", "list",
            "GET", "/api/comm/v1/center/alimtalk/public/template",
            Retry.SAFE, Operation.RateBucket.OTHER, "page", "data.data.templates");
    static final Operation CREATE_BRAND_MESSAGE_GROUP_SEND = new Operation("createBrandMessageGroupSend", "brandMessage.groupSends", "create",
            "POST", "/api/comm/v1/center/brandmessage/groupMessage",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.SEND, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_GROUP_SEND = new Operation("getBrandMessageGroupSend", "brandMessage.groupSends", "get",
            "GET", "/api/comm/v1/center/brandmessage/groupMessage",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation RESUME_BRAND_MESSAGE_GROUP_SEND = new Operation("resumeBrandMessageGroupSend", "brandMessage.groupSends", "resume",
            "POST", "/api/comm/v1/center/brandmessage/groupMessage/resume",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation PAUSE_BRAND_MESSAGE_GROUP_SEND = new Operation("pauseBrandMessageGroupSend", "brandMessage.groupSends", "pause",
            "POST", "/api/comm/v1/center/brandmessage/groupMessage/pause",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation TERMINATE_BRAND_MESSAGE_GROUP_SEND = new Operation("terminateBrandMessageGroupSend", "brandMessage.groupSends", "terminate",
            "POST", "/api/comm/v1/center/brandmessage/groupMessage/terminate",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE = new Operation("checkBrandMessageAudiencePossible", "brandMessage.audience", "checkPossible",
            "GET", "/api/comm/v1/center/brandmessage/groupMessage/possible",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE_BY_PHONE_NUMBERS = new Operation("checkBrandMessageAudiencePossibleByPhoneNumbers", "brandMessage.audience", "checkPossibleByPhoneNumbers",
            "POST", "/api/comm/v1/center/brandmessage/groupMessage/friend/possible",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_FRIEND_COUNT = new Operation("getBrandMessageFriendCount", "brandMessage.audience", "getFriendCount",
            "GET", "/api/comm/v1/center/brandmessage/groupMessage/friendCount",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation ESTIMATE_BRAND_MESSAGE_GROUP_SEND_DURATION = new Operation("estimateBrandMessageGroupSendDuration", "brandMessage.audience", "estimate",
            "GET", "/api/comm/v1/center/brandmessage/groupMessage/estimate",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CHECK_BRAND_MESSAGE_SEND_PERMISSION = new Operation("checkBrandMessageSendPermission", "brandMessage.permissions", "check",
            "GET", "/api/comm/v1/center/brandmessage/sendPermission",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation APPLY_BRAND_MESSAGE_SEND_PERMISSION = new Operation("applyBrandMessageSendPermission", "brandMessage.permissions", "apply",
            "POST", "/api/comm/v1/center/brandmessage/sendPermission",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_CATALOG_IMAGE = new Operation("uploadBrandMessageCatalogImage", "files", "uploadBrandMessageCatalog",
            "POST", "/api/comm/v1/file/brandmessage/catalog",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_CATALOG_ODD_FIRST_IMAGE = new Operation("uploadBrandMessageCatalogOddFirstImage", "files", "uploadBrandMessageCatalogOddFirst",
            "POST", "/api/comm/v1/file/brandmessage/catalog/oddFirst",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation REGISTER_BRAND_MESSAGE_VIDEO_UPLOAD = new Operation("registerBrandMessageVideoUpload", "brandMessage.videos", "registerUpload",
            "POST", "/api/comm/v1/center/brandmessage/video/upload/register",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation REGISTER_BRAND_MESSAGE_EXISTING_VIDEO = new Operation("registerBrandMessageExistingVideo", "brandMessage.videos", "registerExisting",
            "POST", "/api/comm/v1/center/brandmessage/video/register",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_VIDEO = new Operation("getBrandMessageVideo", "brandMessage.videos", "get",
            "GET", "/api/comm/v1/center/brandmessage/video",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_BRAND_MESSAGE_VIDEOS = new Operation("listBrandMessageVideos", "brandMessage.videos", "list",
            "GET", "/api/comm/v1/center/brandmessage/video/list",
            Retry.SAFE, Operation.RateBucket.OTHER, "offset", "data.data");
    static final Operation GET_BRAND_MESSAGE_TEMPLATE = new Operation("getBrandMessageTemplate", "brandMessage.templates", "get",
            "GET", "/api/comm/v1/center/brandmessage/template",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CREATE_BRAND_MESSAGE_TEMPLATE = new Operation("createBrandMessageTemplate", "brandMessage.templates", "create",
            "POST", "/api/comm/v1/center/brandmessage/template",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPDATE_BRAND_MESSAGE_TEMPLATE = new Operation("updateBrandMessageTemplate", "brandMessage.templates", "update",
            "PUT", "/api/comm/v1/center/brandmessage/template",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_BRAND_MESSAGE_TEMPLATES = new Operation("listBrandMessageTemplates", "brandMessage.templates", "list",
            "GET", "/api/comm/v1/center/brandmessage/template/list",
            Retry.SAFE, Operation.RateBucket.OTHER, "offset", "data.data");
    static final Operation LIST_BRAND_MESSAGE_TEMPLATES_LAST_MODIFIED = new Operation("listBrandMessageTemplatesLastModified", "brandMessage.templates", "listLastModified",
            "GET", "/api/comm/v1/center/brandmessage/template/lastModified",
            Retry.SAFE, Operation.RateBucket.OTHER, "page", "data.data");
    static final Operation DELETE_BRAND_MESSAGE_TEMPLATE = new Operation("deleteBrandMessageTemplate", "brandMessage.templates", "delete",
            "DELETE", "/api/comm/v1/center/brandmessage/template/senderKey/{senderKey}/templateCode/{templateCode}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_BRAND_MESSAGE_GROUP_TAGS = new Operation("listBrandMessageGroupTags", "brandMessage.groupTags", "list",
            "GET", "/api/comm/v1/center/brandmessage/groupTag/list",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_GROUP_TAG = new Operation("getBrandMessageGroupTag", "brandMessage.groupTags", "get",
            "GET", "/api/comm/v1/center/brandmessage/groupTag",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CREATE_BRAND_MESSAGE_GROUP_TAG = new Operation("createBrandMessageGroupTag", "brandMessage.groupTags", "create",
            "POST", "/api/comm/v1/center/brandmessage/groupTag",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPDATE_BRAND_MESSAGE_GROUP_TAG = new Operation("updateBrandMessageGroupTag", "brandMessage.groupTags", "update",
            "PUT", "/api/comm/v1/center/brandmessage/groupTag",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DELETE_BRAND_MESSAGE_GROUP_TAG = new Operation("deleteBrandMessageGroupTag", "brandMessage.groupTags", "delete",
            "DELETE", "/api/comm/v1/center/brandmessage/groupTag/senderKey/{senderKey}/groupTagKey/{groupTagKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_FRIEND_GROUP_FILE = new Operation("uploadBrandMessageFriendGroupFile", "brandMessage.friendGroups", "uploadFile",
            "POST", "/api/comm/v1/center/brandmessage/friendGroup/file",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CREATE_BRAND_MESSAGE_FRIEND_GROUP = new Operation("createBrandMessageFriendGroup", "brandMessage.friendGroups", "create",
            "POST", "/api/comm/v1/center/brandmessage/friendGroup",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_BRAND_MESSAGE_FRIEND_GROUP = new Operation("getBrandMessageFriendGroup", "brandMessage.friendGroups", "get",
            "GET", "/api/comm/v1/center/brandmessage/friendGroup",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_BRAND_MESSAGE_FRIEND_GROUPS = new Operation("listBrandMessageFriendGroups", "brandMessage.friendGroups", "list",
            "GET", "/api/comm/v1/center/brandmessage/friendGroup/list",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DELETE_BRAND_MESSAGE_FRIEND_GROUP = new Operation("deleteBrandMessageFriendGroup", "brandMessage.friendGroups", "delete",
            "DELETE", "/api/comm/v1/center/brandmessage/friendGroup/senderKey/{senderKey}/friendGroupKey/{friendGroupKey}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation ADD_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS = new Operation("addBrandMessageFriendGroupPhoneNumbers", "brandMessage.friendGroups", "addPhoneNumbers",
            "POST", "/api/comm/v1/center/brandmessage/friendGroup/phoneNumber/update",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DELETE_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS = new Operation("deleteBrandMessageFriendGroupPhoneNumbers", "brandMessage.friendGroups", "deletePhoneNumbers",
            "POST", "/api/comm/v1/center/brandmessage/friendGroup/phoneNumber/delete",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUESTS = new Operation("listBrandMessageFriendGroupPhoneNumberRequests", "brandMessage.friendGroups", "listPhoneNumberRequests",
            "GET", "/api/comm/v1/center/brandmessage/friendGroup/phoneNumber/requests",
            Retry.SAFE, Operation.RateBucket.OTHER, "cursor", "data.data");
    static final Operation GET_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUEST = new Operation("getBrandMessageFriendGroupPhoneNumberRequest", "brandMessage.friendGroups", "getPhoneNumberRequest",
            "GET", "/api/comm/v1/center/brandmessage/friendGroup/phoneNumber/request",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_BRAND_MESSAGE_MARKETING_AGREE_EVIDENCE = new Operation("uploadBrandMessageMarketingAgreeEvidence", "brandMessage.marketingAgreements", "uploadEvidence",
            "POST", "/api/comm/v1/center/brandmessage/marketingAgree",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation REGISTER_BRAND_MESSAGE_UNSUBSCRIBE_CONTENT = new Operation("registerBrandMessageUnsubscribeContent", "brandMessage.unsubscribeContents", "register",
            "POST", "/api/comm/v1/center/brandmessage/unSubscribeContent",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_RCS_BRAND = new Operation("getRcsBrand", "rcs.brands", "get",
            "GET", "/api/comm/v1/center/rcs/brand",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPDATE_RCS_BRAND = new Operation("updateRcsBrand", "rcs.brands", "update",
            "PUT", "/api/comm/v1/center/rcs/brand",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_RCS_CHATBOTS = new Operation("listRcsChatbots", "rcs.chatbots", "list",
            "GET", "/api/comm/v1/center/rcs/chatbot/list",
            Retry.SAFE, Operation.RateBucket.OTHER, "offset", "data.data");
    static final Operation GET_RCS_CHATBOT = new Operation("getRcsChatbot", "rcs.chatbots", "get",
            "GET", "/api/comm/v1/center/rcs/chatbot",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPDATE_RCS_CHATBOT = new Operation("updateRcsChatbot", "rcs.chatbots", "update",
            "PUT", "/api/comm/v1/center/rcs/chatbot",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CANCEL_RCS_CHATBOT_APPROVAL = new Operation("cancelRcsChatbotApproval", "rcs.chatbots", "cancel",
            "PUT", "/api/comm/v1/center/rcs/brandId/{brandId}/chatbotId/{chatbotId}/cancel",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DELETE_RCS_CHATBOT = new Operation("deleteRcsChatbot", "rcs.chatbots", "delete",
            "DELETE", "/api/comm/v1/center/rcs/brandId/{brandId}/chatbotId/{chatbotId}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_RCS_CHATBOT_USABLE_QUERIES = new Operation("getRcsChatbotUsableQueries", "rcs.chatbots", "getUsableQueries",
            "GET", "/api/comm/v1/center/rcs/usableQuery/chatbotId/{chatbotId}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_RCS_COMMON_FORMATS = new Operation("listRcsCommonFormats", "rcs.commonFormats", "list",
            "GET", "/api/comm/v1/center/rcs/messagebase/common/list",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_RCS_COMMON_FORMAT = new Operation("getRcsCommonFormat", "rcs.commonFormats", "get",
            "GET", "/api/comm/v1/center/rcs/messagebase/common",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_RCS_TEMPLATE_FORMS = new Operation("listRcsTemplateForms", "rcs.templateForms", "list",
            "GET", "/api/comm/v1/center/rcs/messagebase/messagebaseform/list",
            Retry.SAFE, Operation.RateBucket.OTHER, "offset", "data.data");
    static final Operation GET_RCS_TEMPLATE_FORM = new Operation("getRcsTemplateForm", "rcs.templateForms", "get",
            "GET", "/api/comm/v1/center/rcs/messagebase/messagebaseform",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_RCS_TEMPLATES = new Operation("listRcsTemplates", "rcs.templates", "list",
            "GET", "/api/comm/v1/center/rcs/messagebase/list",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_RCS_TEMPLATE = new Operation("getRcsTemplate", "rcs.templates", "get",
            "GET", "/api/comm/v1/center/rcs/messagebase",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CREATE_RCS_TEMPLATE = new Operation("createRcsTemplate", "rcs.templates", "create",
            "POST", "/api/comm/v1/center/rcs/messagebase",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPDATE_RCS_TEMPLATE = new Operation("updateRcsTemplate", "rcs.templates", "update",
            "PUT", "/api/comm/v1/center/rcs/messagebase",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CANCEL_RCS_TEMPLATE_APPROVAL = new Operation("cancelRcsTemplateApproval", "rcs.templates", "cancel",
            "PUT", "/api/comm/v1/center/rcs/brandId/{brandId}/messagebaseId/{messagebaseId}/cancel",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DELETE_RCS_TEMPLATE = new Operation("deleteRcsTemplate", "rcs.templates", "delete",
            "DELETE", "/api/comm/v1/center/rcs/brandId/{brandId}/messagebaseId/{messagebaseId}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_RCS_TEMPLATE_IMAGE = new Operation("getRcsTemplateImage", "rcs.templateImages", "get",
            "GET", "/api/comm/v1/center/rcs/messagebase/file",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_RCS_TEMPLATE_IMAGE = new Operation("uploadRcsTemplateImage", "rcs.templateImages", "upload",
            "POST", "/api/comm/v1/center/rcs/messagebase/file",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_RCS_TEMPLATE_FORM_LOGOS = new Operation("listRcsTemplateFormLogos", "rcs.templateImages", "listFormLogos",
            "GET", "/api/comm/v1/center/rcs/messagebase/messagebaseform/logo",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation SEND_COUNSEL_PLAIN = new Operation("sendCounselPlain", "counsel.messages", "sendPlain",
            "POST", "/api/comm/v1/cstalk/plain",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.SEND, null, "data");
    static final Operation SEND_COUNSEL_RICH = new Operation("sendCounselRich", "counsel.messages", "sendRich",
            "POST", "/api/comm/v1/cstalk/rich",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.SEND, null, "data");
    static final Operation END_COUNSEL_SESSION = new Operation("endCounselSession", "counsel.sessions", "end",
            "POST", "/api/comm/v1/cstalk/end",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation END_COUNSEL_SESSION_WITH_BOT = new Operation("endCounselSessionWithBot", "counsel.sessions", "endWithBot",
            "POST", "/api/comm/v1/cstalk/endWithBot",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation BLOCK_COUNSEL_USER = new Operation("blockCounselUser", "counsel.users", "block",
            "POST", "/api/comm/v1/center/cstalk/profile/user/block",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UNBLOCK_COUNSEL_USER = new Operation("unblockCounselUser", "counsel.users", "unblock",
            "POST", "/api/comm/v1/center/cstalk/profile/user/unblock",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_COUNSEL_SESSION = new Operation("getCounselSession", "counsel.sessions", "get",
            "GET", "/api/comm/v1/center/cstalk/session",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_COUNSEL_CERT_STATUS = new Operation("getCounselCertStatus", "counsel.certs", "get",
            "GET", "/api/comm/v1/center/cstalk/cert/status",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_COUNSEL_IMAGE = new Operation("uploadCounselImage", "counsel.files", "uploadImage",
            "POST", "/api/comm/v1/file/cstalk/image",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation UPLOAD_COUNSEL_FILE = new Operation("uploadCounselFile", "counsel.files", "upload",
            "POST", "/api/comm/v1/file/cstalk",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation ACTIVATE_COUNSEL = new Operation("activateCounsel", "counsel.channels", "activate",
            "POST", "/api/comm/v1/center/cstalk/sender/activate",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DEACTIVATE_COUNSEL = new Operation("deactivateCounsel", "counsel.channels", "deactivate",
            "POST", "/api/comm/v1/center/cstalk/sender/deactivate",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation ACTIVATE_COUNSEL_CHAT = new Operation("activateCounselChat", "counsel.channels", "activateChat",
            "POST", "/api/comm/v1/center/cstalk/sender/chat/activate",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DEACTIVATE_COUNSEL_CHAT = new Operation("deactivateCounselChat", "counsel.channels", "deactivateChat",
            "POST", "/api/comm/v1/center/cstalk/sender/chat/deactivate",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation GET_COUNSEL_CONSULT_TIME = new Operation("getCounselConsultTime", "counsel.consultTime", "get",
            "GET", "/api/comm/v1/center/cstalk/consult/time",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation SAVE_COUNSEL_CONSULT_TIME = new Operation("saveCounselConsultTime", "counsel.consultTime", "save",
            "POST", "/api/comm/v1/center/cstalk/consult/time",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation LIST_COUNSEL_SYSTEM_MESSAGES = new Operation("listCounselSystemMessages", "counsel.systemMessages", "list",
            "GET", "/api/comm/v1/center/cstalk/system/message",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CREATE_COUNSEL_SYSTEM_MESSAGE = new Operation("createCounselSystemMessage", "counsel.systemMessages", "create",
            "POST", "/api/comm/v1/center/cstalk/system/message",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DELETE_COUNSEL_SYSTEM_MESSAGE = new Operation("deleteCounselSystemMessage", "counsel.systemMessages", "delete",
            "DELETE", "/api/comm/v1/center/cstalk/system/message/senderKey/{senderKey}/id/{id}",
            Retry.SAFE, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation REQUEST_COUNSEL_SYSTEM_MESSAGE_APPROVAL = new Operation("requestCounselSystemMessageApproval", "counsel.systemMessages", "requestApproval",
            "POST", "/api/comm/v1/center/cstalk/system/message/approval/request",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation CANCEL_COUNSEL_SYSTEM_MESSAGE_APPROVAL = new Operation("cancelCounselSystemMessageApproval", "counsel.systemMessages", "cancelApproval",
            "POST", "/api/comm/v1/center/cstalk/system/message/approval/cancel",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");
    static final Operation DELETE_COUNSEL_MESSAGE = new Operation("deleteCounselMessage", "counsel.messages", "delete",
            "POST", "/api/comm/v1/center/cstalk/chat/delete",
            Retry.RATE_LIMIT_ONLY, Operation.RateBucket.OTHER, null, "data.data");

    /** All operations in spec order. */
    static final List<Operation> ALL = List.of(
            SEND_OMNI,
            UPLOAD_MMS_FILE,
            UPLOAD_RCS_FILE,
            UPLOAD_BRAND_MESSAGE_DEFAULT_IMAGE,
            UPLOAD_BRAND_MESSAGE_WIDE_IMAGE,
            UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_FIRST_IMAGE,
            UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_IMAGE,
            UPLOAD_BRAND_MESSAGE_CAROUSEL_FEED_IMAGE,
            UPLOAD_BRAND_MESSAGE_CAROUSEL_COMMERCE_IMAGE,
            GET_REPORT_POLLING,
            ACK_REPORT_POLLING,
            GET_REPORT_INQUIRY,
            GET_MESSAGE_STATISTICS,
            GET_MESSAGE_HISTORY,
            GET_MO_HISTORY,
            GET_MESSAGE_STATUS_BY_MSG_KEY,
            GET_MESSAGE_STATUS_BY_REQUEST_ID,
            GET_MO_BY_MSG_KEY,
            CREATE_RESERVATION,
            LIST_RESERVATIONS,
            GET_RESERVATION,
            UPDATE_RESERVATION,
            CANCEL_RESERVATION,
            STOP_RESERVATION,
            RESUME_RESERVATION,
            ADD_RESERVATION_RECIPIENTS,
            LIST_RESERVATION_RECIPIENTS,
            DELETE_RESERVATION_RECIPIENT,
            GET_ALIMTALK_INSIGHT,
            GET_ALIMTALK_HOURLY_INSIGHT,
            GET_ALIMTALK_TEMPLATE_INSIGHT,
            GET_BRAND_MESSAGE_INSIGHT,
            GET_BRAND_MESSAGE_HOURLY_INSIGHT,
            GET_BRAND_MESSAGE_TEMPLATE_INSIGHT,
            GET_RCS_MESSAGE_INSIGHT,
            GET_RCS_MESSAGE_BUTTON_INSIGHT,
            GET_RCS_PERSISTENT_MENU_INSIGHT,
            GET_RCS_BRAND_PROFILE_INSIGHT,
            REQUEST_KAKAO_SENDER_TOKEN,
            CREATE_KAKAO_SENDER,
            FIND_KAKAO_SENDER,
            LIST_KAKAO_SENDER_PROFILES,
            GET_KAKAO_SENDER,
            RECOVER_KAKAO_SENDER,
            LIST_KAKAO_SENDER_CATEGORIES,
            GET_KAKAO_SENDER_CATEGORY,
            LIST_KAKAO_GROUPS,
            ADD_KAKAO_GROUP_SENDER,
            REMOVE_KAKAO_GROUP_SENDER,
            GET_KAKAO_SENDER_SANCTION,
            GET_KAKAO_GROUP_TEMPLATE_SENDER_EXCLUSION,
            GET_KAKAO_TEMPLATE_SANCTION,
            GET_ALIMTALK_TEMPLATE,
            CREATE_ALIMTALK_TEMPLATE,
            UPDATE_ALIMTALK_TEMPLATE,
            LIST_ALIMTALK_TEMPLATES,
            LIST_MODIFIED_ALIMTALK_TEMPLATES,
            DELETE_ALIMTALK_TEMPLATE,
            UPLOAD_ALIMTALK_TEMPLATE_IMAGE,
            UPLOAD_ALIMTALK_ITEM_HIGHLIGHT_IMAGE,
            LIST_ALIMTALK_TEMPLATE_CATEGORIES,
            REQUEST_ALIMTALK_TEMPLATE_INSPECTION,
            CANCEL_ALIMTALK_TEMPLATE_INSPECTION,
            LIST_ALIMTALK_PUBLIC_TEMPLATES,
            CREATE_BRAND_MESSAGE_GROUP_SEND,
            GET_BRAND_MESSAGE_GROUP_SEND,
            RESUME_BRAND_MESSAGE_GROUP_SEND,
            PAUSE_BRAND_MESSAGE_GROUP_SEND,
            TERMINATE_BRAND_MESSAGE_GROUP_SEND,
            CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE,
            CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE_BY_PHONE_NUMBERS,
            GET_BRAND_MESSAGE_FRIEND_COUNT,
            ESTIMATE_BRAND_MESSAGE_GROUP_SEND_DURATION,
            CHECK_BRAND_MESSAGE_SEND_PERMISSION,
            APPLY_BRAND_MESSAGE_SEND_PERMISSION,
            UPLOAD_BRAND_MESSAGE_CATALOG_IMAGE,
            UPLOAD_BRAND_MESSAGE_CATALOG_ODD_FIRST_IMAGE,
            REGISTER_BRAND_MESSAGE_VIDEO_UPLOAD,
            REGISTER_BRAND_MESSAGE_EXISTING_VIDEO,
            GET_BRAND_MESSAGE_VIDEO,
            LIST_BRAND_MESSAGE_VIDEOS,
            GET_BRAND_MESSAGE_TEMPLATE,
            CREATE_BRAND_MESSAGE_TEMPLATE,
            UPDATE_BRAND_MESSAGE_TEMPLATE,
            LIST_BRAND_MESSAGE_TEMPLATES,
            LIST_BRAND_MESSAGE_TEMPLATES_LAST_MODIFIED,
            DELETE_BRAND_MESSAGE_TEMPLATE,
            LIST_BRAND_MESSAGE_GROUP_TAGS,
            GET_BRAND_MESSAGE_GROUP_TAG,
            CREATE_BRAND_MESSAGE_GROUP_TAG,
            UPDATE_BRAND_MESSAGE_GROUP_TAG,
            DELETE_BRAND_MESSAGE_GROUP_TAG,
            UPLOAD_BRAND_MESSAGE_FRIEND_GROUP_FILE,
            CREATE_BRAND_MESSAGE_FRIEND_GROUP,
            GET_BRAND_MESSAGE_FRIEND_GROUP,
            LIST_BRAND_MESSAGE_FRIEND_GROUPS,
            DELETE_BRAND_MESSAGE_FRIEND_GROUP,
            ADD_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS,
            DELETE_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS,
            LIST_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUESTS,
            GET_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUEST,
            UPLOAD_BRAND_MESSAGE_MARKETING_AGREE_EVIDENCE,
            REGISTER_BRAND_MESSAGE_UNSUBSCRIBE_CONTENT,
            GET_RCS_BRAND,
            UPDATE_RCS_BRAND,
            LIST_RCS_CHATBOTS,
            GET_RCS_CHATBOT,
            UPDATE_RCS_CHATBOT,
            CANCEL_RCS_CHATBOT_APPROVAL,
            DELETE_RCS_CHATBOT,
            GET_RCS_CHATBOT_USABLE_QUERIES,
            LIST_RCS_COMMON_FORMATS,
            GET_RCS_COMMON_FORMAT,
            LIST_RCS_TEMPLATE_FORMS,
            GET_RCS_TEMPLATE_FORM,
            LIST_RCS_TEMPLATES,
            GET_RCS_TEMPLATE,
            CREATE_RCS_TEMPLATE,
            UPDATE_RCS_TEMPLATE,
            CANCEL_RCS_TEMPLATE_APPROVAL,
            DELETE_RCS_TEMPLATE,
            GET_RCS_TEMPLATE_IMAGE,
            UPLOAD_RCS_TEMPLATE_IMAGE,
            LIST_RCS_TEMPLATE_FORM_LOGOS,
            SEND_COUNSEL_PLAIN,
            SEND_COUNSEL_RICH,
            END_COUNSEL_SESSION,
            END_COUNSEL_SESSION_WITH_BOT,
            BLOCK_COUNSEL_USER,
            UNBLOCK_COUNSEL_USER,
            GET_COUNSEL_SESSION,
            GET_COUNSEL_CERT_STATUS,
            UPLOAD_COUNSEL_IMAGE,
            UPLOAD_COUNSEL_FILE,
            ACTIVATE_COUNSEL,
            DEACTIVATE_COUNSEL,
            ACTIVATE_COUNSEL_CHAT,
            DEACTIVATE_COUNSEL_CHAT,
            GET_COUNSEL_CONSULT_TIME,
            SAVE_COUNSEL_CONSULT_TIME,
            LIST_COUNSEL_SYSTEM_MESSAGES,
            CREATE_COUNSEL_SYSTEM_MESSAGE,
            DELETE_COUNSEL_SYSTEM_MESSAGE,
            REQUEST_COUNSEL_SYSTEM_MESSAGE_APPROVAL,
            CANCEL_COUNSEL_SYSTEM_MESSAGE_APPROVAL,
            DELETE_COUNSEL_MESSAGE);

    private Operations() {
    }
}
