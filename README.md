# FixCreationDate

📂 VideoTimestampFixer
ENGLISH | 🇬🇧
🧭 What is this?
A macOS utility written in Java that repairs incorrect file creation times (typically messed up when copying/importing files), and organizes media files by actual modified time (e.g., shooting date).

Especially useful for Final Cut Pro users, where creation time affects file sorting and import logic.

✅ Features
Aligns file creation time with last modified time

Organizes files into folders like: 2025-03-13

Works with all file types, not just .mp4

Uses macOS Finder + AppleScript to preserve metadata

Deletes original files after processing ⚠️ (see warning)

⚠️ Warning
⚠️ This tool will DELETE original files after successful copy.
Make sure to back up your data or test on sample files first.

💡 Benefits
Perfect for organizing raw media from cameras or SD cards

Helps Final Cut Pro read correct timeline order

Makes large batches of imported videos/photos searchable by date

Avoids Finder showing misleading "Date Created" values

🛠 How to Use
Clone/download the project.

Open in IntelliJ or build to .jar.

Modify the sourceDir and targetRoot in VideoTimestampFixer.java.

Run the app.

Done!

🧱 Requirements
Java 11+

macOS only (uses AppleScript/Finder)

中文说明 | 🇨🇳
🧭 这是什么？
这是一个专为 macOS 用户开发的 Java 工具，用于修复文件创建时间错误（例如从 SD 卡或其他设备复制文件时常出现的“创建时间=复制时间”问题），并根据修改时间（通常是拍摄时间）对文件进行归类整理。

特别适合使用 Final Cut Pro 的视频编辑者。

✅ 功能特点
将文件的 创建时间 设置为其 修改时间

按照日期（如 2025-03-13）将文件自动分类到子文件夹中

支持所有类型的文件，不仅限于 .mp4

使用 macOS 的 Finder + AppleScript 保留元数据

处理完成后会自动 删除原始文件 ⚠️（请提前备份）

⚠️ 注意
⚠️ 程序在复制成功后会删除原始文件。
请先测试并确认逻辑无误，或做好备份后再批量处理重要素材。

💡 使用优势
更好地管理从 SD 卡、相机导入的大量素材

Final Cut Pro 能正确识别“拍摄时间”，自动排序

Finder 中的“创建时间”不再混乱

对照片、视频进行日期归类，方便归档和搜索

🛠 如何使用
克隆或下载本项目。

用 IntelliJ 打开项目或打包成 .jar。

打开 VideoTimestampFixer.java，修改路径变量：

sourceDir：素材来源目录

targetRoot：整理后存放的位置

执行程序。

成功！

🧱 系统要求
Java 11 或以上

仅支持 macOS（依赖 AppleScript + Finder）

📁 示例结构（运行后效果）
swift
复制
编辑
Final Cut Original Media/
├── 2025-03-13/
│   ├── DJI_0001.MP4
│   └── IMG_4321.MOV
├── 2025-03-14/
│   └── GoPro_0423.MP4
