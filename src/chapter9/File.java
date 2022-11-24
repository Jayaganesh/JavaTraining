package chapter9;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class File {
    public static void main(String[] args) throws IOException {
//        Files
//        Path

//        *** Input/Output Streams, Readers, and Writers ***

//        Read and Write using Streams

        InputStream in = Files.newInputStream(Path.of("sample.txt"));
        OutputStream out = Files.newOutputStream(Path.of("sample1.txt"));

        int data = in.read();
        while(data != -1) {
//            System.out.println((char) data);
            data = in.read();
        }
        in.close();

//        Read from URL

        var url = new URL("https://jenkov.com/tutorials/java-io/inputstream.html");
        InputStream in1 = url.openStream();
        byte[] bytes = in1.readAllBytes();
//        System.out.println(Arrays.toString(bytes));

//        Read and Write using Byte Array Streams

        byte[] bytes1 = {123, 121};
        var in2 = new ByteArrayInputStream(bytes1);
//        System.out.println(Arrays.toString(in2.readAllBytes()));

        var out1 = new ByteArrayOutputStream();
        out1.writeBytes(new byte[]{121, 120});
        byte[] bytes2 = out1.toByteArray();
//        System.out.println(Arrays.toString(bytes2));

//        Reading Bytes

//        int b = in.read();
//        byte[] bytes = in.readAllBytes();
//        byte[] bytes = Files.readAllBytes(path);

//        var bytes = new byte[len];
//        int bytesRead = in.readNBytes(bytes, offset, n);

//        long bytesToSkip = ...;
//        in.skipNBytes(bytesToSkip);

//        Writing Bytes

//        OutputStream out = ...;
//        int b = ...;
//        out.write(b);
//        byte[] bytes = ...;
//        out.write(bytes);
//        out.write(bytes, start, length);

//        try (OutputStream out = ...) {
//            out.write(bytes);
//        }

//        try (InputStream in = ...; OutputStream out = ...) {
//            in.transferTo(out);
//        }

//        Files.copy(path, out);

//        Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);

//        Character Encodings

//        new String(bytes, "UTF 8")


//        Reading text files
//
//        BufferedReader & BufferedWriter

        String fileName = "sample.txt";

        System.out.println("The old-fashioned way");
        BufferedReader is = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = is.readLine()) != null) {
//            System.out.println(line);
        }
        is.close();

//        System.out.println("The old-fashioned way");
//        BufferedReader is = Files.newBufferedReader(Path.of(fileName));
//        String line;
//        while ((line = is.readLine()) != null) {
////            System.out.println(line);
//        }
//        is.close();

        System.out.println("The old-fashioned way");
        BufferedWriter os = new BufferedWriter(new FileWriter("sample1.txt"));
//        BufferedWriter os1 = new BufferedWriter("sample1.txt");
        os.write("write");
        os.close();

//        Files.newBufferedReader
//        Files.newBufferedWriter

        InputStream in3 = Files.newInputStream(Path.of("sample.txt"));

        InputStreamReader input = new InputStreamReader(in3);

        char[] array = new char[100];
        input.read(array);
        System.out.println("Input stream reader");
        System.out.println(array);

        input.close();


//        Random-Access Files

        var file = new RandomAccessFile("sample.txt", "rw");

        int value = file.readInt();
        file.seek(file.getFilePointer() - 4);
        file.writeInt(value + 1);

//        Memory-Mapped Files

//        FileChannel channel = FileChannel.open(path,
//                StandardOpenOption.READ, StandardOpenOption.WRITE)


//        ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,
//                0, channel.size());


//        File Locking

//        FileChannel channel = FileChannel.open(path, StandardOpenOption.WRITE);
//        FileLock lock = channel.lock();

//        FileLock lock = channel.tryLock();

//        try (FileLock lock = channel.lock()) {
//    ...
//        }



//        *** Paths, Files, and Directories ***
//        Paths


        Path absolute = Path.of("/", "home", "jg");
        Path relative = Path.of("myapp", "conf", "user.properties");

        System.out.println(absolute.toFile());
        System.out.println(relative.toFile());

        Path homeDirectory = Path.of("/home/jg");
        Path workPath = homeDirectory.resolve("myapp/work");
        Path tempPath = workPath.resolveSibling("temp");

        System.out.println(workPath.toFile());
        System.out.println(tempPath.toFile());

        Path.of("/home/jg").relativize(Path.of("/home/fred/myapp"));

//        Creating Files and Directories

//        Files.createDirectory(Path.of("jg"));
//        Files.createFile(Path.of("test.txt);

//        Files.exists(Path.of("test.txt))

//        Files.isDirectory(Path.of("test.txt))
//        Files.isRegularFile(Path.of("test.txt))

//        Path tempFile = Files.createTempFile(dir, prefix, suffix);
//        Path tempFile = Files.createTempFile(prefix, suffix);
//        Path tempDir = Files.createTempDirectory(dir, prefix);
//        Path tempDir = Files.createTempDirectory(prefix);

//        Copying, Moving, and Deleting Files

//        Files.copy(fromPath, toPath);
//        Files.move(fromPath, toPath);

//        Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING,
//                StandardCopyOption.COPY_ATTRIBUTES);

//        Files.move(fromPath, toPath, StandardCopyOption.ATOMIC_MOVE);

//        Files.delete(path);

//        boolean deleted = Files.deleteIfExists(path);

//        ZIP File Systems

//        FileSystem zipfs = FileSystems.newFileSystem(Path.of("zipname.zip"));

//        Files.copy(zipfs.getPath(sourceName), targetPath);

//        Files.walk(zipfs.getPath("/")).forEach(p -> {
//            Process p
//        });

//        Path zipPath = Path.of("myfile.zip");
//        var uri = new URI("jar", zipPath.toUri().toString(), null);
//        // Constructs the URI jar:file://myfile.zip
//        try (FileSystem zipfs = FileSystems.newFileSystem(uri,
//                Collections.singletonMap("create", "true"))) {
//            // To add files, copy them into the ZIP file system
//            Files.copy(sourcePath, zipfs.getPath("/").resolve(targetPath));
//        }


//        Files.lines(Path.of("sample.txt") => Stream<String>
//        Files.readAllLines(Path.of("sample.txt")) => List<String>
//        Files.list(Path.of("JG")) => Stream<Path>
//        Files.walk(Path.of("sample.txt")) =>
//        Files.find()



    }


}
