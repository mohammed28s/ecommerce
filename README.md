# 🚀 E-commerce

**🎯 E-commerce** is a modern full-stack web application. The backend is built with <span style="color:#6DB33F">**Java Spring Boot**</span> 🍃, providing robust RESTful APIs, while the frontend is developed using <span style="color:#DD0031">**Angular**</span> 🅰️, offering a dynamic and responsive user interface.

---

## 📋 Project Overview

**💡 Purpose**  
E-commerce provides a focused example of an online store backend and the structure you can extend into a complete storefront. The repository contains a Java Spring Boot application with core domain entities (Product, User, Cart, Order) and the Spring Boot application entrypoint. The project is intended to be a small, clear foundation for learning or bootstrapping a larger e-commerce project — you can quickly add controllers, services, and a frontend UI (Angular) to build a working application.

Repository highlights (from the current codebase):

Backend main class: com.simple.ecommerce.website.SimpleEcommerceWebsiteApplication
File: src/main/java/com/simple/ecommerce/website/SimpleEcommerceWebsiteApplication.java
Domain entities found under:
src/main/java/com/simple/ecommerce/website/Entity/Product.java — Product entity (id, name, price, description)
src/main/java/com/simple/ecommerce/website/Entity/User.java — User entity (id, username, password — should be hashed)
src/main/java/com/simple/ecommerce/website/Entity/Cart.java — Cart (id, user_id, product_id, quantity)
src/main/java/com/simple/ecommerce/website/Entity/Order.java — Order (id, user_id, total, status)


This README covers architecture, setup, usage, development workflow, and deployment tips to get you started quickly and safely.

---

## 🏗️ Architecture Overview

| Layer | Technology Stack | Emoji |
|-------|------------------|--------|
| **Backend** | Java Spring Boot (Maven/Gradle), Spring Security, Spring Data JPA (Hibernate) | 🍃 |
| **Frontend** | Angular (TypeScript), RxJS, Angular Router, Angular CLI | 🅰️ |
| **Database** | PostgreSQL 🐘 (recommended) / MySQL 🐬 / H2 (dev) | 🗄️ |
| **Build Tools** | Maven or Gradle (backend), npm & Angular CLI (frontend) | 🔨 |
| **Containerization** | Docker & docker-compose (optional) | 🐳 |

---

## ✨ Features

### 🍃 Backend Features
- 🌐 RESTful API with JSON serialization and HATEOAS-friendly endpoints
- 🔒 JWT-based authentication & role-based authorization (Spring Security)
- 💾 Persistent storage using Spring Data JPA + Hibernate
- ✅ Input validation with Hibernate Validator and global exception handling
- 📖 Swagger / OpenAPI auto-generated API docs (springdoc)
- ♻️ DTO mapping (MapStruct or ModelMapper) and layered service architecture

### 🅰️ Frontend Features
- 📱 Mobile-first responsive UI (works across devices)
- 🧩 Component-based architecture and lazy-loaded modules
- 🗺️ Client routing with route guards for protected routes
- ⚡ Reactive data handling with RxJS and HTTP interceptors for auth
- 📝 Reactive & template-driven form handling + validation
- 🔁 Optional state management (NgRx or lightweight service patterns)

---

## ⚡ Quick Start

### 🚨 Prerequisites
Ensure these are installed on your machine:

| Software | Minimum Version | Emoji |
|----------|-----------------|--------|
| Java JDK | 17+ | ☕ |
| Node.js | 18.x+ (includes npm) | 📦 |
| Angular CLI | 15.x+ | 🛠️ |
| Maven or Gradle | Maven 3.6+ or Gradle 7+ | 🏗️ |
| Database | PostgreSQL 14+ (or MySQL 8.0) | 🗄️ |
| Docker (optional) | 20.x+ & docker-compose | 🐳 |
| IDE | IntelliJ IDEA, VS Code, or Eclipse | 💻 |

---

## 🔧 Installation & Setup

This repository is organized as two main folders:

- /backend — Spring Boot app
- /frontend — Angular app

### 🍃 Backend (Spring Boot) — Setup

1. Clone the repository and navigate to backend:
```bash
git clone https://github.com/your-username/your-repo.git
cd your-repo/backend
```

2. Copy example configuration and update secrets:
```bash
cp src/main/resources/application.yml.example src/main/resources/application.yml
# or
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

3. Edit `application.yml` (or `.properties`) — example snippet:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/yourdb
    username: youruser
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
app:
  jwt:
    secret: replace-with-a-secure-secret
    expiration-ms: 3600000
```

4. (Optional) Create the DB (Postgres example):
```sql
CREATE DATABASE yourdb;
CREATE USER youruser WITH PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE yourdb TO youruser;
```

