package com.hairain.pojo;

import lombok.Data;

/**
 * ClassName:StuQueryParam
 * Package: com.hairain.pojo
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 15:05
 * @Version 1.0
 */
@Data
public class StuQueryParam {
        private Integer page = 1;
        private Integer pageSize = 10;
        private String name;
        private Integer degree;
        private Integer clazzId;
}
