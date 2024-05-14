import http from '@/api/http'

export function Login (userid, password) {
  console.log('123')
  return http.post('/member/login', {
    userid,
    password
  })
}
