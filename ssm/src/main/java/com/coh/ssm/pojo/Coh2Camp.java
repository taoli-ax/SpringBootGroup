package com.coh.ssm.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss")
    Date create_at;
}
