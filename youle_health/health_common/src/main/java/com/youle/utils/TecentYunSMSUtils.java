package com.youle.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

/**
 * @author MaRui
 * @date 2021-06-07 9:23
 */
public class TecentYunSMSUtils {
    public static void main(String[] args) {
        System.out.println("========================");
        // 短信应用SDK AppID
        int appid = 1400530429; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "89908db9d9b7a5fe32a7e0cecf97226d";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {"13881804248"};
        // 短信模板ID，需要在短信应用中申请
        int templateId = 985572; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
        //templateId7839对应的内容是"您的验证码是: {1}"
        try {
            String[] params = {"2021-6-4"};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, "gokamisama", "", "");// 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            //json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            //网络IO错误
            e.printStackTrace();
        }
    }

    public static void sendOrderMessage(String telephone, String validateCode) {
        System.out.println("========================");
        // 短信应用SDK AppID
        int appid = 1400530429; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "89908db9d9b7a5fe32a7e0cecf97226d";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {telephone};
        // 短信模板ID，需要在短信应用中申请
        int templateId = 985568; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
        //templateId7839对应的内容是"您的验证码是: {1}"
        try {
            String[] params = {validateCode};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, "gokamisama", "", "");// 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            //json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            //网络IO错误
            e.printStackTrace();
        }
    }

    public static void sendSuccessMessage(String telephone, String orderDate) {
        System.out.println("========================");
        // 短信应用SDK AppID
        int appid = 1400530429; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "89908db9d9b7a5fe32a7e0cecf97226d";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {telephone};
        // 短信模板ID，需要在短信应用中申请
        int templateId = 985572; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
        //templateId7839对应的内容是"您的验证码是: {1}"
        try {
            String[] params = {orderDate};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, "gokamisama", "", "");// 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            //json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            //网络IO错误
            e.printStackTrace();
        }
    }

    public static void sendLoginMessage(String telephone, String validateCode) {
        System.out.println("========================");
        // 短信应用SDK AppID
        int appid = 1400530429; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "89908db9d9b7a5fe32a7e0cecf97226d";
        // 需要发送短信的手机号码
        String[] phoneNumbers = {telephone};
        // 短信模板ID，需要在短信应用中申请
        int templateId = 981241; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
        //templateId7839对应的内容是"您的验证码是: {1}"
        try {
            String[] params = {validateCode};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, "gokamisama", "", "");// 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            //json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            //网络IO错误
            e.printStackTrace();
        }
    }
}
