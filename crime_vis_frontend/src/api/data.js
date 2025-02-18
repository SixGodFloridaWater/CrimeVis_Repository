//导入request.js请求工具
import request from "@/utils/request.js"

//提供调用按月份请求数据接口的函数
export const dataSelectService = (month) => {
    //借助UrlSearchParams完成传递
    const params = new URLSearchParams()    
    for(const key in month){
        params.append(key, month[key]);
    }
    return request.post('/crimedata/groupByMonth', params);
}

//提供调用请求热力图数据接口的函数
export const dataCountService = () => {
    return request.post('/crimedata/getCount');
}

//提供调用请求性别数据接口的函数
export const dataGenderService = () => {
    return request.post('/crimedata/getGender');
}
