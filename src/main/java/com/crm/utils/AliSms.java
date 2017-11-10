package com.crm.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 *
 * Created by Administrator on 2017/11/6.
 */
public class AliSms {
    public static void sendSmsByPhone(String phone,String captcha){
        try {
            //设置超时时间-可自行调整
            //System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            //System.setProperty("sun.net.client.defaultReadTimeout", "10000");
            //初始化ascClient需要的几个参数
            final String product = "Dysmsapi";
            final String domain = "dysmsapi.aliyuncs.com";
            //
            final String accessKeyId = "LTAIgoWTshWuxq4t";
            final String accessKeySecret = "8luhiGJTeeNPWyFHRauPB5O0SsXBnO";
            //初始化ascClient
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                    accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setPhoneNumbers(phone);
            request.setSignName("小箱子");
            request.setTemplateCode("SMS_108960023");
            request.setTemplateParam("{\"code\":\""+captcha+"\"}");
            //请求失败这里会抛ClientException异常
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
    //请求成功
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
