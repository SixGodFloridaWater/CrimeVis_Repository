package com.system.conttoller;

import com.system.VO.DataVO;
import com.system.mapper.CrimedataMapper;
import com.system.pojo.Countdata;
import com.system.pojo.Crimedata;
import com.system.pojo.Genderdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataVO getCrimedataByMonth(@RequestParam String month) {
        // 调用CrimedataMapper中的groupByMonth方法按照月份查询数据
        List<Crimedata> result = crimedataMapper.groupByMonth(month);
        return DataVO.success("0", result);
    }

    @PostMapping("/getCount")
    public DataVO getCountdata(){
        List<Countdata> result = crimedataMapper.groupByLatLon();
        return DataVO.success("0",result);
    }

    @PostMapping("/getGender")
    public DataVO getGender(){
        List<Genderdata> result = crimedataMapper.groupByDate();
        for(Genderdata data : result) {
            data.formatDateTime();
        }
        return DataVO.success("0",result);
    }
}