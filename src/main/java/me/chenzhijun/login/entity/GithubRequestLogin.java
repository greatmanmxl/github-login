package me.chenzhijun.login.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author chen
 * @version V1.0
 * @date 2017/9/29
 */
@Data
@ToString
public class GithubRequestLogin {
    private String client_id;

    private String client_secret;

    private String code;

    private String redirect;

    private String state;

    private String scope;

    private boolean allow_signup;
}
