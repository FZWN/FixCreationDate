# 🎞️ MediaChronoFixer

A macOS Java tool that fixes file creation times and organizes your media by date — perfect for editors like Final Cut Pro.

---

## 📘 English

### 📌 What is this?

A macOS utility written in Java that repairs incorrect file creation times (commonly altered during file transfers) and organizes media files into folders based on their modification time (i.e. shooting date).

🎯 **Ideal for Final Cut Pro users**, where creation time affects media sorting and timeline accuracy.

### ✨ Features

- 🔁 Syncs creation time with the last modified time
- 🗂️ Automatically organizes files into folders like `2025-03-13`
- 🎥 Supports **all file types**, not just `.mp4`
- 🍎 Uses **macOS Finder** (AppleScript) to preserve metadata correctly
- 🧹 Deletes original files after processing (⚠️ see warning)

### ⚠️ Warning

This tool will **permanently delete original files** after processing.  
Please **make backups first** or run tests with dummy files!

### 💡 Why use this?

- 🧳 Organize media from SD cards, drones, or cameras by shooting time
- 🧭 Improve media sorting accuracy in Final Cut Pro
- 🖼️ "Date Created" in Finder becomes meaningful again
- 🗃️ Helps maintain a clean and navigable folder structure

### 🛠 Requirements

- Java 11 or newer
- macOS (Finder + AppleScript support required)

### 🚀 How to Use

1. Clone or download this project
2. Open in IntelliJ IDEA or build a `.jar`
3. Modify the `sourceFolder` and `targetRoot` paths in the code
4. Run the program
5. Files will be copied, cleaned, sorted by date, and the originals deleted

---

## 📙 中文说明

### 📌 这是什么？

这是一个基于 Java 开发的 macOS 工具，可以修复文件错误的**创建时间**（复制过程中常常被改成当前时间），并将媒体文件根据**修改时间（拍摄时间）**自动分类整理到日期文件夹中。

🎬 **特别适合 Final Cut Pro 用户**，避免素材顺序混乱。

### ✨ 功能特点

- 🔁 将创建时间重置为修改时间
- 🗂️ 自动将文件归类到类似 `2025-03-13` 的日期文件夹中
- 🎥 支持所有类型的文件（不仅限于 `.mp4`）
- 🍎 使用 macOS 的 Finder（通过 AppleScript）复制文件，保留原始元数据
- 🧹 处理完成后会自动删除原始文件（⚠️ 请留意警告）

### ⚠️ 警告

本工具会**删除原始文件**。  
请**提前备份**，建议先用测试文件验证流程。

### 💡 优势

- 🧳 整理相机/手机/无人机素材更高效
- 🎞 Final Cut Pro 可以正确按拍摄时间导入素材
- 🖼️ Finder 显示的“创建时间”准确反映拍摄日期
- 🗃️ 批量归类海量文件，清晰管理素材库

### 🛠 系统要求

- Java 11 或更高版本
- macOS 系统（需支持 Finder 和 AppleScript）

### 🚀 使用方法

1. 克隆或下载项目
2. 用 IntelliJ IDEA 打开或构建 `.jar`
3. 修改代码中的 `sourceFolder` 与 `targetRoot` 路径
4. 运行程序
5. 文件会被分类整理，并删除原始文件

---

## 📂 示例

假设源目录是一个 SD 卡备份目录，结构如下：

