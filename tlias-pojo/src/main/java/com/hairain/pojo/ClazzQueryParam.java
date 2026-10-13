package com.hairain.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * ClassName:ClazzQueryParam
 * Package: com.hairain.pojo
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/9 12:24
 * @Version 1.0
 */
@Data
public class ClazzQueryParam {

    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

}
