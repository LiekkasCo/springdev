package com.lc.springdev.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * aliyun
 * @author liangchen
 * @date 2020.09.20
  */
@Data
@ConfigurationProperties(prefix = "aliyun")
@Component
public class AliyunProperties {
    private String aaaa;
    private String bbbb;
    private String cccc;
    private String dddd;
}
