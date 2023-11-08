package com.ncut.fireextractback.domain.dto;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (ExtractData)表实体类
 *
 * @author makejava
 * @since 2023-11-02 21:58:23
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("extract_data")
public class UpdateExtractDataDto {
    private Integer id;

    private String stype;
    
    private String sname;
    
    private String otype;
    
    private String oname;
    
    private String ship;


}

