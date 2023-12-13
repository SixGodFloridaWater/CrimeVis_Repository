import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from "../views/Home/HomePage.vue"
import Gender from "@/views/gender.vue"

const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        // {
        //     path:'/',
        //     component:IndexView,
        //     redirect:'home',
        //     children:[
        //         {
        //             path:'home',
        //             component:HomeView
        //         },
        //         {
        //             path:'user',
        //             component:UserSetting
        //         }
        //     ]
        // },
        {
            path:'/',
            name:'home',
            component: Gender
        }
    ]
})
export default router