package com.hairain.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * ClassName:EmpQueryParam
 * Package: com.hairain.pojo
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/6 19:18
 * @Version 1.0
 */
@Data
public class EmpQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
