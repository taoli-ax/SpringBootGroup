package com.coh.ssm.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@ApiModel
public class German {
     int id;
     String name;
     String description;
     String image;
     int camp_id;


}
