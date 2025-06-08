# MediaChronoFixer

## English

### What is this?

A macOS utility written in Java that repairs incorrect file creation times (usually messed up during file transfers) and organizes media files based on their actual modification time (like shooting date).

Especially useful for Final Cut Pro users, where file creation time affects timeline and import sorting.

### Features

- Syncs file creation time with last modified time
- Sorts files into folders like `2025-03-13` based on their modification time
- Supports all file types (not just `.mp4`)
- Uses macOS Finder (via AppleScript) to preserve metadata correctly
- Automatically deletes original files after processing (Warning below)

### Warning

This tool will **delete original files** after successful copy.  
Please back up your data and test first if unsure.

### Benefits

- Helps organize footage from SD cards, drones, or cameras
- Final Cut Pro can sort footage by real shooting time
- Finder and other editors show correct "Date Created"
- Makes large media archives easier to navigate by date

### Requirements

- Java 11+
- macOS (AppleScript + Finder required)

### How to Use

1. Clone or download this project.
2. Open in IntelliJ IDEA or build a JAR.
3. Modify the `sourceFolder` and `targetRoot` in the code.
4. Run the app.
5. All files will be moved and sorted by date into subfolders.

---

## 中文说明

### 这是什么？

这是一个 Java 写的 macOS 工具，用于修复文件错误的创建时间（例如从 SD 卡或移动硬盘复制文件时经常会变成复制时间），并根据文件的实际修改时间（通常是拍摄时间）对媒体文件分类整理。

特别适合 Final Cut Pro 用户，避免导入时顺序混乱。

### 功能特点

- 将文件的创建时间同步为修改时间
- 自动将文件整理进以日期命名的子文件夹，例如 `2025-03-13`
- 支持所有类型的文件（不仅限于 .mp4）
- 使用 macOS Finder + AppleScript 保留元数据（包括创建时间）
- 成功复制后会删除原始文件（请看警告）

### 警告

本工具会在处理成功后**删除原始文件**。  
请务必做好备份或先在测试文件上试运行。

### 使用优势

- 整理相机、SD 卡、大量素材更加高效
- Final Cut Pro 能识别拍摄时间并按顺序导入
- Finder 中显示的创建时间更准确
- 支持海量照片视频按时间归档与管理

### 系统要求

- Java 11 或以上
- macOS 系统（依赖 AppleScript + Finder）

### 使用方法

1. 克隆或下载本项目
2. 用 IntelliJ IDEA 打开或构建 JAR 文件
3. 修改源码中的 `sourceFolder` 与 `targetRoot` 路径
4. 运行程序
5. 文件将被移动并根据修改时间自动归类进日期子文件夹
