# Instagram Clone — Paging3 + MVVM Demo

An Android app demonstrating advanced pagination patterns with Jetpack Paging 3, backed by the Unsplash photo API.

## 💡 What This Demonstrates

- **Paging3** with `RemoteMediator` for network + local database pagination
- **PagingSource** for pure network paging
- **MVVM Clean Architecture** — separation of data, domain, and presentation layers
- **Jetpack Compose** UI with lazy loading

## 🛠 Tech Stack

| Technology | Purpose |
|-----------|---------|
| Kotlin | Primary language |
| Paging 3 | Pagination library |
| RemoteMediator | Network + DB pagination |
| Room | Local cache |
| Retrofit | Network layer |
| Hilt | Dependency injection |
| Jetpack Compose | UI |
| MVVM Clean Architecture | App architecture |

## 🔑 Unsplash API Setup

1. Register at [unsplash.com/developers](https://unsplash.com/developers)
2. Create a new app and copy your **Access Key**
3. Add to `local.properties`:
   ```
   UNSPLASH_ACCESS_KEY=your_key_here
   ```

## 🏗 Architecture Overview

```
UI (Compose) ← ViewModel ← Repository ← RemoteMediator + PagingSource
                                       ↕
                                   Room DB / Retrofit
```

## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/santhoshj001/Instagram-Clone.git
   ```
2. Add your Unsplash API key to `local.properties`
3. Open in Android Studio and run

## 📄 License

MIT — see [LICENSE](LICENSE)
