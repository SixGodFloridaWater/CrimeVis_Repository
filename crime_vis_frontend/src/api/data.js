//导入request.js请求工具
import request from "@/utils/request.js"

//提供调用请求数据接口的函数
export const dataSelectService = (selectInfo) => {
    //借助UrlSearchParams完成传递
    const params = new URLSearchParams()    
    for(const key in selectInfo){
        params.append(key, selectInfo[key]);
    }
    return request.post('/select', params);
}