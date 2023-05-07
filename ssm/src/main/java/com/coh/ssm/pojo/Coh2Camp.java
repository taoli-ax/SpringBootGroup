package com.coh.ssm.pojo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class Coh2Camp {
    int id;
    String camp;
    String commander_count;
    LocalDateTime  create_at;
}
