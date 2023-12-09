package com.system.controller;

import com.system.VO.DataVO;
import com.system.mapper.CrimedataMapper;
import com.system.pojo.Countdata;
import com.system.pojo.Crimedata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crimedata")
public class CrimedataController {

    private final CrimedataMapper crimedataMapper;

    @Autowired
    public CrimedataController(CrimedataMapper crimedataMapper) {
        this.crimedataMapper = crimedataMapper;
    }

    @PostMapping("/groupByMonth")
    public DataVO getCrimedataByMonth(@RequestParam String monthStart,String monthEnd) {
        List<Crimedata> result = new ArrayList<>();
        for(int i = Integer.parseInt(monthStart);i <= Integer.parseInt(monthEnd) ;i++){
            // 调用CrimedataMapper中的groupByMonth方法按照月份查询数据
            List<Crimedata> data = crimedataMapper.groupByMonth(String.valueOf(i+1));
            result.addAll(data);
        }

        return DataVO.success("0", result);
    }

//        // 调用CrimedataMapper中的groupByMonth方法按照月份查询数据
//        List<Crimedata> result = crimedataMapper.groupByMonth(month);
//        return DataVO.success("0", result);
    @PostMapping("/getCount")
    public DataVO getCountdata(){
        List<Countdata> result = crimedataMapper.groupByLatLon();
        return DataVO.success("0",result);
    }

}