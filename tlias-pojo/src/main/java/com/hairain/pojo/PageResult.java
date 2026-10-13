package com.hairain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName:PageResult
 * Package: com.hairain.pojo
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/6 17:30
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
