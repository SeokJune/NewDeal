// const { defineConfig } = require('@vue/cli-service')

// module.exports = defineConfig({
//   transpileDependencies: true,
//   lintOnSave: false,
//   devServer: {
//     client: {
//       overlay: false
//     },
//     port: 8081,
//     // Proxy 설정
//     proxy: {
//       // 경로가 "/api" 로 시작하는 요청을 대상으로 proxy 설정
//       '/': {
//         target: 'http://localhost:8080/',
//         changeOrigin: true,
//         // 요청 경로에서 '/api' 제거
//         pathRewrite: { '^/api': '' },
//         ws: false
//       }
//     }
//   }
// })

const target = 'http://localhost:8080'
module.exports = {
  devServer: {
    port: 8080,
    proxy: {
      '/': {
        target,
        changeOrigin: true,
        pathRewrite: { '^/api': '' },
        ws: false
      }
    }
  }
}
