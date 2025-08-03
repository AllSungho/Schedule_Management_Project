API 명세

# API 명세서
### 회원가입
* POST /users
* 회원가입 API
* 요청 예시:
```json
{
    "name" : "user1", 
    "email" : "user1@gmail.com", 
    "password" : "user1"
}
```

### 일정 생성
* POST /users/{userId}
* 일정 생성 API
* 요청 예시:
```json
{
    "title" : "title1", 
    "content" : "content1",
    "startTime": "", 
    "endTime": ""
}
```

### 전체 사용자 조회
* GET /users
* 전체 사용자 조회 API
* 응답 예시:
```json
{
    "name" : "user1",
    "email" : "user1@gmail.com"
}
```

### 단일 사용자 조회
* GET /users/{userId}
* 단일 사용자 조회 API
* 응답 예시:
```json
{
    "name" : "user1",
    "email" : "user1@gmail.com"
}
```

### 전체 일정 조회
* GET /users/{userId}/schedules
* 전체 일정 조회 API
* 응답 예시:
```json
{
    "title" : "title1", 
    "content" : "content1",
    "startTime": "", 
    "endTime": ""
}
```

### 단일 일정 조회
* GET /users/{userId}/schedules/{scheuduleId}
* 단일 일정 조회 API
* 응답 예시:
```json
{
    "title" : "title1", 
    "content" : "content1",
    "startTime": "", 
    "endTime": ""
}
```

### 사용자 이름 수정
* PUT /users/{userId}/names
* 사용자 이름 수정 API
* 요청 예시:
```json
{
    "name" : "name11"
}
```

### 사용자 이메일 수정
* PUT /users/{userId}/emails
* 사용자 이메일 수정 API
* 요청 예시:
```json
{
    "email" : "name11@gmail.com"
}
```

### 사용자 비밀번호 수정
* PUT /users/{userId}/passwords
* 사용자 비밀번호 수정 API
* 요청 예시:
```json
{
    "password" : "name11"
}
```

### 일정 제목 수정
* PUT /users/{userId}/schedules/{scheduleId}/titles
* 일정 제목 수정 API
* 요청 예시:
```json
{
    "title" : "title11"
}
```

### 일정 내용 수정
* PUT /users/{userId}/schedules/{scheduleId}/contents
* 일정 내용 수정 API
* 요청 예시:
```json
{
    "content" : "content11"
}
```

### 일정 날짜 수정
* PUT /users/{userId}/schedules/{scheduleId}/datetimes
* 일정 날짜 수정 API
* 요청 예시:
```json
{
    "startTime" : "", 
    "endTime" : ""
}
```

### 유저 삭제
* PUT /users/{userId}
* 유저 삭제 API

### 일정 삭제
* PUT /users/{userId}/schedules/{scheduleId}
* 일정 삭제 API

# ERD
https://www.erdcloud.com/d/hKpkdeAh2NpFLwYBk
