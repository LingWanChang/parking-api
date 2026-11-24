# 停車位管理 API

以 Spring Boot 開發的簡易 REST API，模擬停車系統的車位管理（新增、查詢、修改、刪除）。
這是我學習 Spring Boot 的練習專案。

## 使用技術
- Java 17、Spring Boot 4.1.2
- MyBatis（註解式 SQL）
- MySQL 8
- Maven

## 架構
Controller → Service → Repository 三層架構，
Repository 以 MyBatis Mapper 介面實作，Service 與 Controller 不依賴資料來源的細節。

## API
| 方法 | 路徑 | 說明 |
|---|---|---|
| GET | /api/spots | 查詢全部車位 |
| GET | /api/spots/{id} | 查詢單一車位 |
| POST | /api/spots | 新增車位 |
| PUT | /api/spots/{id} | 修改車位 |
| DELETE | /api/spots/{id} | 刪除車位 |

## 輸入驗證與錯誤處理
- 以 @Valid 搭配 @NotBlank、@Size、@Pattern 驗證輸入，不合格回傳 400。
- 找不到資料回傳 404。
- 以 @RestControllerAdvice 集中處理例外，回傳一致的錯誤格式。

## 如何執行
1. 執行 docs/schema.sql 建立資料庫與資料表。
2. 設定環境變數 DB_PASSWORD（及選填的 DB_USER）。
3. 執行 ParkingApplication，服務位於 http://localhost:8080。