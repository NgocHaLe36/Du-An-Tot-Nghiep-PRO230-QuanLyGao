/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gao.util;

import gao.entity.Users;

/**
 *
 * @author lengh
 */
public class XAuth {

    public static Users user = Users.builder()
            .username("halnts02076")
            .password("123")
            .enabled(true)
            .manager(true)
            .fullname("Lê Ngọc Hà")
            .photo("trump-small.png")
            .build(); // biến user này sẽ được thay thế sau khi đăng nhập
}
