package com.dongzj.receiver.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/23
 * Time: 15:19
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 8609767263115003085L;

    private String username;

    private String password;
}
