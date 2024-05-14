const target = 'http://localhost:8080'
module.exports = {
  devServer: {
    port: 8080,
    proxy: {
      '^/': {
        target,
        changeOrigin: true
      }
    }
  }
}