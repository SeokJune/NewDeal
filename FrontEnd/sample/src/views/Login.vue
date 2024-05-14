<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <div class="card">
        <div class="card-body">
            <div class="form-group">
                <label for="userid">아이디</label>
                <input type="text" class="form-control" id="userid" v-model="userid">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" id="password" v-model="password">
            </div>
            <div class="card-footer text-right">
                <button type="button" class="btn btn-dark" @click="login">
                    로그인
                </button>
                <button type="button" class="btn btn-dark" @click="login2">
                    로그인2
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    async login () {
      try {
        const response = await fetch('/member/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            userId: this.userid,
            password: this.password
          })
        })
        if (!response.ok) {
          const errorMessage = await response.text()
          throw new Error(errorMessage)
        }
        // 로그인 성공 시 리다이렉트 또는 다른 동작 수행
        console.log('sssss')
      } catch (error) {
        console.error('로그인 오류:', error)
        // 에러 처리 로직 추가 (예: 사용자에게 알림)
      }
    },
    async login2 () {
      axios
        .get('/member/test')
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    }
  }
}
</script>
