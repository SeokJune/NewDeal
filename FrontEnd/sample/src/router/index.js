import { createRouter, createWebHistory } from 'vue-router'

import Login from '@/views/Login'
import Board from '@/views/Board'

const routes = [
  {
    path: '/login',
    name: 'login',
    componet: Login
  },
  {
    path: '/board',
    name: 'board',
    componet: Board
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
