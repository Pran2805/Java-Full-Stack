# Java-Full-Stack

# 🔐 Auth APIs

```
POST   /api/v1/auth/register
POST   /api/v1/auth/login
POST   /api/v1/auth/refresh-token
POST   /api/v1/auth/logout
GET    /api/v1/auth/me
```

---

# 👤 User / Role Management (Admin Only)

```
GET    /api/v1/users
GET    /api/v1/users/{id}
PUT    /api/v1/users/{id}
DELETE /api/v1/users/{id}

GET    /api/v1/roles
POST   /api/v1/roles
```

---

# 🧑‍⚕️ Doctor APIs

```
POST   /api/v1/doctors
GET    /api/v1/doctors
GET    /api/v1/doctors/{id}
PUT    /api/v1/doctors/{id}
DELETE /api/v1/doctors/{id}

GET    /api/v1/doctors/specialization/{specialization}
GET    /api/v1/doctors/{id}/appointments
GET    /api/v1/doctors/{id}/availability?date=2026-02-20
```

---

# 🧑 Patient APIs

```
POST   /api/v1/patients
GET    /api/v1/patients
GET    /api/v1/patients/{id}
PUT    /api/v1/patients/{id}
DELETE /api/v1/patients/{id}

GET    /api/v1/patients/search?name=raj
GET    /api/v1/patients/{id}/appointments
GET    /api/v1/patients/{id}/prescriptions
```

---

# 📅 Appointment APIs

```
POST   /api/v1/appointments
GET    /api/v1/appointments
GET    /api/v1/appointments/{id}
PUT    /api/v1/appointments/{id}
DELETE /api/v1/appointments/{id}

GET    /api/v1/appointments/by-doctor/{doctorId}
GET    /api/v1/appointments/by-patient/{patientId}
GET    /api/v1/appointments/by-date?date=2026-02-20
PUT    /api/v1/appointments/{id}/cancel
PUT    /api/v1/appointments/{id}/reschedule
```

---

# 🏥 Department APIs

```
POST   /api/v1/departments
GET    /api/v1/departments
GET    /api/v1/departments/{id}
PUT    /api/v1/departments/{id}
DELETE /api/v1/departments/{id}

POST   /api/v1/departments/{id}/assign-doctor/{doctorId}
GET    /api/v1/departments/{id}/doctors
```

---

# 💊 Prescription APIs

```
POST   /api/v1/prescriptions
GET    /api/v1/prescriptions/{id}
GET    /api/v1/prescriptions/by-appointment/{appointmentId}
GET    /api/v1/prescriptions/by-patient/{patientId}

POST   /api/v1/prescriptions/{id}/add-medicine
DELETE /api/v1/prescriptions/{id}/remove-medicine/{medicineId}
```

---

# 💰 Billing APIs

```
POST   /api/v1/bills
GET    /api/v1/bills/{id}
GET    /api/v1/bills/by-patient/{patientId}

POST   /api/v1/bills/{id}/add-charge
PUT    /api/v1/bills/{id}/mark-paid
GET    /api/v1/bills/{id}/invoice
```

---

# 📊 Dashboard APIs (Admin)

```
GET /api/v1/dashboard/summary
GET /api/v1/dashboard/revenue?month=2&year=2026
GET /api/v1/dashboard/appointments/today
GET /api/v1/dashboard/top-doctors
```

---

# 📁 File Upload APIs (Optional but Strong)

```
POST   /api/v1/files/upload
GET    /api/v1/files/{fileId}
DELETE /api/v1/files/{fileId}
```

---

# 🔎 Audit Logs (Advanced)

```
GET /api/v1/audit-logs
GET /api/v1/audit-logs/by-user/{userId}
```


