import { createRouter, createWebHistory } from 'vue-router'

import Login from '@/views/Login'
import Board from '@/views/Board'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/board',
    name: 'board',
    component: Board
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
