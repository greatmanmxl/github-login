package me.chenzhijun.login.web;

import com.alibaba.fastjson.JSONObject;
import me.chenzhijun.login.config.ConfigConstant;
import me.chenzhijun.login.entity.GithubRequestLogin;
import me.chenzhijun.login.utils.RemoteRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chen
 * @version V1.0
 * @date 2017/9/29
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("login", "login");
        return "login/login";
    }

    @GetMapping("login/github")
    public String loginGithub(String code, Model model) {
        logger.info(code);
        System.out.println("code: " + code);
        String url = "https://github.com/login/oauth/access_token";

//        GithubRequestLogin param = new GithubRequestLogin();
//        param.setClient_id(ConfigConstant.CLIENT_ID);
//        param.setClient_secret(ConfigConstant.CLIENT_SECRET);
//        param.setCode(code);
//
//
//        JSONObject jsonObj = RemoteRequestUtil.postT(url, param, JSONObject.class);
//        System.out.println(jsonObj);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", ConfigConstant.CLIENT_ID);
        map.add("client_secret", ConfigConstant.CLIENT_SECRET);
        map.add("code", code);
        JSONObject jsonObject = RemoteRequestUtil.post(url, map, JSONObject.class);
        System.out.println("jsonObject:" + jsonObject);
        model.addAttribute("result", jsonObject);
        return "login/success";
    }

    /*****
     * 
http://127.0.0.1:8818/user/info?token=f969bb4cd0930d910acbcedab22c7a84f1ebfd3b
     */
    @GetMapping("user/info")
    public String getGitHubUserInfo(String token, Model model) {
        String url = "https://api.github.com/user?access_token=" + token;
        String result = RemoteRequestUtil.get(url);
        model.addAttribute("result", result);

        DigestUtils.md5DigestAsHex(result.getBytes());

        return "login/success";


    }
}
