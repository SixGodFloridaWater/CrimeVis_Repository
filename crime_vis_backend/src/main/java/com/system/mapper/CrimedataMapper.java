package com.system.mapper;

import com.system.pojo.Crimedata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author 21628
* @description 针对表【crimedata】的数据库操作Mapper
* @createDate 2023-12-06 21:13:07
* @Entity com.system.pojo.Crimedata
*/
@Repository
public interface CrimedataMapper extends BaseMapper<Crimedata> {

    //    @Select("SELECT * FROM user WHERE age > #{age}")
    @Select("SELECT *  FROM crimedata WHERE MONTH(STR_TO_DATE(DATEOCC, '%m/%d/%Y %h:%i:%s %p')) = #{month} ")
//        @Select("SELECT *  FROM crimedata  WHERE DATE_FORMAT(DATEOCC ,'%m') = #{month} ")
    List<Crimedata> groupByMonth(String month);
}


