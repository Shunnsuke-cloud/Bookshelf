# BookShelf アプリ

Java + Vaadin で作成した本の管理アプリです。  
書籍のタイトル、著者、購入日を入力し、一覧表示・削除などの操作ができます。

## 🔧 使用技術

- Java 17
- Vaadin Flow（Vaadin Core）
- Maven
- Git / GitHub

## 🖼️ 主な機能

- 本の登録（タイトル、著者、購入日）
- 登録された本の一覧表示
- 本の削除機能（ボタンで削除）
- レスポンシブ対応のUI（Vaadin使用）

## 🏃‍♂️ 起動方法（ローカル環境）

```bash
cd oh-deer-handler
./mvnw spring-boot:run

※ Windows の場合は mvnw.cmd spring-boot:run

起動後に以下URLを開きます：
http://localhost:8080
