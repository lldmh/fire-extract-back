package com.ncut.fireextractback.domain.vo;


import com.baomidou.mybatisplus.annotation.TableId;
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
public class ExtractDataVo {

    
    private String stype;
    
    private String sname;
    
    private String otype;
    
    private String oname;
    
    private String ship;


}

