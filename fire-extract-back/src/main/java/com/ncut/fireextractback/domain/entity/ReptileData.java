package com.ncut.fireextractback.domain.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (ReptileData)表实体类
 *
 * @author makejava
 * @since 2023-11-03 09:08:12
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("reptile_data")
public class ReptileData  {
    @TableId
    private Integer repId;

    
    private String repName;
    
    private String repLink;
    
    private String repContent;



}

