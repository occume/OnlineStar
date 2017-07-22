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
> 1. [发送验证码](#verification-code)![](https://www.duliday.com/api/public/img/build-passing.svg)
> 1. [注册](#passport-reg)![](https://www.duliday.com/api/public/img/build-passing.svg)
> 1. [省列表](#province-list)![](https://www.duliday.com/api/public/img/build-passing.svg)
> 1. [市列表](#city-list)![](https://www.duliday.com/api/public/img/build-passing.svg)
1. <span id='verification-code'>发送验证码</span>![](https://www.duliday.com/api/public/img/build-passing.svg)
    ```
    POST {host}/api/auth/verification-code

    {
        "phone": "15901778405"
    }
    ```
1. <span id='passport-reg'>注册</span>![](https://www.duliday.com/api/public/img/build-passing.svg)
    ```
    POST {host}/hrz/passport/v1/reg

    {
		"phone": <string>,
		"password": <string>
	}
	
	200 OK
	
	{
	    "errCode": 0,
	    "errMessage": "OK",
	    "data": null
	}
    ```    
1. <span id='province-list'>省列表</span>![](https://www.duliday.com/api/public/img/build-passing.svg)
    ```
    GET {host}/hrz/common/provinces
    
    200 OK

    {
	    "errCode": 0,
	    "errMessage": "OK",
	    "data": [
	        {
	            "id": <int>,
	            "name": <string>
	        }
	    ]
    }
    ```
1. <span id='city-list'>市列表</span>![](https://www.duliday.com/api/public/img/build-passing.svg)
    ```
    GET {host}/hrz/common/cities/{provinceId}
    
    200 OK

    {
	    "errCode": 0,
	    "errMessage": "OK",
	    "data": [
	        {
	            "id": <int>,
	            "name": <string>
	        }
	    ]
    }
    ```
