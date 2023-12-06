//定制请求的实例

import axios from 'axios';
import { ElMessage } from 'element-plus'
// import { useTokenStore } from '@/stores/token';

//定义一个变量,记录公共的前缀  ,  baseURL
const baseURL = '/api';
const instance = axios.create({baseURL})

// //添加请求拦截器
// instance.interceptors.response.use(
//     (config)=>{
//         //请求前的回调
//         //添加token
//         const tokenStore = useTokenStore()
//         //判断有没有token
//         if(tokenStore.token){
//             config.headers.Authorization = tokenStore.token
//         }
//         return config
//     },
//     (err)=>{
//         //请求错误的回调
//         Promise.reject(err)
//     }

// )

//添加响应拦截器
instance.interceptors.response.use(
    result=>{
        //判断业务状态码
        if(result.data.code === 0){
            return result.data;
        }
        //操作失败
        // alert(result.data.msg?result.data.msg:"服务异常")
        ElMessage.error(result.data.msg?result.data.msg:"服务异常")
        //异步操作状态转换为失败
        return Promise.reject(result.data)
    },
    err=>{
        return Promise.reject(err);//异步的状态转化成失败的状态
    }
)

export default instance;