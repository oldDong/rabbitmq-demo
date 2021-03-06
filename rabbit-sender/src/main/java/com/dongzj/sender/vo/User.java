package com.dongzj.sender.vo;

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

    private static final long serialVersionUID = 4690782216732356723L;

    private String username;

    private String password;
}
