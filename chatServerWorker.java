import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class chatServerWorker extends Thread
{
    private Socket theClientSocket;
    private PrintStream clientOutput;
    private Scanner clientInput;
    private ServerManager manager;

    public chatServerWorker(Socket theClientSocket, ServerManager manager)
    {
        try 
        {
            System.out.println("Connection Established...");
            this.manager = manager;
            this.theClientSocket = theClientSocket;
            this.clientOutput = new PrintStream(this.theClientSocket.getOutputStream());    
            this.clientInput = new Scanner(this.theClientSocket.getInputStream());
        } 
        catch (Exception e) 
        {
            System.err.println("Bad things happened in thread!!!!!");
            e.printStackTrace();
        }
    }

    public void run()
    {
        //this is what the thread does
        String messages = this.manager.displayMessages().toString();
        this.clientOutput.println("Recieved messages:  "  + messages + " Type your message...");
        String name = clientInput.nextLine();
        this.manager.addString(name);
        System.out.println("read: " + name);
    }
}