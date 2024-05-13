import http from '@/api/http'

export function Login (userid, password) {
  return http.post('/member/login', {
    userid,
    password
  })
}
