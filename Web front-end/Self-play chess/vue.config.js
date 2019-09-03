module.exports = {
        devServer: {
            proxy: {
                '/mock': {
                    target: 'http://localhost:3005', // 需要请求的地址        
                    changeOrigin: true, // 是否跨域       
                    pathRewrite: {
                        '^/mock': '/' // 替换target中的请求地址,例如请求的时候把'/login'换成'/mock/login'     
                    }
                }

                }
            }
        }