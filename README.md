# 📊 Real-time Product Analytics

**Phân tích lượt xem & tìm kiếm sản phẩm theo thời gian thực**

---

## 🚀 Giới thiệu

**Real-time Product Analytics** là một hệ thống web cho phép **phân tích, thống kê và hiển thị dữ liệu hành vi người dùng (xem, tìm kiếm sản phẩm)** theo **thời gian thực**.  
Dự án áp dụng **Apache Kafka** để xử lý stream sự kiện, **Redis** để lưu trữ tạm thời và **WebSocket + Angular** để cập nhật dữ liệu **realtime** trực quan trên giao diện.

---

## 🎯 Mục tiêu dự án

- Thu thập hành vi người dùng khi truy cập hoặc tìm kiếm sản phẩm.  
- Phân tích và hiển thị thống kê real-time trên dashboard.  
- Gợi ý sản phẩm phổ biến và từ khóa thịnh hành.  
- Lưu dữ liệu định kỳ vào MySQL để phục vụ phân tích dài hạn.  
- Cung cấp tính năng tìm kiếm nâng cao qua **Elasticsearch**.

---

## 🧩 Kiến trúc tổng thể

### 🏗️ Kiến trúc tổng thể

```plaintext
┌────────────────────┐
│        👤 User      │
└─────────┬───────────┘
          │ 1️⃣ Xem / Tìm kiếm sản phẩm
          ▼
┌────────────────────┐
│ 💻 Angular Frontend │
│ - Gửi event qua API │
│ - Nhận realtime data │
│ - Hiển thị Dashboard │
└─────────┬───────────┘
          │ REST API
          ▼
┌────────────────────────────┐
│ ⚙️ Spring Boot Backend      │
│ - Nhận event từ client      │
│ - Gửi vào Kafka (Producer)  │
│ - Cung cấp API cho Angular  │
│ - Gửi realtime qua WebSocket│
└─────────┬───────────┬──────┘
          │           │
          │           │ WebSocket (Realtime)
          ▼           │
┌──────────────────────────┐
│ 📨 Apache Kafka           │
│ - Nhận luồng event (stream)│
│ - Xử lý bất đồng bộ       │
└──────┬───────────────────┘
       │
       ▼
┌──────────────────────────────┐
│ 🔄 Kafka Consumer (Spring)    │
│ - Đọc event từ Kafka         │
│ - Ghi nhận thống kê realtime │
│   vào Redis                  │
│ - Gửi data tới WebSocket     │
└──────────┬───────────────────┘
           │
           ▼
┌────────────────────────────┐
│ ⚡ Redis (Cache realtime)  │
│ - Đếm lượt xem / tìm kiếm │
│ - TTL session user         │
│ - Lưu dữ liệu tạm          │
└──────────┬────────────────┘
           │
           │ Định kỳ (Scheduler)
           ▼
┌────────────────────────────┐
│ 🗄️ MySQL (Database chính)   │
│ - Lưu thống kê dài hạn     │
│ - Dữ liệu sản phẩm, user   │
└──────────┬────────────────┘
           │
           ▼
┌────────────────────────────┐
│ 🔍 Elasticsearch           │
│ - Lưu log tìm kiếm         │
│ - Hỗ trợ autocomplete,     │
│   search nâng cao, trend   │
└────────────────────────────┘


---

## ⚙️ Công nghệ sử dụng

| Thành phần | Công nghệ |
|-------------|------------|
| **Backend** | Spring Boot (Java 17) |
| **Frontend** | Angular 19 |
| **Message Queue** | Apache Kafka |
| **Cache / Realtime Store** | Redis |
| **Database** | MySQL |
| **Search Engine** | Elasticsearch |
| **Realtime Communication** | WebSocket |
| **Build Tool** | Maven |
| **Deployment** | Local / Server VM |

---

## 📦 Tính năng chính

### 🧠 Chức năng cốt lõi (Bắt buộc)
- **Gửi sự kiện xem / tìm kiếm sản phẩm** → Kafka Topic.  
- **Kafka Consumer xử lý event** → Ghi nhận lượt xem / tìm kiếm trong Redis.  
- **Dashboard realtime**: Angular nhận dữ liệu qua WebSocket và cập nhật biểu đồ tức thì.  
- **Chống trùng session**: 1 user xem lại trong 1h không tăng lượt xem.  
- **Lưu dữ liệu định kỳ (Scheduler)**: Cứ 12h tổng hợp từ Redis sang MySQL để phân tích lâu dài.  
- **Xem chi tiết sản phẩm** (frontend).  

### ⚡ Chức năng nâng cao
- **Realtime analytics**:
  - Top sản phẩm được xem nhiều nhất (phút/giờ/ngày).
  - Tổng lượt tìm kiếm.
  - Số người dùng đang hoạt động.
  - Lọc thống kê theo thời gian (5 phút, 1 giờ, 24 giờ).
- **Elasticsearch integration**:
  - Gợi ý từ khóa (autocomplete).
  - Phân tích xu hướng tìm kiếm tăng đột biến.
  - Tìm kiếm nâng cao theo tên, mô tả, danh mục.
  - Dự đoán sản phẩm “hot” sắp tới.
- **User insight**:
  - Đếm session online.
  - Xem lịch sử hành vi người dùng.

---

## 🔄 Quy trình hoạt động

### I. Khi người dùng truy cập / tìm kiếm sản phẩm:
1. **Admin nhập sản phẩm** → lưu vào **MySQL** và **Elasticsearch**.  
2. **User xem / tìm kiếm** → Spring Boot gửi **event** (`productId`, `sessionId`, `timestamp`, `actionType`) → **Kafka Topic**.  
3. **Kafka Consumer**:
   - Xử lý và ghi nhận dữ liệu vào **Redis**.  
   - Log tìm kiếm vào **Elasticsearch**.  
   - Gửi dữ liệu realtime tới **Angular** qua **WebSocket**.  
4. **Angular Dashboard** hiển thị dữ liệu realtime (biểu đồ, top sản phẩm...).  
5. **Job Scheduler** chạy mỗi 5 phút:
   - Lấy dữ liệu Redis (viewCount, searchCount).  
   - Lưu vào MySQL.  
   - Reset Redis để tiếp tục thống kê mới.

---

## 🗓️ Kế hoạch thực hiện (3 tuần)

### ✅ Tuần 1: Khởi tạo & cơ bản
- Phân tích yêu cầu, thiết kế database.  
- Dựng project Spring Boot + Angular.  
- Tạo form xem / tìm sản phẩm, API gửi event Kafka.

### ⚙️ Tuần 2: Realtime backend
- Xây Kafka Consumer.  
- Tích hợp Redis để đếm realtime.  
- Thiết lập WebSocket đẩy dữ liệu realtime lên Angular dashboard.

### 📊 Tuần 3: Hoàn thiện & demo
- Viết Scheduler lưu dữ liệu Redis → MySQL.  
- Tích hợp Elasticsearch (search, autocomplete, trend).  
- Xây dashboard hiển thị biểu đồ & top trending.  
- Viết báo cáo & demo hoàn chỉnh.

---

## 📈 Giao diện dự kiến

- **Dashboard realtime**:  
  - Biểu đồ lượt xem sản phẩm.  
  - Top 10 sản phẩm hot nhất.  
  - Từ khóa tìm kiếm phổ biến.  
  - Số người dùng đang online.  

- **Trang chi tiết sản phẩm**:  
  - Hiển thị thông tin sản phẩm, hình ảnh, mô tả, lượt xem realtime.

---

## 🔧 Cấu trúc thư mục (đề xuất)

real-time-product-analytics/
│
├── backend/
│   ├── src/main/java/com/example/realtime/
│   │   ├── controller/      # Xử lý request từ client (REST API)
│   │   ├── service/         # Chứa business logic
│   │   ├── kafka/           # Producer & Consumer xử lý event Kafka
│   │   ├── config/          # Cấu hình Redis, Kafka, WebSocket,...
│   │   ├── model/           # Entity & DTO
│   │   └── scheduler/       # Job định kỳ lưu dữ liệu Redis → MySQL
│   └── pom.xml              # File cấu hình Maven
│
├── frontend/
│   ├── src/app/
│   │   ├── components/      # Component hiển thị (chart, table,...)
│   │   ├── services/        # Giao tiếp API & WebSocket
│   │   └── pages/           # Trang chính: Dashboard, Product Detail,...
│   └── angular.json         # Cấu hình Angular
│
└── README.md                # Tài liệu mô tả dự án



---

## 📚 Một số kỹ thuật nổi bật

- **Kafka Streams / Consumer Group** để xử lý event song song.  
- **Redis Hash & SortedSet** để đếm lượt xem, thống kê top nhanh chóng.  
- **WebSocket (Socket.IO / STOMP)** để cập nhật dữ liệu tức thì trên dashboard.  
- **Scheduler (Spring @Scheduled)** để lưu định kỳ vào MySQL.  
- **Elasticsearch** để hỗ trợ gợi ý từ khóa và tìm kiếm nâng cao.  

---

## 🧠 Kết quả mong đợi

- Hệ thống realtime hoạt động ổn định.  
- Dashboard hiển thị top sản phẩm, từ khóa, lượt xem chính xác.  
- Dữ liệu được lưu định kỳ phục vụ báo cáo dài hạn.  
- Cải thiện hiệu suất phân tích và trải nghiệm người dùng.

---

## 🏁 Demo (dự kiến)
> http://localhost:4200/dashboard  
> http://localhost:8080/product
> WebSocket: `ws://localhost:8099`

---

> _“Phân tích thời gian thực không chỉ là số liệu – mà là hiểu rõ hành vi người dùng ngay khi nó diễn ra.”_

---

© 2025 - Real-time Product Analytics Team
