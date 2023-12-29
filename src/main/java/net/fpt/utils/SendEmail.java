package net.fpt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class SendEmail  {
    static final Logger logger = LoggerFactory.getLogger(SendEmail.class);
    /**
     * Author: MinhLH5
     * Mô tả: Send email thông qua API
     * @param toEmail String
     * @param subject String
     * @param body String
     *
     */
    public static void sendEmailByAPI(String toEmail,String toCC,String toBCC,String subject,String body){
        try
        {
            logger.info("Call sendEmailByAPI");

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");

            Map<String, Object> bodyData = new HashMap<>();
            bodyData.put("FromEmail", "iscsupport@fpt.com.vn");
            bodyData.put("Recipients", toEmail);
            bodyData.put("CarbonCopys", toCC);
            bodyData.put("BlindCarbonCopys", toBCC );
            bodyData.put("Subject", "[Report Auto Test] " + subject );
            bodyData.put("Body", body);

            HttpResponse<JsonNode> jsonResponse
                    = Unirest.post("http://systemmailapi.fpt.vn/api/SendMailSMTP/InsertInfoSendMailSMTP")
                    .headers(headers).body(bodyData)
                    .asJson()
                    .ifSuccess(response -> {
                        logger.info("sendEmailByAPI-Success: " + response.getStatus());
                    })
                    .ifFailure(response -> {
                        logger.error("sendEmailByAPI-Failure: " + response.getStatus());
                        response.getParsingError().ifPresent(e -> {
                            logger.error("Parsing Exception: ", e);
                            logger.error("Original body: " + e.getOriginalBody());
                        });
                    });
        }
        catch (Exception e) {
            logger.error("Unable to sendEmailByAPI"+ e.getCause());
            e.printStackTrace();
        }
    }
}
