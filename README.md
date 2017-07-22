# HRZ API
变量  

所有接口调用时请添加如下http协议头
```http
Duliday-Agent: <agent>
Duliday-Agent-Version: 0x010000
```
```
agent {
    1: web.mobile.c
    2: android.c
    3: ios.c
    4: web.b
    5: android.b
    6: ios.b
}
```

> 1. [发送验证码](#verification-code) ![]

1. <span id='verification-code'>发送验证码</span> ![]
    ```
    POST {host}/api/auth/verification-code

    {
        "phone": "15901778405"
    }
    ```
1. <span id='account-create'>创建账户</span> ![]
    ```
    POST {host}/api/auth/sign-up

    {
        "phone": "15901778405",
        "passwd": "123456",
        "verification_code": "123456"
    }
    ```
    ```
    passwd: 密码(优先)
    verification_code: 验证码
    ```