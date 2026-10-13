package com.hairain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:LogInfo
 * Package: com.hairain.pojo
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/10 18:16
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogInfo {

    private Integer id;
    private String username;
    private String name;
    private String token;

}
