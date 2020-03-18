package com.huanyu.fun.crawler.service;

import com.huanyu.fun.crawler.entity.WeChatOfficialAccount;

/**
 * @author
 * @version 1.0
 * @date
 */
public interface IWeChatOfficialAccountService {

    int save(WeChatOfficialAccount weChatOfficialAccount);

    int delete(Integer id);

    WeChatOfficialAccount query(Integer id);

}