5. Build and run (Maven wrapper):
```bash
./mvnw clean package
./mvnw spring-boot:run
# or
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

Default backend URL: http://localhost:8080

---

### 🅰️ Frontend (Angular) — Setup

1. Open a new terminal, go to frontend:
```bash
cd ../frontend
```

2. Install dependencies:
```bash
npm install
```

3. Configure environment files:
- Edit `src/environments/environment.ts` (dev) and `src/environments/environment.prod.ts` (prod):
```ts
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api',
};
```

4. Run dev server:
```bash
ng serve --open
```
Default frontend URL: http://localhost:4200

---

### 🔁 Run Backend + Frontend Together (Dev)
Run each in its own terminal:

Terminal 1 (backend):
```bash
cd backend
./mvnw spring-boot:run
```

Terminal 2 (frontend):
```bash
cd frontend
ng serve
```

Optionally add an npm script or use `concurrently` / `npm-run-all` to start both together.

---

## 🧭 Usage

Typical flow:

1. Register via frontend or API: POST /api/auth/register  
2. Login: POST /api/auth/login → receive JWT token  
3. Include token in requests:
```
Authorization: Bearer <jwt-token>
```

Example login (curl):
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password"}'
```

Example protected request:
```bash
curl http://localhost:8080/api/users \
  -H "Authorization: Bearer <your-jwt-token>"
```

Angular auth example (service):
```ts
// auth.service.ts (simplified)
login(creds: {username: string, password: string}) {
  return this.http.post<{token:string}>(`${environment.apiUrl}/auth/login`, creds)
    .pipe(tap(res => localStorage.setItem('token', res.token)));
}
```

---

## 🏗️ Building for Production

Backend (build jar):
```bash
cd backend
./mvnw clean package -DskipTests
# resulting: target/backend-*.jar
```

Frontend (prod build):
```bash
cd frontend
ng build --configuration production
# outputs: dist/frontend/
```

Serve frontend via static resources in backend or via Nginx / CDN. Example: copy `dist/frontend` into backend `src/main/resources/static` or set up reverse proxy.

---

## 🐳 Docker (Optional)

Example `docker-compose.yml` (Postgres + backend + frontend):
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:14
    environment:
      POSTGRES_DB: yourdb
      POSTGRES_USER: youruser
      POSTGRES_PASSWORD: yourpassword
    ports:
      - "5432:5432"

  backend:
    build: ./backend
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/yourdb
      SPRING_DATASOURCE_USERNAME: youruser
      SPRING_DATASOURCE_PASSWORD: yourpassword
    depends_on:
      - postgres

  frontend:
    build:
      context: ./frontend
      dockerfile: Dockerfile
    ports:
      - "4200:80"
    depends_on:
      - backend
```

Start:
```bash
docker-compose up --build
```

---

## ✅ Testing

Backend:
```bash
cd backend
./mvnw test
```

Frontend:
```bash
cd frontend
npm test
npm run lint
```

Add integration tests for critical flows (auth, data CRUD) and consider component / e2e tests for the frontend (Protractor or Cypress).

---

## 📚 API Documentation

If Swagger/OpenAPI is enabled:
- Swagger UI: http://localhost:8080/swagger-ui.html or /swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

---

## 🔐 Environment / Configuration Notes

Important env variables (examples — adapt names):
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- APP_JWT_SECRET (or app.jwt.secret)
- APP_JWT_EXPIRATION_MS
- FRONTEND_API_URL (for frontend runtime config)

Store secrets securely and never commit them to git. Use .env files, CI/CD secret stores, or cloud secret managers.

---

## 📁 Suggested Folder Structure

- /backend
  - src/main/java/... (application, controllers, services, repositories)
  - src/main/resources/application.yml
- /frontend
  - src/app/... (modules, components, services)
  - src/environments/*.ts
- docker-compose.yml
- README.md

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch: git checkout -b feat/your-feature
3. Add tests & documentation
4. Open a Pull Request describing your changes

Please follow existing code style, write tests for new behavior, and update documentation.

---

## 🛠️ Troubleshooting

- CORS errors: Enable CORS for http://localhost:4200 in backend or configure a proxy in Angular.
- Database connection failures: Verify DB URL, user, password, and that DB is running.
- JWT issues: Confirm secret and token expiration; ensure token is sent in Authorization header.
- Port conflicts: Ensure 8080 and 4200 ports are free or change application ports.

---

## 🛣️ Roadmap / Ideas
- Refresh tokens & secure refresh flow
- Role & permission management UI
- File uploads (S3/GCS integration)
- Rate limiting, API throttling, and additional security hardening
- CI/CD pipeline (GitHub Actions) with automated builds and tests
- Automated container image builds and deployments

---

## 📄 License

MIT © mohammed28s

---

## ✉️ Contact

Created by mohammed28s — open issues or PRs for questions, bugs, or suggestions.

---


