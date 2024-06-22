import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MacAddress
 {
    public static void main(String[] args) throws Exception
    {
			Scanner console = new Scanner(System.in);
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Address = "+address);
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            if (ni!=null)
            {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null)
                {
                    System.out.print("MAC Address : ");
                    for (int i=0;i< mac.length;i++)
                    {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" :"");
                    }
                }
                else
                {
                    System.out.println("Address doesn't exist or is not accessible");
                }
            }
            else
            {
                System.out.println("Network Interface for the specified address is not found");
            }
    }    
}