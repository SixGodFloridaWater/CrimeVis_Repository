import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios"; 
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


const app = createApp(App)
app.config.globalProperties.$axios = axios; // 将axios挂载到原型上方便使用
app.use(ElementPlus)
app.use(router)
app.mount('#app')
