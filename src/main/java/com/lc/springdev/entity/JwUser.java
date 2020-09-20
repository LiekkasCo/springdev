package com.lc.springdev.entity;

import lombok.Data;
import java.sql.Timestamp;
/**
 * @author liangchen
 */
@Data
public class JwUser {

  private long id;
  private String name;
  private long age;
  private String gender;
  private long delFlag;
  private Timestamp createTime;
  private Timestamp updateTime;


}
