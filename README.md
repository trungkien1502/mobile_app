🧭 HƯỚNG DẪN CẤU TRÚC THƯ MỤC DỰ ÁN
Dự án được chia theo kiến trúc đa-module, giúp code dễ quản lý, dễ mở rộng, và nhiều người có thể làm song song mà không đụng nhau.
 
🏠 1. app/
→ Là module chính của toàn app (Application).
•	Chứa file Application, AndroidManifest.xml tổng.
•	Có thể chứa MainActivity, SplashActivity hoặc Navigation tổng.
•	Không đặt code nghiệp vụ hay layout chi tiết ở đây.
📂 Ví dụ:
app/
 ├─ manifests/AndroidManifest.xml
 ├─ java/.../App.java  (class Application)
 └─ res/layout/app_activity_splash.xml
 
⚙️ 2. core/
→ Chứa các thành phần dùng chung cho toàn app.
🧩 core/ui/
UI & style dùng chung:
•	BaseActivity, BaseFragment
•	Layout include (toolbar, dialog, empty view…)
•	Màu, font, style, dimens
📂 Ví dụ:
core/ui/res/layout/ui_include_toolbar.xml
core/ui/res/values/colors.xml
core/ui/java/.../BaseActivity.java
 
🌐 core/network/
Kết nối mạng:
•	Cấu hình Retrofit, OkHttp
•	Interceptor, API base
•	Module Hilt cung cấp Retrofit instance
📂 Ví dụ:
core/network/java/.../ApiClient.java
core/network/java/.../NetworkModule.java
 
🗃️ core/db/
Lưu trữ dữ liệu (Room Database):
•	AppDatabase
•	Dao, Converter chung
•	Hilt module cung cấp Room
📂 Ví dụ:
core/db/java/.../AppDatabase.java
core/db/java/.../converter/DateConverter.java
 
🧰 core/util/
Các hàm tiện ích (helper):
•	Format ngày giờ
•	Kiểm tra input
•	Log, Constants
•	Wrapper Result cho API
📂 Ví dụ:
core/util/java/.../Logger.java
core/util/java/.../Validators.java
 
🧠 3. domain/
→ Chứa logic nghiệp vụ thuần (không phụ thuộc Android).
•	Entity (model dữ liệu)
•	UseCase (luồng nghiệp vụ)
•	Repository interface
📂 Ví dụ:
domain/entity/Appointment.java
domain/usecase/BookAppointmentUseCase.java
domain/repository/AppointmentRepository.java
 
💡 4. feature/
→ Mỗi module đại diện cho một tính năng riêng biệt.
Mỗi feature có cấu trúc tương tự nhau:
feature/<tên_feature>/
 ├─ data/        → API, Repository, Local DB riêng
 ├─ domain/      → Entity + UseCase riêng (nếu có)
 ├─ ui/          → Activity, Fragment, ViewModel
 └─ res/         → layout, drawable, string riêng
📱 feature/auth/
Đăng nhập, đăng ký, OTP…
Layout: auth_activity_login.xml, auth_fragment_signup.xml
 
🩺 feature/appointment/
Toàn bộ flow Đặt lịch khám (Appointment)
Layout & logic chính cho flow tương tự UMC Care:
•	Trang chọn chuyên khoa, bác sĩ
•	Chọn ngày, giờ
•	Nhập thông tin bệnh nhân
•	Xác nhận & hoàn tất
Layout dùng prefix appt_:
appt_fragment_home.xml
appt_fragment_doctor_list.xml
appt_fragment_calendar.xml
appt_fragment_confirm.xml
appt_fragment_success.xml
 
💳 feature/payment/
Thanh toán, chọn phương thức, xác nhận giao dịch.
Prefix pay_.
 
📄 feature/records/
Hồ sơ & kết quả khám, lịch sử cuộc hẹn.
Prefix rec_.
 
🎨 Quy tắc chung cho layout & resources
Loại file	Đặt ở đâu	Quy tắc tên
Layout dùng chung	core/ui/res/layout	ui_...
Layout theo tính năng	feature/<feature>/res/layout	<prefix>_... (vd: appt_, auth_, pay_)
Màu, style, dimens chung	core/ui/res/values/	—
Drawable riêng feature	feature/<feature>/res/drawable	<prefix>_icon_...
Strings	feature/<feature>/res/values/strings.xml	<prefix>_label_...
 
🧩 Tóm tắt vai trò
Thư mục	Chức năng chính
app/	Ứng dụng chính, Application, Splash, Nav tổng
core/ui	UI, style, layout, BaseActivity dùng chung
core/network	Retrofit, OkHttp, cấu hình API
core/db	Room Database, Dao, Converter
core/util	Helper, validator, logger
domain	Entity, UseCase, Repository interface
feature/auth	Đăng nhập, đăng ký
feature/appointment	Đặt lịch khám
feature/payment	Thanh toán
feature/records	Hồ sơ, kết quả khám
 
💬 Tóm lại cho team:
“Code và layout của tính năng nào thì để trong đúng module feature đó.
Phần nào dùng chung nhiều nơi thì đưa vào core.
App chỉ làm nhiệm vụ khởi động và điều hướng.”

<img width="540" height="723" alt="image" src="https://github.com/user-attachments/assets/f29f39b7-2495-41e9-8c55-019ef46a3a3a" />
