package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.pojo.Crimedata;
import generator.service.CrimedataService;
import generator.mapper.CrimedataMapper;
import org.springframework.stereotype.Service;

/**
* @author 21628
* @description 针对表【crimedata】的数据库操作Service实现
* @createDate 2023-12-06 21:08:08
*/
@Service
public class CrimedataServiceImpl extends ServiceImpl<CrimedataMapper, Crimedata>
    implements CrimedataService{

}




