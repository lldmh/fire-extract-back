package com.ncut.fireextractback.domain.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class ExtractData  {
    @TableId
    private Integer id;
    
    private String stype;
    
    private String sname;
    
    private String otype;
    
    private String oname;
    
    private String ship;
    
    private Integer isDelete;
    
    private Integer isAdd;



}

