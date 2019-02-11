package com.dq.xindai.utils;

import java.net.URI;

/**
 * 接口汇总
 * Created by jingang on 2018/12/13.
 */

public class HttpPath {

    public static final String URL = "http://www.dequantouzi.com/app/";

    /**
     * 登录
     * 参数：mobile password token
     */
    public static final String LOGIN = URL + "login.html?";

    /**
     * 注册
     * 参数： source（来源：4安卓、5苹果）,  mobile,  password,  mobile_code（验证码）,  token
     */
    public static final String RES = URL + "register.html?";

    /**
     * 找回密码（未知密码）
     * 参数：mobile,  mobile_code,  password, token
     */
    public static final String REPWD = URL + "repwd.html?";

    /**
     * 短信验证码
     * 参数：mobile,  key(短信类型：register/repwd),  token
     */
    public static final String SENDMOBILE = URL + "sendmobile.html?";

    /**
     * 修改密码（已知密码）
     * 参数：oldpassword（原始密码）， password（新密码），token
     */
    public static final String MEM_PASSWORD = URL + "member/password.html?";

    /**
     * 开通存管
     * 参数：mobile， password，true_name，idcard，email，token
     */
    public static final String AUTH_AUTH = URL + "auth/auth.html?";

    /**
     * 用户基础信息
     * 参数：token
     */
    public static final String MEM_DETAILED = URL + "member/detailed.html?";

    /**
     * 投资交易查询
     * 参数:
     */
    public static final String SEARCH_INDEX = URL + "search/Index.html?";

    /**
     * 投资交易详情
     * 参数：tradeId token
     */
    public static final String SEARCH_DETAILS = URL + "search/Details.html?";

    /**
     * 回款账单
     * 参数：token
     */
    public static final String SEARCH_FLOW = URL + "search/Flow.html?";

    /**
     * 充值记录
     * 参数：page, pagesize, token
     */
    public static final String WALLET_RECHARGE_RECORD = URL + "wallet/recharge_record.html?";

    /**
     * 提现记录
     * 参数：page, pagesize, token
     */
    public static final String WALLET_WITHDRAW_RECORD = URL + "wallet/withdraw_record.html?";

    /**
     * 充值（网页跳转）
     * 参数：money， token
     */
    public static final String MEM_RECHARGE = URL + "member/recharge.html?";

    /**
     * 提现（网页跳转）
     * 参数：money ，token
     */
    public static final String MEM_WITHDRAW = URL + "member/withdraw.html?";

    /**
     * 可用余额
     * 参数：token
     */
    public static final String WALLET_BALANCE = URL + "wallet/balance.html?";


    /**
     * 首页
     * 参数：token
     */
    public static final String INDEX = URL + "index.html?";

    /**
     * 借款详情
     * 参数：id，token
     */
    public static final String FINANCE_DETAIL = URL + "finance/detail.html?";

    /**
     * 投资（跳转网页）
     * 参数：borrow_id， money，token
     */
    public static final String FINANCE_FINANCING = URL + "finance/financing";

    /**
     * 存管信息
     * 参数：token
     */
    public static final String CUSTODY_INDEX = URL + "custody/Index.html?";

    /**
     * 重置预留手机号（网页跳转）
     * 参数：token
     */
    public static final String CUSTODY_RESETMOBILE = URL + "custody/resetmobile.html?";

    /**
     * 注销存管
     * 参数：password ，token
     */
    public static final String CUSTODY_CANCELLATION = URL + "custody/cancellation.html?";

    /**
     * 绑定银行卡（网页跳转）
     * 参数：token
     */
    public static final String CUSTODY_BANK = URL + "custody/Bank.html?";

    /**
     * 解绑银行卡（网页跳转）
     * 参数：token
     */
    public static final String CUSTODY_UNBANK = URL + "custody/unBank.html?";

    /**
     * 手续费签约（网页跳转）
     * 参数：token
     */
    public static final String CUSTODY_QIANYUE = URL + "custody/qianyue.html?";

    /**
     * 修改支付密码（网页跳转）
     * 参数：token
     */
    public static final String CUSTODY_PASSWORD = URL + "custody/password.html?";

}
