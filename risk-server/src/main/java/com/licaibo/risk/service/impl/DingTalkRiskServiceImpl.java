package com.licaibo.risk.service.impl;

import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.licaibo.risk.enums.RiskChannelEnum;
import com.licaibo.risk.service.RiskService;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * dingtalk
 * @author licaibo
 * @date 2022-04-19
 **/
@Slf4j
@Service
public class DingTalkRiskServiceImpl implements RiskService {

    @Autowired
    private DingTalkClient dingTalkClient;

    private static final String DINGTALL_MSG_TEXT = "text";
    private static final String DINGTALL_MSG_MARKDOWN = "markdown";


    @Override
    public String getType() {
        return RiskChannelEnum.DINGTALK.name();
    }

    /**
     * 钉钉群设置安全策略，消息带有 '风控'才能触发通知
     * @param content
     * @return
     * @throws ApiException
     */
    @Override
    public boolean sendRiskTextMessage(String content) throws ApiException {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(DINGTALL_MSG_TEXT);
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll(true);
        request.setAt(at);
        OapiRobotSendResponse response = dingTalkClient.execute(request);
        return response.isSuccess();
    }

    /**
     * 发送Markdown消息
     * @param title 杭州天气
     * @param content #### [风控]杭州天气 @156xxxx8827\n" +
     *                 "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
     *                 "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n"  +
     *                 "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n
     * @return
     * @throws ApiException
     */
    @Override
    public boolean sendRiskMarkdownMessage(String title,String content) throws ApiException {
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype(DINGTALL_MSG_MARKDOWN);
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle(title);
        markdown.setText(content);
        request.setMarkdown(markdown);
        OapiRobotSendResponse response = dingTalkClient.execute(request);
        return response.isSuccess();
    }


}
