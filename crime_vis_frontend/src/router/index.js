import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from "../views/Home/HomePage.vue"

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
            component: HomeView
        }
    ]
})
export default router