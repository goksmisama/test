package com.youle.controller;

import com.youle.constant.MessageConstant;
import com.youle.constant.RedisMessageConstant;
import com.youle.entity.Result;
import com.youle.utils.TecentYunSMSUtils;
import com.youle.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

/**
 * @author MaRui
 * @date 2021-06-07 9:54
 */
@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {
    @Autowired
    private JedisPool jedisPool;

    //体检预约时发送手机验证码
    @RequestMapping("/send4Order.do")
    public Result send4Order(String telephone) {
        Integer code = ValidateCodeUtils.generateValidateCode(4);//生成4位数字验证码
        try {
            //发送短信
            TecentYunSMSUtils.sendOrderMessage(telephone, code.toString());
        } catch (Exception e) {
            e.printStackTrace();
            //验证码发送失败
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        System.out.println("发送的手机验证码为：" + code);
        //将生成的验证码缓存到redis
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER, 5 * 60, code.toString());
        //验证码发送成功
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

    @RequestMapping("/send4Login.do")
    public Result send4Login(String telephone) {
        Integer code = ValidateCodeUtils.generateValidateCode(6);//生成6位数字验证码
        try {
            //发送短信
            TecentYunSMSUtils.sendLoginMessage(telephone, code.toString());
        } catch (Exception e) {
            e.printStackTrace();
            //验证码发送失败
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        System.out.println("发送的手机验证码为：" + code);
        //将生成的验证码缓存到redis
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_LOGIN, 5 * 60, code.toString());
        //验证码发送成功
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }
}
