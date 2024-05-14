import http from '@/api/http'

export function Login (userId, password) {
  console.log('123')
  return http.post('/member/login', {
    userId,
    password
  })
}
