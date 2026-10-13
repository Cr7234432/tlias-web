package com.hairain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Page
 * Package: com.hairain.pojo
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/11 16:24
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVar {
    private Integer page = 1;
    private Integer pageSize = 10;
}
