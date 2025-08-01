# API 명세서

| 기능       | 메서드  | URL                   | 요청 데이터                    | 응답 데이터                                             | 설명             |
|------------|---------|-----------------------|-------------------------------|--------------------------------------------------------|------------------|
| 일정 생성    | POST    | `/calenders`      | `content`, `writer`, `password` | `id`, `content`, `createdAt`, `modifiedAt`             | 일정 등록          |
| 전체 일정 조회 | GET     | `/calenders`      | `writer` (Optional)             | `[id, content, writer, createdAt, modifiedAt]` 리스트  | 작성자 필터링 가능    |
| 단일 일정 조회 | GET     | `/calenders/{id}` | 없음                          | `id`, `content`, `writer`, `createdAt`, `modifiedAt`   | ID로 일정 조회      |
| 일정 수정    | PUT     | `/calenders/{id}` | `content`, `password`          | `id`, `content`, `createdAt`, `modifiedAt`             | 비밀번호 검증 후 수정  |
| 일정 삭제    | DELETE  | `/calenders/{id}` | `id`                    | 성공 메시지                                             | 비밀번호 검증 후 삭제  |

---
# 예시
<img width="1436" height="847" alt="image" src="https://github.com/user-attachments/assets/60bfeb4f-250e-4594-ad7f-7bd088e46136" />


---

# ERD (Calender 테이블 구조)


<img width="327" height="235" alt="image" src="https://github.com/user-attachments/assets/56aad4ed-64be-4cc5-8fee-14516dbb4e0d" />




