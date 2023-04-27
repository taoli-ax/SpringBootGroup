package com.coh.ssm.pojo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class Cup {
    private int id;
    @ApiModelProperty(value = "茶杯名字",dataType = "String",required = true)
    private String name;
    @ApiModelProperty(value = "茶杯品牌",dataType = "String",required = true)
    private String brand;
    @ApiModelProperty(value = "头像", dataType = "String",required = false)
    private String avatar;
}
