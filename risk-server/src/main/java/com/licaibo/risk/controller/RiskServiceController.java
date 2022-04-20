package com.licaibo.risk.controller;

import com.licaibo.risk.enums.RiskChannelEnum;
import com.licaibo.risk.service.RiskService;
import com.licaibo.risk.vo.DingTalkMarkdownMsgVo;
import com.taobao.api.ApiException;
import org.springframework.web.bind.annotation.*;

/**
 * @author licaibo
 * @date 2022-04-19
 **/
@RestController
@RequestMapping("/risk")
public class RiskServiceController {

    /**
     * 发送文本消息
     * @return
     */
    @PostMapping("/dingtalk/text")
    public boolean text(@RequestBody String content) throws ApiException {
        return RiskService.router.get(RiskChannelEnum.DINGTALK.name()).sendRiskTextMessage(content);
    }

    /**
     * 发送markdown消息
     * @return
     */
    @PostMapping("/dingtalk/markdown")
    public boolean markdown(@RequestBody DingTalkMarkdownMsgVo dingTalkMarkdownMsgVo) throws ApiException {
        return RiskService.router.get(RiskChannelEnum.DINGTALK.name()).sendRiskMarkdownMessage(dingTalkMarkdownMsgVo.getTitle(),dingTalkMarkdownMsgVo.getMarkdownContent());
    }


}
