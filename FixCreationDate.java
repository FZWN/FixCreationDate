import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * FixCreationDate
 *
 * 📦 Description:
 * A macOS-only utility designed to fix mismatched creation times on video and other media files,
 * helping organize files by actual shooting/editing dates rather than file copy/import dates.
 *
 * ⚙️ Features:
 * - Aligns file **creation time** with the file's **last modified time** (typical "real" timestamp)
 * - Organizes all files into folders named by date (e.g., "2025-03-13")
 * - Works with **any file type**, not just video
 * - Uses macOS Finder + AppleScript to preserve creation timestamps during copy
 * - Deletes the original file after processing (⚠ see warning below)
 *
 * 🧠 Benefits:
 * - Helps keep video files organized for easier browsing and management
 * - Essential for **Final Cut Pro** users, as FCP heavily relies on file creation time
 * - Great for importing videos from SD cards, action cameras, or inconsistent sources
 * - Prevents Finder/FCP from showing inaccurate "Date Created" (e.g., copy/import time)
 *
 * ⚠ WARNING:
 * This tool will **DELETE the original files** after processing.
 * Make sure you have backups or test on sample folders before using on real data.
 *
 * ✅ Target Audience:
 * - Final Cut Pro editors
 * - Filmmakers and content creators
 * - Anyone managing lots of photos/videos on external drives
 * - Developers who want reliable file date organization
 */
public class FixCreationDate {

    public static void main(String[] args) {
        Path sourceDir = Paths.get("/Volumes/Extreme SSD/2025/videos"); // <--- Replace with your actual folder
        Path targetRoot = Paths.get("/Volumes/Extreme SSD/Final Cut Original Media");
        Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"), "video-timestamp-fixer");

        try {
            Files.createDirectories(tempDir);
        } catch (IOException e) {
            System.err.println("❌ Failed to create temp directory: " + tempDir);
            return;
        }

        List<Path> files = getFiles(sourceDir);
        System.out.println("📂 Found " + files.size() + " files to process.");

        for (Path originalFile : files) {
            try {
                FileTime modifiedTime = Files.getLastModifiedTime(originalFile);

                // Determine folder by modification date
                LocalDate date = modifiedTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                String dateFolder = date.toString();
                Path targetFolder = targetRoot.resolve(dateFolder);
                Files.createDirectories(targetFolder);

                Path targetFile = targetFolder.resolve(originalFile.getFileName());

                // Copy to temp and align timestamps
                Path tempFile = tempDir.resolve(originalFile.getFileName());
                Files.copy(originalFile, tempFile, StandardCopyOption.REPLACE_EXISTING);
                Files.setLastModifiedTime(tempFile, modifiedTime);
                Files.setAttribute(tempFile, "lastAccessTime", modifiedTime);

                // Use Finder to copy file (preserves creation time)
                copyUsingFinder(tempFile, targetFile);

                // Clean up
                Files.deleteIfExists(tempFile);
                Files.deleteIfExists(originalFile);

                System.out.println("✅ Moved to: " + targetFile);

            } catch (Exception e) {
                System.err.println("❌ Failed to process: " + originalFile.getFileName());
                e.printStackTrace();
            }
        }

        System.out.println("🎉 All done!");
    }

    private static List<Path> getFiles(Path folder) {
        List<Path> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(folder)) {
            paths.filter(path -> {
                        try {
                            return !Files.isHidden(path);
                        } catch (IOException e) {
                            return false;
                        }
                    })
                    .filter(Files::isRegularFile)
                    .forEach(files::add);
        } catch (IOException e) {
            System.err.println("❌ Failed to read folder: " + folder);
        }
        return files;
    }

    private static void copyUsingFinder(Path source, Path target) throws IOException, InterruptedException {
        String script = String.format("""
            tell application "Finder"
                set sourceFile to POSIX file "%s" as alias
                set targetFolder to POSIX file "%s" as alias
                duplicate sourceFile to targetFolder with replacing
            end tell
            """, source.toAbsolutePath(), target.getParent().toAbsolutePath());

        ProcessBuilder pb = new ProcessBuilder("osascript", "-e", script);
        Process process = pb.inheritIO().start();
        int exitCode = process.waitFor();

        if (exitCode != 0) {
            throw new IOException("Finder copy failed with exit code: " + exitCode);
        }
    }
}
