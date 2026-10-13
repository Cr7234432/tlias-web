package com.hairain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName:JobOption
 * Package: com.hairain.pojo
 * Description:
 *
 * @Author Hairain
 * @Create 2026/10/8 16:22
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {

    private List jobList;
    private List dataList;
}
