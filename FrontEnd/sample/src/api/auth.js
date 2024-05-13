// import http from '@/api/http'
import axios from 'axios'

export function Login (userid, password) {
  console.log('123')
  // return http.post('/member/login', {
  //   userid,
  //   password
  // })
  axios.post('/member/login', {
    userid,
    password
  })
}
