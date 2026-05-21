import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class ARPExample {
    public static void main(String[] args) {
        try {
            String ip = "192.168.1.1";
            
            InetAddress address = InetAddress.getByName(ip);
            System.out.println("Pinging " + ip + "...");
            if (address.isReachable(3000)) {
                System.out.println("Host is reachable.");
            } else {
                System.out.println("Host is NOT reachable.");
            }

           
            String command = "arp -a " + ip;
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("\nARP Table Entry:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}