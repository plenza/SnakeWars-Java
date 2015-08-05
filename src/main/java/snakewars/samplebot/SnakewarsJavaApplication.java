package snakewars.samplebot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.Socket;

@SpringBootApplication
@EnableAutoConfiguration
public class SnakewarsJavaApplication implements CommandLineRunner {

    @Value("${ServerHost:localhost}")
    private String server;

    @Value("${ServerPort:9977}")
    private int port;

    @Value("${LoginId:PL1}")
    private String loginId;

    private BufferedReader reader;
    private BufferedWriter writer;

    public static void main(String[] args) {
        SpringApplication.run(SnakewarsJavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(server);
        System.out.println(port);
        Socket tcpSocket = new Socket(server, port);
        try {
            reader = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(tcpSocket.getOutputStream()));

            waitForServerGreeting();

            // Send our login id.
            writeLine(loginId);

            // Read our snake id.
            String mySnakeId = readLine();
            System.out.println(String.format("My snake id: {%s}", mySnakeId));

            SnakeEngine snakeEngine = new SnakeEngine(mySnakeId);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private void waitForServerGreeting() throws IOException {
        if (!readLine().equalsIgnoreCase("id")) {
            throw new UnsupportedOperationException("Server didn't ask for my identity.");
        }
    }

    private String readLine() throws IOException {
        return reader.readLine();
    }

    private void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
        writer.flush();
    }
}
