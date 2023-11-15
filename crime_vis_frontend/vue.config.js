const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false, //是否开启eslint保存检测
  devServer: {
    open: false, //配置自动启动浏览器
    host: "localhost",
    port: 8088,
    // 配置跨域-请求后端的接口
    proxy:{
      '/api':{//获取路径中包含了api请求
        target:"http://localhost:8080", //后台服务所在端口
        changeOrigin:true,//修改源
        pathRewrite: {//api替换为''
              "^/api": ""
            }
      }
    },
    client: {
      overlay: false,
    },
  },
})
