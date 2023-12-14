package com.system.mapper;

import com.system.pojo.Countdata;
import com.system.pojo.Crimedata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.system.pojo.Genderdata;
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

    //    @Select("SELECT * FRO user WHERE age > #{age}")
    @Select("SELECT *  FROM crimedata WHERE MONTH(STR_TO_DATE(DATEOCC, '%m/%d/%Y %h:%i:%s %p')) = #{month} ")
//  @Select("SELECT *  FROM crimedata  WHERE DATE_FORMAT(DATEOCC ,'%m') = #{month} ")
    List<Crimedata> groupByMonth(String month);
    @Select("SELECT LAT, LON, COUNT(PremisCd) AS X_count FROM crimedata GROUP BY LAT, LON")
    List<Countdata> groupByLatLon();
    @Select("SELECT DATEOCC, VictSex, COUNT(*) AS OccurrenceCount FROM crimedata WHERE VictSex IN ('F', 'M') GROUP BY DATEOCC, VictSex ORDER BY DATEOCC;")
    List<Genderdata>groupByDate();

}


